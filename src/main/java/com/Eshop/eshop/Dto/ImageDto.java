package com.Eshop.eshop.Dto;

import com.Eshop.eshop.domain.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ImageDto {
    private  Long id;
    private String imageName;
    private String type;
    private byte[] imageDate;
    Product product;
}
