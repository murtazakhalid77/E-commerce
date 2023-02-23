package com.Eshop.eshop.repositories;

import com.Eshop.eshop.domain.Coupon;
import com.Eshop.eshop.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {
    public List<User> findAllByisActive(Boolean isActive);


    User findUserByEmailAndPhoneNumber(String userName,String phoneNumber);
}
