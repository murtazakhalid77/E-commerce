package com.Eshop.eshop.Dto;

import com.Eshop.eshop.domain.Product;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ModelDTO {

    private Long id;
    private String modelName;
    private Boolean isActive;

}
