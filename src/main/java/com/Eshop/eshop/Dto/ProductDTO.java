package com.Eshop.eshop.Dto;

import com.Eshop.eshop.domain.Category;
import com.Eshop.eshop.domain.Model;
import com.Eshop.eshop.domain.ProductCart;
import lombok.*;

import javax.persistence.*;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProductDTO {
    private Long id;
    private Model model;
    private  String productName;
    private  Double cost;
    private   Double price;
    private   String image;
    private  Double stock;
    Category category;
    private Boolean isActive;

}
