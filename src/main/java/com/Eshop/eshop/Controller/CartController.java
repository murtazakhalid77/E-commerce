package com.Eshop.eshop.Controller;

import com.Eshop.eshop.Dto.CartDTO;
import com.Eshop.eshop.Dto.CategoryDTO;
import com.Eshop.eshop.Service.ICartService;
import com.Eshop.eshop.Service.ICategoryService;
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
public class CartController {
    private final ICartService cartService;
    public CartController(ICartService cartService) {
        this.cartService = cartService;
    }


    @GetMapping("/cart")
    private ResponseEntity<List<CartDTO>> getAll(){
        return ResponseEntity.ok(cartService.getAllCarts());
    }
    @PostMapping("/cart")
    private ResponseEntity<CartDTO> addCart(@RequestBody CartDTO cartDTO) {
        return ResponseEntity.ok(cartService.addCart(cartDTO));
    }
}

//    @GetMapping("/cart/{id}")
//    private ResponseEntity<CartDTO> getCartById(@PathVariable Long id) {
//        return ResponseEntity.ok(ICategoryService.getCartById(id));
//    }
//
//    @PatchMapping("/cart/{id}")
//    private ResponseEntity<CartDTO> updateCartById(@PathVariable Long id, @RequestBody Map<String, Object> fields) {
//        return ResponseEntity.ok(ICategoryService.updateCartById(id,fields));
//    }
//    @PutMapping("/cart/{id}")
//    private ResponseEntity<CartDTO> deleteCartById(@PathVariable Long id) {
//        return ResponseEntity.ok(ICategoryService.deleteCartId(id));
//    }
//}
