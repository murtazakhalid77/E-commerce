package com.Eshop.eshop.domain;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
@Data
@Entity
public class ProductCart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="productId",referencedColumnName = "id")
    private  Product product;

    @ManyToOne
    @JoinColumn(name="cartId",referencedColumnName = "id")
    private  Cart cart;
  private   Long quantity;
  private Double Cost;
  private Double price;


}
