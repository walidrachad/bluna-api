package com.vaibhav.sec.repo;

import com.vaibhav.sec.model.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductImageRepo extends JpaRepository<ProductImage,Long> {
    List<ProductImage> getByproductId(Long id);
}
