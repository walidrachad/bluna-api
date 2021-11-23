package com.vaibhav.sec.model;

import javax.persistence.*;

@Entity
@Table(name = "payment_methode")
public class PaymentMethode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String label;
    private Long organizationId;

    public PaymentMethode() { }

    public PaymentMethode(Long id, String label, Long organizationId) {
        this.id = id;
        this.label = label;
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

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }
}
