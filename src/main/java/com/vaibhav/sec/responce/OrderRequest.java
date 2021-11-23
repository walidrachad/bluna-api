package com.vaibhav.sec.responce;

public class OrderRequest {
    private String productName;
    private Long productId;
    private Long employId;
    private Integer quentite;
    private String price;
    private String reference;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getEmployId() {
        return employId;
    }

    public void setEmployId(Long employId) {
        this.employId = employId;
    }

    public Integer getQuentite() {
        return quentite;
    }

    public void setQuentite(Integer quentite) {
        this.quentite = quentite;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}
