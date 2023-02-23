package com.Eshop.eshop.Service;

import com.Eshop.eshop.Dto.CartDTO;
import com.Eshop.eshop.Dto.ModelDTO;

import java.util.List;

public interface ICartService {
    List<CartDTO> getAllCarts();

    CartDTO addCart(CartDTO cartDTO);
}
