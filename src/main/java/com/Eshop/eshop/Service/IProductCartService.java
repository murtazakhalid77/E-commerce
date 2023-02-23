package com.Eshop.eshop.Service;

import com.Eshop.eshop.Dto.ProductCartDTO;

import java.util.List;

public interface IProductCartService {
   List<ProductCartDTO> getAllProductCarts();
   ProductCartDTO addItem(ProductCartDTO productCartDTO);
}
