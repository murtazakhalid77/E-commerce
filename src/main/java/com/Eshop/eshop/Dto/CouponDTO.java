package com.Eshop.eshop.Dto;

import com.Eshop.eshop.domain.Cart;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
//@JsonIgnoreProperties(value = {"productList"})
public class CouponDTO {


    private  Long Id;
    private   String couponCode;
    private  Double discount;
    private Boolean isPercentage;
    private Boolean isActive;
}

