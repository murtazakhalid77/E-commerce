package com.Eshop.eshop.repositories;

import com.Eshop.eshop.Dto.CustomerDTO;
import com.Eshop.eshop.domain.Category;
import com.Eshop.eshop.domain.Coupon;
import com.Eshop.eshop.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByemail(String categoryName);

    List<Customer> findAllByIsActive(Boolean isActive);

}
