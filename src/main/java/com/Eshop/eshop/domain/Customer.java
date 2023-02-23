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
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    private String email;
    private String name;
    private String number;
    private String address;
    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    List<Cart> cartList;
    private Boolean isActive;
}
