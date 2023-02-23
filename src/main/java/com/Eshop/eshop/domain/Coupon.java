package com.Eshop.eshop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
@Data
@Entity
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long Id;
    private   String couponCode;
    private  Double discount;
    private Boolean isPercentage;
    @JsonIgnore
    @OneToMany(mappedBy = "coupon" )
    List<Cart> cartList;
    private Boolean isActive;
}
