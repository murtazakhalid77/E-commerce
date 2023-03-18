package com.Eshop.eshop.Service;

import com.Eshop.eshop.Dto.CategoryDTO;

import java.util.List;
import java.util.Map;


public interface ICategoryService {

    CategoryDTO getCategoryById(Long id);

    CategoryDTO addCategory(CategoryDTO categoryDTO);

    List<CategoryDTO> getAllCategory();

    CategoryDTO deleteCategoryId(Long id);

    CategoryDTO updateCategoryById(Long id,Map<String,Object> fields);

    List<CategoryDTO> getCategoryBySearch(String searchByName);
}
