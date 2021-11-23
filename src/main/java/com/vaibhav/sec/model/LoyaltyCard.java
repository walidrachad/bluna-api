package com.vaibhav.sec.model;

import javax.persistence.*;

@Entity
@Table(name = "loyalty_card")
public class LoyaltyCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long clientId;
    private Boolean payed;
    private Boolean limited;
    private Integer discount;
    private Long organizationId;

    public LoyaltyCard() {
    }

    public LoyaltyCard(Long id, Long clientId, Boolean payed, Boolean limited, Integer discount, Long organizationId) {
        this.id = id;
        this.clientId = clientId;
        this.payed = payed;
        this.limited = limited;
        this.discount = discount;
        this.organizationId = organizationId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Boolean getPayed() {
        return payed;
    }

    public void setPayed(Boolean payed) {
        this.payed = payed;
    }

    public Boolean getLimited() {
        return limited;
    }

    public void setLimited(Boolean limited) {
        this.limited = limited;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }
}
