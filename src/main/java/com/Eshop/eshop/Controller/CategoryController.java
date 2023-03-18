package com.Eshop.eshop.Controller;
import com.Eshop.eshop.Dto.CategoryDTO;
import com.Eshop.eshop.Service.*;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api")
@Controller
public class CategoryController {
    private final ICategoryService categoryService;

    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @GetMapping("/category")
    private ResponseEntity<List<CategoryDTO>> getAll(){
        return ResponseEntity.ok(categoryService.getAllCategory());
    }
    @PostMapping("/category")
    private ResponseEntity<CategoryDTO> addCategory(@Valid @RequestBody CategoryDTO categoryDTO) {
        return ResponseEntity.ok(categoryService.addCategory(categoryDTO));
    }

    @GetMapping("/category/{id}")
    private ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }

    @PatchMapping("/category/{id}")
    private ResponseEntity<CategoryDTO> updateCategoryById(@PathVariable Long id, @RequestBody Map<String, Object> fields) {
        return ResponseEntity.ok(categoryService.updateCategoryById(id,fields));
    }
    @DeleteMapping  ("/category/{id}")
    private ResponseEntity<CategoryDTO> deleteCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.deleteCategoryId(id));
    }
        @GetMapping("/searchCategory/{searchCategory}")
    private ResponseEntity<List<CategoryDTO>> getCatgoryBySearch(@PathVariable String searchByName) {
        return ResponseEntity.ok(categoryService.getCategoryBySearch(searchByName));
    }
}
