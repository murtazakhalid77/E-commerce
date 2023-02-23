package com.Eshop.eshop.Controller;

import com.Eshop.eshop.Dto.ProductCartDTO;
import com.Eshop.eshop.Dto.ProductDTO;
import com.Eshop.eshop.Service.IProductCartService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
@Controller
public class ProductCartController {
    IProductCartService productCartService;

    public ProductCartController(IProductCartService productCartService) {
        this.productCartService = productCartService;
    }

    @GetMapping("/productCart")
    ResponseEntity<List<ProductCartDTO>> getAllProductCarts(){
        return ResponseEntity.ok(productCartService.getAllProductCarts());
    }
    @PostMapping("/productCart")
    ResponseEntity<ProductCartDTO> addProduct(@RequestBody ProductCartDTO productCartDTO){
            return  ResponseEntity.ok(productCartService.addItem(productCartDTO));
    }

}
