package com.Eshop.eshop.Dto;

import com.Eshop.eshop.domain.Coupon;
import com.Eshop.eshop.domain.Customer;
import com.Eshop.eshop.domain.ProductCart;
import com.Eshop.eshop.domain.Transaction;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CartDTO {
    private  Long id;
    private LocalDate date;
    private String deviceAddress;
    private Customer customer;
    private Coupon coupon;

}
