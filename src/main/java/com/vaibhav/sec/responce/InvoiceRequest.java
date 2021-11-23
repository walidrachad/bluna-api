package com.vaibhav.sec.responce;

import java.util.List;

public class InvoiceRequest {
    private Long id;
    private String title;
    private String image;
    private String date;
    private String total;
    private Long client;
    private Long paymentId;
    private Long paymentMethodeId;
    private List<OrderRequest> orders;
    private String message;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public Long getClient() {
        return client;
    }

    public void setClient(Long client) {
        this.client = client;
    }

    public Long getPaymentMethodeId() {
        return paymentMethodeId;
    }

    public void setPaymentMethodeId(Long paymentMethodeId) {
        this.paymentMethodeId = paymentMethodeId;
    }

    public List<OrderRequest> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderRequest> orders) {
        this.orders = orders;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }
}
