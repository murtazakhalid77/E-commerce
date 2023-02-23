package com.Eshop.eshop.Controller;

import com.Eshop.eshop.Dto.CouponDTO;
import com.Eshop.eshop.Service.ICouponService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api")
@Controller
public class CouponController {

    ICouponService ICouponService;

    public CouponController(ICouponService ICouponService) {
        this.ICouponService = ICouponService;
    }

    @GetMapping("/coupon")
    ResponseEntity<List<CouponDTO>> getAllCoupons(){
      return ResponseEntity.ok(ICouponService.getAllCoupons());
    }
    @PostMapping("/coupon")
    ResponseEntity<CouponDTO> addCoupon(@RequestBody CouponDTO couponDTO){
        return  ResponseEntity.ok(ICouponService.addCoupon(couponDTO));
    }
    @GetMapping("/coupon/{id}")
    ResponseEntity<CouponDTO> getCouponById(@PathVariable Long id){
        return  ResponseEntity.ok(ICouponService.getCouponById(id));
    }

    @PatchMapping("/coupon/{id}")
    ResponseEntity<CouponDTO> updateCouponbyId(@PathVariable Long id, @RequestBody Map<String, Object> fields){
        return  ResponseEntity.ok(ICouponService.updateCategoryById(id,fields));
    }
    @PutMapping("/coupon/{id}")
    ResponseEntity<CouponDTO> deleteCouponById(@PathVariable Long id){
        return  ResponseEntity.ok(ICouponService.deleteCouponById(id));
    }



}
