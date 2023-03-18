package com.Eshop.eshop.Service.Impl;

import com.Eshop.eshop.Dto.CouponDTO;
import com.Eshop.eshop.Exception.RecordAlreadyExistException;
import com.Eshop.eshop.Exception.RecordNotFoundException;
import com.Eshop.eshop.Service.ICouponService;
import com.Eshop.eshop.domain.Category;
import com.Eshop.eshop.domain.Coupon;
import com.Eshop.eshop.repositories.CouponRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CouponServiceImpl implements ICouponService {
    ModelMapper modelMapper;
    CouponRepository  couponRepository;

    public CouponServiceImpl(ModelMapper modelMapper, CouponRepository couponRepository) {
        this.modelMapper = modelMapper;
        this.couponRepository=couponRepository;

    }

    @Override
    public List<CouponDTO> getAllCoupons() {
      return this.couponRepository.findAll().stream().map(c->toDto(c)).collect(Collectors.toList());
    }

    @Override
    public CouponDTO addCoupon(CouponDTO couponDTO) {
        Coupon dublicateCoupon = couponRepository.findBycouponCode(couponDTO.getCouponCode());
        if (dublicateCoupon!=null){
            if (!dublicateCoupon.getIsActive()){
                dublicateCoupon.setIsActive(true);
                return toDto(couponRepository.save(dublicateCoupon));
            }
            throw new RecordAlreadyExistException(String.format("Record Already Exist =>%s",couponDTO));
        }
        couponDTO.setIsActive(true);
        return toDto(couponRepository.save(toDomain(couponDTO)));

    }

    @Override
    public CouponDTO getCouponById(Long id) {
        Optional<Coupon> coupon = couponRepository.findById(id);
        if (coupon.isPresent()){
            return toDto(coupon.get());
        }

        throw new RecordNotFoundException(String.format("Coupon Not Found On this Id => %d",id));


    }

    @Override
    public CouponDTO deleteCouponById(Long id) {
        Optional<Coupon> coupon = couponRepository.findById(id);
        if (coupon.isPresent()){
            if (!coupon.get().getIsActive()){
                coupon.get().setIsActive(true);
                return toDto(couponRepository.save(coupon.get()));
            }
            coupon.get().setIsActive(false);
            return toDto(couponRepository.save(coupon.get()));
        }
        throw new RecordNotFoundException(String.format("Coupon Not Found On this Id => %d",id));
    }

    @Override
    public List<CouponDTO> getCouponBySearch(String couponCode) {
        Optional<List<Coupon>> foundedCoupons = couponRepository.searchByCouponCode(couponCode);
        if (foundedCoupons!=null){
            return foundedCoupons.get().stream().map(c->toDto(c)).collect(Collectors.toList());
        }
        throw new RecordNotFoundException(String.format("The coupon %s is not available" +couponCode));
    }

    @Override
    public CouponDTO updateCouponById(Long id, Map<String, Object> fields) {
        Coupon coupon = couponRepository.findById(id).get();
        fields.forEach((key,value)->{
            Field field = ReflectionUtils.findField(Coupon.class,key);

            field.setAccessible(Boolean.TRUE);
            ReflectionUtils.setField(field,coupon,value);
        });
        return toDto(couponRepository.save(coupon));
    }


    public Coupon toDomain(CouponDTO couponDTO){
        return modelMapper.map(couponDTO,Coupon.class);
    }
    public  CouponDTO toDto(Coupon coupon){
        return modelMapper.map(coupon,CouponDTO.class);
    }


}
