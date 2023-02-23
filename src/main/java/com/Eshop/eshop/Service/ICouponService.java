package com.Eshop.eshop.Service;

import com.Eshop.eshop.Dto.CouponDTO;

import java.util.List;
import java.util.Map;

public interface ICouponService {

    List<CouponDTO> getAllCoupons();

    CouponDTO addCoupon(CouponDTO couponDTO);

    CouponDTO getCouponById(Long id);

    CouponDTO updateCategoryById(Long id,Map<String, Object> fields);

    CouponDTO deleteCouponById(Long id);
}
