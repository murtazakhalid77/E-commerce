package com.Eshop.eshop.repositories;

import com.Eshop.eshop.Dto.ModelDTO;
import com.Eshop.eshop.domain.Category;
import com.Eshop.eshop.domain.Customer;
import com.Eshop.eshop.domain.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public interface ModelRepository extends JpaRepository<Model, Long> {
    Model findBymodelName(String modelName);

    @Query(value = "select * from model m where m.model_name like %?% ",nativeQuery = true)
    Optional<List<Model>> searchByName(@Param("modelName") String modelName);


}
