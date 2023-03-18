package com.Eshop.eshop.Dto;

import com.Eshop.eshop.CustomValidation.UniqueEmail;
import com.Eshop.eshop.CustomValidation.UniqueUserName;
import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserDTO {
    private Long id;
    @UniqueUserName
    private String name;
    private String password;
    @UniqueEmail
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
    private  String email;
    private String PhoneNumber;
    private Boolean isActive;
}

