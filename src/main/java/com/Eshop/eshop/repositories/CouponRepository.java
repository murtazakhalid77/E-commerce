package com.Eshop.eshop.repositories;

import com.Eshop.eshop.Dto.CouponDTO;
import com.Eshop.eshop.domain.Category;
import com.Eshop.eshop.domain.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface CouponRepository extends JpaRepository<Coupon, Long> {
    public List<Coupon> findAllByisActive(Boolean isActive);

    Coupon findBycouponCode(String categoryName);
}
