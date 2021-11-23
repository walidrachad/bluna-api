package com.vaibhav.sec.model;

import javax.persistence.*;

@Entity
@Table(name = "employ_service")
public class EmployService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long employId;
    private Long serviceId;
    private Long organizationId;

    public EmployService() {}

    public EmployService(Long employId, Long serviceId, Long organizationId) {
        this.employId = employId;
        this.serviceId = serviceId;
        this.organizationId = organizationId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmployId() {
        return employId;
    }

    public void setEmployId(Long employId) {
        this.employId = employId;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }
}
