package com.Eshop.eshop.Service.Impl;

import com.Eshop.eshop.Dto.CategoryDTO;
import com.Eshop.eshop.Exception.RecordAlreadyExistException;
import com.Eshop.eshop.Exception.RecordNotFoundException;
import com.Eshop.eshop.Service.ICategoryService;
import com.Eshop.eshop.domain.Category;
import com.Eshop.eshop.repositories.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CartegoryServiceImplI implements ICategoryService {
    private final CategoryRepository categoryRepository;
    @Autowired
    ModelMapper modelMapper;

    public CartegoryServiceImplI(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CategoryDTO getCategoryById(Long id) {
         Optional<Category> foundCat =   categoryRepository.findById(id);
         if (foundCat.isPresent()){
             return toDto(foundCat.get());
         }
         else {
              throw new RecordNotFoundException(String.format("Category Not Found On this Id => %d",id));
         }
    }
    @Override
    public CategoryDTO addCategory(CategoryDTO categoryDTO) {
        Category dublicateCat = categoryRepository.findByCategorName(categoryDTO.getCategorName());
        if (dublicateCat!=null){
            if (!dublicateCat.getIsActive()){
               dublicateCat.setIsActive(true);
               return toDto(categoryRepository.save(dublicateCat));
            }
            throw new RecordAlreadyExistException(String.format("Record Already Exist =>%s",categoryDTO));
        }

        categoryDTO.setIsActive(true);
        return toDto(categoryRepository.save(toDomain(categoryDTO)));
    }
    @Override
    public List<CategoryDTO> getAllCategory() {
      return   categoryRepository.findAll().stream().map(c->toDto(c)).collect(Collectors.toList());
    }

    @Override
    public CategoryDTO updateCategoryById(Long id, Map<String,Object> fields) {
           Category category = categoryRepository.findById(id).get();
            fields.forEach((key,value)->{
                    Field field = ReflectionUtils.findField(Category.class,key);

                field.setAccessible(Boolean.TRUE);
                ReflectionUtils.setField(field,category,value);
            });
            return toDto(categoryRepository.save(category));

    }

    @Override
    public List<CategoryDTO> getCategoryBySearch(String searchByName) {
         Optional<List<Category>> foundedCategory = categoryRepository.searchByCategoryName(searchByName);
         if (foundedCategory!=null){
             return foundedCategory.get().stream().map(c->toDto(c)).collect(Collectors.toList());
         }
         throw new RecordNotFoundException(String.format("The category %s is not available" +searchByName));
    }

    @Override
    public CategoryDTO deleteCategoryId(Long id) {
      Optional<Category> category = categoryRepository.findById(id);
       if (category.isPresent()){
           category.get().setIsActive(false);
           return toDto(categoryRepository.save(category.get()));
       }
        throw new RecordNotFoundException(String.format("Category Not Found On this Id => %d",id));
    }

    public  Category toDomain(CategoryDTO categoryDTO){
        return modelMapper.map(categoryDTO,Category.class);
    }
    public  CategoryDTO toDto(Category category){
        return modelMapper.map(category,CategoryDTO.class);
    }


//    public Category toDomain(CategoryDTO categoryDTO){
//        return Category.builder()
//                .id(categoryDTO.getId())
//                .categorName(categoryDTO.getCategorName())
//                .productList(categoryDTO.getProductList())
//                .isActive(categoryDTO.getIsActive())
//                .build();
//    }
//
//    public CategoryDTO toDto(Category category){
//        return CategoryDTO.builder()
//                .id(category.getId())
//                .categorName(category.getCategorName())
//                .productList(category.getProductList())
//                .isActive(category.getIsActive())
//                .build();
//    }
}
