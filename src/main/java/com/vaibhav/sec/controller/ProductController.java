package com.vaibhav.sec.controller;
import com.vaibhav.sec.model.Product;
import com.vaibhav.sec.model.ProductCategory;
import com.vaibhav.sec.model.ProductImage;
import com.vaibhav.sec.repo.ProductCategoryRepo;
import com.vaibhav.sec.repo.ProductImageRepo;
import com.vaibhav.sec.repo.ProductRepository;
import com.vaibhav.sec.responce.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/product")

public class ProductController {
    @Autowired
    ProductCategoryRepo productCategoryRepo;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductImageRepo productImageRepo;
    @GetMapping(value = "/{organizationId}")
    public ResponseEntity<?> getAllEntity( @PathVariable Long organizationId){
        List<ProductResponse> productResponseList=new ArrayList<>();
        productRepository.findAll().forEach(element->{
            ProductResponse productResponse= new ProductResponse();
            productResponse.setId(element.getId());
            productResponse.setActive(element.getActive());
            productResponse.setCategory(productCategoryRepo.getById(element.getCategoryId()));
            productResponse.setImage(element.getImage());
            productResponse.setName(element.getName());
            productResponse.setPrice(element.getPrice());
            productResponse.setDescription(element.getDescription());
            productResponse.setImages(productImageRepo.getByproductId(element.getId()));
            productResponseList.add(productResponse);
        });
        return ResponseEntity.ok(productResponseList);
    }
    @GetMapping(value = "/getCategory/{organizationId}")
    public ResponseEntity<?> getAllCategory( @PathVariable Long organizationId) {
        return ResponseEntity.ok(productCategoryRepo.findAll());
    }
    @PostMapping(value = "/category/{organizationId}")
    public ResponseEntity<?> addCategory(@RequestBody ProductCategory productCategory,@PathVariable Long organizationId){
        return ResponseEntity.ok(productCategoryRepo.save(productCategory));
    }
    @PostMapping(value = "/add/{organizationId}")
    public ResponseEntity<?> getProduct(@RequestBody Product product,@PathVariable Long organizationId){
        return ResponseEntity.ok(productRepository.save(product));
    }
    @DeleteMapping(value = "/delete/{id}/{organizationId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id,@PathVariable Long organizationId){
        productRepository.deleteById(id);
        return ResponseEntity.ok(true);
    }
    @PostMapping(value = "/addImage/{organizationId}")
    public ResponseEntity<?> addImages(@RequestBody ProductImage productImage,@PathVariable Long organizationId){

        return ResponseEntity.ok(productImageRepo.save(productImage));
    }

}
