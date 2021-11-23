package com.vaibhav.sec.model;

import javax.persistence.*;

@Entity
@Table(name = "affectation_services")
public class AffectationServices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long adminServiceId;
    private Long userServicesId;
    private Long organizationId;

    public AffectationServices() {
    }

    public AffectationServices(Long id, Long adminServiceId, Long userServicesId, Long organizationId) {
        this.id = id;
        this.adminServiceId = adminServiceId;
        this.userServicesId = userServicesId;
        this.organizationId = organizationId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAdminServiceId() {
        return adminServiceId;
    }

    public void setAdminServiceId(Long adminServiceId) {
        this.adminServiceId = adminServiceId;
    }

    public Long getUserServicesId() {
        return userServicesId;
    }

    public void setUserServicesId(Long userServicesId) {
        this.userServicesId = userServicesId;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }
}
