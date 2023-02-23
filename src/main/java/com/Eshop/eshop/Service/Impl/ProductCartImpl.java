package com.Eshop.eshop.Service.Impl;

import com.Eshop.eshop.Dto.ProductCartDTO;
import com.Eshop.eshop.Dto.ProductDTO;
import com.Eshop.eshop.Service.IProductCartService;
import com.Eshop.eshop.domain.Product;
import com.Eshop.eshop.domain.ProductCart;
import com.Eshop.eshop.repositories.ProductCartRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class ProductCartImpl implements IProductCartService {
    ModelMapper modelMapper;
    ProductCartRepository productCartRepository;

    public ProductCartImpl(ModelMapper modelMapper, ProductCartRepository productCartRepository) {
        this.modelMapper = modelMapper;
        this.productCartRepository = productCartRepository;
    }

    @Override
    public List<ProductCartDTO> getAllProductCarts() {
      return productCartRepository.findAll().stream().map(c->toDto(c)).collect(Collectors.toList());
    }

    @Override
    public ProductCartDTO addItem(ProductCartDTO productCartDTO) {
       return toDto(productCartRepository.save(toDomain(productCartDTO)));
    }


    public ProductCart toDomain(ProductCartDTO productCartDTO){
        return modelMapper.map(productCartDTO,ProductCart.class);
    }
    public  ProductCartDTO toDto(ProductCart productCart){

        return modelMapper.map(productCart,ProductCartDTO.class);
    }
}
