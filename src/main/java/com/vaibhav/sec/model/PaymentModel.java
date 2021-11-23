package com.vaibhav.sec.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="payment")
public class PaymentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String name;
    private String token;
    private String total;
    private Integer passages;
    private Integer points;
    private String date;
    private Long organizationId;

    public PaymentModel() {
    }

    public PaymentModel(Long id, String username, String password, String name, String token, String total, Integer passages, Integer points, String date, Long organizationId) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.token = token;
        this.total = total;
        this.passages = passages;
        this.points = points;
        this.date = date;
        this.organizationId = organizationId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public Integer getPassages() {
        return passages;
    }

    public void setPassages(Integer passages) {
        this.passages = passages;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }
}
