package com.Eshop.eshop.repositories;

import com.Eshop.eshop.domain.Category;
import com.Eshop.eshop.domain.Model;
import com.Eshop.eshop.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByProductNameAndModel(String productName, Model model);

    List<Product> findAllByIsActive(Boolean isActive);

}
