package com.vaibhav.sec.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "invoice")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String image;
    private String date;
    private String total;
    private String time;
    @NotNull
    private Long userId;
    private Long paymentMethodeId;
    private Long walletId;
    private Long employId;
    private String message;
    private String status;
    private Long organizationId;

    public Invoice(Long id, String title, String image, String date, String total, Long userId, Long paymentMethodeId,
                   Long walletId, String message, String status, String time, Long employId, Long organizationId) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.date = date;
        this.total = total;
        this.userId = userId;
        this.paymentMethodeId=paymentMethodeId;
        this.walletId = walletId;
        this.message = message;
        this.status = status;
        this.time=time;
        this.employId=employId;
        this.organizationId = organizationId;
    }

    public Invoice() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Long getPaymentMethodeId() {
        return paymentMethodeId;
    }

    public void setPaymentMethodeId(Long paymentMethodeId) {
        this.paymentMethodeId = paymentMethodeId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getWalletId() {
        return walletId;
    }

    public void setWalletId(Long walletId) {
        this.walletId = walletId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Long getEmployId() {
        return employId;
    }

    public void setEmployId(Long employId) {
        this.employId = employId;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }
}
