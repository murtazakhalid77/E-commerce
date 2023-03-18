package com.Eshop.eshop.repositories;

import com.Eshop.eshop.domain.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageRepository extends JpaRepository<Image,Long> {
    Optional<Image> findImageByImageName(String imageName);
}
