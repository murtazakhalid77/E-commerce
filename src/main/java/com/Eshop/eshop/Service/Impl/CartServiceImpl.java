package com.Eshop.eshop.Service.Impl;

import com.Eshop.eshop.Dto.CartDTO;
import com.Eshop.eshop.Dto.CouponDTO;
import com.Eshop.eshop.Exception.RecordAlreadyExistException;
import com.Eshop.eshop.Service.ICartService;
import com.Eshop.eshop.domain.Cart;
import com.Eshop.eshop.domain.Coupon;
import com.Eshop.eshop.repositories.CartRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements ICartService {
    ModelMapper modelMapper;
    CartRepository cartRepository;
    public CartServiceImpl(ModelMapper modelMapper, CartRepository cartRepository) {
        this.modelMapper = modelMapper;
        this.cartRepository = cartRepository;
    }
    @Override
    public List<CartDTO> getAllCarts() {
        return this.cartRepository.findAll().stream().map(c->toDto(c)).collect(Collectors.toList());
    }


    @Override
    public CartDTO addCart(CartDTO cartDTO) {
        cartDTO.setDate(LocalDate.now());
        return toDto(cartRepository.save(toDomain(cartDTO)));
    }
    public Cart toDomain(CartDTO cartDTO){
        return modelMapper.map(cartDTO,Cart.class);
    }
    public  CartDTO toDto(Cart cart){
        return modelMapper.map(cart,CartDTO.class);
    }

}
