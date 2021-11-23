package com.vaibhav.sec.repo;

import com.vaibhav.sec.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepo extends JpaRepository<ProductCategory , Long> {
    ProductCategory getById(Long id);
}
