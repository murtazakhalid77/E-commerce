package com.Eshop.eshop.Controller;

import com.Eshop.eshop.Dto.CouponDTO;
import com.Eshop.eshop.Dto.ProductDTO;
import com.Eshop.eshop.Service.ICouponService;
import com.Eshop.eshop.Service.IProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api")
@Controller
public class ProductController {
    IProductService productService;
    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product")
    ResponseEntity<List<ProductDTO>> getAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }
    @PostMapping("/product")
    ResponseEntity<ProductDTO> addProduct(@Valid @RequestBody ProductDTO productDTO) {
        return  ResponseEntity.ok(productService.addProduct(productDTO));
    }
    @GetMapping("/product/{id}")
    ResponseEntity<ProductDTO> getProductById(@PathVariable Long id){
        return  ResponseEntity.ok(productService.getProductById(id));
    }

    @PatchMapping("/product/{id}")
    ResponseEntity<ProductDTO> updateProductyId(@PathVariable Long id, @RequestBody Map<String, Object> fields){
        return  ResponseEntity.ok(productService.updateProductrById(id,fields));
    }
    @PutMapping("/product/{id}")
    ResponseEntity<ProductDTO> deleteProductById(@PathVariable Long id){
        return  ResponseEntity.ok(productService.deleteProductById(id));
    }

}
