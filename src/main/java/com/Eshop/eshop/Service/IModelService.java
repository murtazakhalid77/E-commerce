package com.Eshop.eshop.Service;

import com.Eshop.eshop.Dto.CustomerDTO;
import com.Eshop.eshop.Dto.ModelDTO;

import java.util.List;
import java.util.Map;

public interface IModelService {
    List<ModelDTO> getAllModels();

    ModelDTO addModel(ModelDTO modelDTO);

    ModelDTO getModelById(Long id);

    ModelDTO updateModelrById(Long id, Map<String, Object> fields);

    ModelDTO changeAvailabilityById(Long id);

    List<ModelDTO> searchModel(String modelName);
}

