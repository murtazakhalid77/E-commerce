package com.Eshop.eshop.repositories;

import com.Eshop.eshop.domain.Customer;
import com.Eshop.eshop.domain.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ModelRepository extends JpaRepository<Model, Long> {
    Model findBymodelName(String modelName);

    List<Model> findAllByIsActive(Boolean isActive);
}
