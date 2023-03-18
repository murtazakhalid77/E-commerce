package com.Eshop.eshop.repositories;

import com.Eshop.eshop.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface CategoryRepository extends JpaRepository<Category, Long> {
     Category findByCategorName(String categoryName);

   List<Category> findAllByIsActive(Boolean isActive);
   // value = "select sum(quantity*price) as TotalAmount from product_cart where cart_id=:id",nativeQuery = true
   @Query(value = "select * from category c where c.categor_Name like %?% ",nativeQuery = true)
    Optional<List<Category>> searchByCategoryName(@Param("searchByName") String searchByName);
}
