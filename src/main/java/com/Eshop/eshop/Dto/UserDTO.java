package com.Eshop.eshop.Dto;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserDTO {
    private Long id;
    private String name;
    private String password;
    private  String email;
    private String PhoneNumber;
    private Boolean isActive;
}

