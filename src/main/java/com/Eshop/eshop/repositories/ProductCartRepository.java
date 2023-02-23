package com.Eshop.eshop.repositories;

import com.Eshop.eshop.domain.Cart;
import com.Eshop.eshop.domain.Product;
import com.Eshop.eshop.domain.ProductCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface ProductCartRepository extends JpaRepository<ProductCart,Long> {
    Optional<ProductCart> findProductCartByCartAndProduct(Cart cart, Product product);
}
