package com.Eshop.eshop.Service.Impl;

import com.Eshop.eshop.Dto.CustomerDTO;
import com.Eshop.eshop.Dto.ModelDTO;
import com.Eshop.eshop.Exception.RecordAlreadyExistException;
import com.Eshop.eshop.Exception.RecordNotFoundException;
import com.Eshop.eshop.Service.IModelService;
import com.Eshop.eshop.domain.Coupon;
import com.Eshop.eshop.domain.Customer;
import com.Eshop.eshop.domain.Model;
import com.Eshop.eshop.repositories.ModelRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class ModelServiceImpl implements IModelService {

    ModelRepository modelRepository;
    ModelMapper modelMapper;

    public ModelServiceImpl(ModelRepository modelRepository, ModelMapper modelMapper) {
        this.modelRepository = modelRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ModelDTO> getAllModels() {
        return modelRepository.findAll().stream().map(c->toDto(c)).collect(Collectors.toList());
    }

    @Override
    public ModelDTO addModel(ModelDTO modelDTO) {
        Model dublicateModel = modelRepository.findBymodelName(modelDTO.getModelName());
        if (dublicateModel!=null){
            if (!dublicateModel.getIsActive()){
                dublicateModel.setIsActive(true);
                return toDto(modelRepository.save(dublicateModel));
            }else {
                throw new RecordAlreadyExistException(String.format("Model Already Exist =>%s",dublicateModel));
            }
        }
        else {
            modelDTO.setIsActive(true);
            return toDto(modelRepository.save(toDomain(modelDTO)));
        }
    }

    @Override
    public ModelDTO getModelById(Long id) {
        Optional<Model> model = modelRepository.findById(id);
        if (model.isPresent()){
            return toDto(model.get());
        }

        throw new RecordNotFoundException(String.format("Model Not Found On this Id => %d",id));
    }

    @Override
    public ModelDTO updateModelrById(Long id, Map<String, Object> fields) {
        Model model = modelRepository.findById(id).get();
        fields.forEach((key,value)->{
            Field field = ReflectionUtils.findField(Model.class,key);

            field.setAccessible(Boolean.TRUE);
            ReflectionUtils.setField(field,model,value);
        });
        return toDto(modelRepository.save(model));
    }

    @Override
    public ModelDTO changeAvailabilityById(Long id) {
        Optional<Model> model = modelRepository.findById(id);
        if (model.isPresent()){
            if(!model.get().getIsActive()){
                model.get().setIsActive(true);
                return toDto(modelRepository.save(model.get()));
            }
            model.get().setIsActive(false);
            return toDto(modelRepository.save(model.get()));
        }
        throw new RecordNotFoundException(String.format("model Not Found On this Id => %d",id));
    }

    @Override
    public List<ModelDTO> searchModel(String modelName) {
        Optional<List<Model>> models = modelRepository.searchByName(modelName);
        if (modelName != null) {
            return models.get().stream().map(c->toDto(c)).collect(Collectors.toList());
        }
        throw new RecordNotFoundException("The model you are searching does Not Exists");
    }


    public Model toDomain(ModelDTO modelDTO){
        return modelMapper.map(modelDTO,Model.class);
    }
    public  ModelDTO toDto(Model model){
        return modelMapper.map(model,ModelDTO.class);
    }

}
