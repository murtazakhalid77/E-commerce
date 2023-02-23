package com.Eshop.eshop.repositories;

import com.Eshop.eshop.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface CategoryRepository extends JpaRepository<Category, Long> {
     Category findByCategorName(String categoryName);

   List<Category> findAllByIsActive(Boolean isActive);
}
