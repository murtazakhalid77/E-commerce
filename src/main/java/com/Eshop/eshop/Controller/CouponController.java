package com.Eshop.eshop.Controller;

import com.Eshop.eshop.Dto.CategoryDTO;
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

    ICouponService couponService;

    public CouponController(ICouponService couponService) {
        this.couponService = couponService;
    }

    @GetMapping("/coupon")
    ResponseEntity<List<CouponDTO>> getAllCoupons(){
      return ResponseEntity.ok(couponService.getAllCoupons());
    }
    @PostMapping("/coupon")
    ResponseEntity<CouponDTO> addCoupon(@RequestBody CouponDTO couponDTO){
        return  ResponseEntity.ok(couponService.addCoupon(couponDTO));
    }
        @GetMapping("/coupon/{id}")
    ResponseEntity<CouponDTO> getCouponById(@PathVariable Long id){
        return  ResponseEntity.ok(couponService.getCouponById(id));
    }

    @PatchMapping("/coupon/{id}")
    ResponseEntity<CouponDTO> updateCouponbyId(@PathVariable Long id, @RequestBody Map<String, Object> fields){
        return  ResponseEntity.ok(couponService.updateCouponById(id,fields));
    }
    @PutMapping("/coupon/{id}")
    ResponseEntity<CouponDTO> deleteCouponById(@PathVariable Long id){
        return  ResponseEntity.ok(couponService.deleteCouponById(id));
    }

    @GetMapping("/searchCoupon/{couponCode}")
    private ResponseEntity<List<CouponDTO>> getCouponBySearch(@PathVariable("couponCode") String couponCode) {
        return ResponseEntity.ok(couponService.getCouponBySearch(couponCode));
    }

}
