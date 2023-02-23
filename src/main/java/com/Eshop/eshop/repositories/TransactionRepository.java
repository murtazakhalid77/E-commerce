package com.Eshop.eshop.repositories;

import com.Eshop.eshop.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    @Query(value = "select sum(quantity*price) as TotalAmount from product_cart where cart_id=:id",nativeQuery = true)
    Double getTotal(@Param("id") Long id);
}
