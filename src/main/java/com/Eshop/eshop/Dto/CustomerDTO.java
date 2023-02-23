package com.Eshop.eshop.Dto;

import com.Eshop.eshop.domain.Cart;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CustomerDTO {

    private  Long id;
    private String email;
    private String name;
    private String number;
    private String address;

    private Boolean isActive;
}
