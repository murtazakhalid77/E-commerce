package com.Eshop.eshop.Dto;

import com.Eshop.eshop.domain.Cart;
import com.Eshop.eshop.domain.Product;
import lombok.*;

import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProductCartDTO {
    private Long id;
    private Product product;
    private Cart cart;
    private Double Cost;
    private Double price;
    private   Long quantity;
}
