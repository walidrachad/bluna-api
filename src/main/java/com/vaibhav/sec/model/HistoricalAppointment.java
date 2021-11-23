package com.vaibhav.sec.model;

import javax.persistence.*;

@Entity
@Table(name = "historical_appointment")
public class HistoricalAppointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String date;
    private Long serviceId;
    private Long userId;
    private Long employId;
    private Long organizationId;

    public HistoricalAppointment() {}

    public HistoricalAppointment(String date, Long serviceId, Long userId, Long employId, String title, Long organizationId) {
        this.date = date;
        this.serviceId = serviceId;
        this.userId = userId;
        this.employId = employId;
        this.title = title;

        this.organizationId = organizationId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getEmployId() {
        return employId;
    }

    public void setEmployId(Long employId) {
        this.employId = employId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }
}
