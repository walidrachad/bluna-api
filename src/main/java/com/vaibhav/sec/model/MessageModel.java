package com.vaibhav.sec.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "message")
public class MessageModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String message;
    private String dateStart;
    private String dateFinish;
    private Boolean repted;
    private String status;
    private Integer numberOfRecipient;
    private String price;
    private Long organizationId;

    public MessageModel() {
    }

    public MessageModel(String name, String message, String dateStart, String dateFinish, Boolean repted, String status, Integer numberOfRecipient, String price, Long organizationId) {
        this.name = name;
        this.message = message;
        this.dateStart = dateStart;
        this.dateFinish = dateFinish;
        this.repted = repted;
        this.status = status;
        this.numberOfRecipient = numberOfRecipient;
        this.price = price;
        this.organizationId = organizationId;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateFinish() {
        return dateFinish;
    }

    public void setDateFinish(String dateFinish) {
        this.dateFinish = dateFinish;
    }

    public Boolean getRepted() {
        return repted;
    }

    public void setRepted(Boolean repted) {
        this.repted = repted;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getNumberOfRecipient() {
        return numberOfRecipient;
    }

    public void setNumberOfRecipient(Integer numberOfRecipient) {
        this.numberOfRecipient = numberOfRecipient;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }
}
