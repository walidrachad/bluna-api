package com.vaibhav.sec.responce;

import com.vaibhav.sec.model.Services;

import java.util.List;

public class ServiceResponse {
    private Long id;
    private String label;
    private Long serviceType;
    List<ServiceRespo> services;

    public ServiceResponse() {
    }

    public ServiceResponse(Long id, String label, Long serviceType, List<ServiceRespo> services) {
        this.id = id;
        this.label = label;
        this.serviceType = serviceType;
        this.services = services;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Long getServiceType() {
        return serviceType;
    }

    public void setServiceType(Long serviceType) {
        this.serviceType = serviceType;
    }

    public List<ServiceRespo> getServices() {
        return services;
    }

    public void setServices(List<ServiceRespo> services) {
        this.services = services;
    }
}
