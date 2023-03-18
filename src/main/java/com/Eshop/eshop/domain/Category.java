package com.Eshop.eshop.domain;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
@Data
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;

    @NotBlank(message = "Category Name should Not be blank")
    private String categorName;
    private Boolean isActive;
    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private List<Product>  productList;


}
