package com.Eshop.eshop.Controller;

import com.Eshop.eshop.Dto.CategoryDTO;
import com.Eshop.eshop.Dto.ModelDTO;
import com.Eshop.eshop.Service.ICategoryService;
import com.Eshop.eshop.Service.IModelService;
import com.Eshop.eshop.domain.Model;
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
public class ModelController {

    IModelService modelService;

    public ModelController(IModelService modelService) {
        this.modelService = modelService;
    }

    @GetMapping("/model")
    private ResponseEntity<List<ModelDTO>> getAll() {
        return ResponseEntity.ok(modelService.getAllModels());
    }

    @PostMapping("/model")
    private ResponseEntity<ModelDTO> addModel(@Valid @RequestBody ModelDTO modelDTO) {
        return ResponseEntity.ok(modelService.addModel(modelDTO));
    }

    @GetMapping("/model/{id}")
    private ResponseEntity<ModelDTO> getModelById(@PathVariable Long id) {
        return ResponseEntity.ok(modelService.getModelById(id));
    }

    @PatchMapping("/model/{id}")
    private ResponseEntity<ModelDTO> updateModelById(@PathVariable Long id, @RequestBody Map<String, Object> fields) {
        return ResponseEntity.ok(modelService.updateModelrById(id, fields));
    }

    @PutMapping("/model/{id}")
    private ResponseEntity<ModelDTO> changeAvailability(@PathVariable Long id) {
        return ResponseEntity.ok(modelService.changeAvailabilityById(id));
    }

    @GetMapping("/searchModel/{modelName}")
    private ResponseEntity<List<ModelDTO>> searchModel(@PathVariable("modelName") String modelName) {
        return ResponseEntity.ok(modelService.searchModel(modelName));

    }

}
