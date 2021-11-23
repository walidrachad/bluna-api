package com.vaibhav.sec.responce;

import com.vaibhav.sec.model.ProductCategory;
import com.vaibhav.sec.model.ProductImage;

import java.util.List;

public class ProductResponse {
    private Long id;
    private String name;
    private String description;
    private Boolean active;
    private String price;
    private String image;
    private ProductCategory category;
    private List<ProductImage> images;

    public ProductResponse() {
    }

    public ProductResponse(Long id, String name, String description, Boolean active, String price, String image, ProductCategory category, List<ProductImage> images) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.active = active;
        this.price = price;
        this.image = image;
        this.category = category;
        this.images = images;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public List<ProductImage> getImages() {
        return images;
    }

    public void setImages(List<ProductImage> images) {
        this.images = images;
    }
}

