package com.Eshop.eshop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Product {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
   @ManyToOne
   @JoinColumn(name="modelId",referencedColumnName = "id")
    private Model model;
    private  String productName;
    private  Double cost;
    private   Double price;
    private   String image;
    private  Double stock;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<ProductCart> productCartList;
    @ManyToOne
    @JoinColumn(name = "categoryId",referencedColumnName = "id")
    Category category;
    private Boolean isActive;

}
