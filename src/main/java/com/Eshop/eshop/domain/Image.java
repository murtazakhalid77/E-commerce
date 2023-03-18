package com.Eshop.eshop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
@Data
@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    private String imageName;
    private String type;
    @Lob
    @Column(length = 1000)
    private byte[] imageData;

    @OneToOne(mappedBy = "image",cascade = CascadeType.ALL)
    @JsonIgnore
  private   Product product;

}
