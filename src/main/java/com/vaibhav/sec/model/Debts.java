package com.vaibhav.sec.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;

@Entity
@Table(name = "Debtss")
public class Debts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String date;
    private String firstname;
    private String lastname;
    private String totalSpend;
    private String totalPassages;
    private String TotalPoints;
    private String totalDebts;
    private String avoir;
    private Long userId;
    private Long invoiceId;
    private Long organizationId;
    public Debts() {
    }

    public Debts(Long id, String date, String firstname, String lastname, String totalSpend, String totalPassages, String totalPoints, String totalDebts, Long userId, Long invoiceId, Boolean delete, String avoir) {
        this.id = id;
        this.date = date;
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalSpend = totalSpend;
        this.totalPassages = totalPassages;
        TotalPoints = totalPoints;
        this.totalDebts = totalDebts;
        this.userId = userId;
        this.invoiceId = invoiceId;

        this.avoir = avoir;
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

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getTotalSpend() {
        return totalSpend;
    }

    public void setTotalSpend(String totalSpended) {
        this.totalSpend = totalSpended;
    }

    public String getTotalPassages() {
        return totalPassages;
    }

    public void setTotalPassages(String totalPassages) {
        this.totalPassages = totalPassages;
    }

    public String getTotalPoints() {
        return TotalPoints;
    }

    public void setTotalPoints(String totalPoints) {
        TotalPoints = totalPoints;
    }

    public String getTotalDebts() {
        return totalDebts;
    }

    public void setTotalDebts(String totalDebts) {
        this.totalDebts = totalDebts;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }


    public String getAvoir() {
        return avoir;
    }

    public void setAvoir(String avoir) {
        this.avoir = avoir;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }
}
