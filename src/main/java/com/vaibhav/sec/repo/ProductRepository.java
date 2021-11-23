package com.vaibhav.sec.repo;

import com.vaibhav.sec.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> getByCategoryId(Long id);
}
