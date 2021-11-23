package com.vaibhav.sec.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "service_category")
public class ServiceCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String label;
    private Long serviceType;
    @Column(columnDefinition = "TEXT")
    private String image;
    private Long organizationId;

    public ServiceCategory() {}
    public ServiceCategory(Long id, String label, Long serviceType, String image, Long organizationId) {
        this.id = id;
        this.label = label;
        this.serviceType = serviceType;
        this.image = image;
        this.organizationId = organizationId;
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
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }
}
