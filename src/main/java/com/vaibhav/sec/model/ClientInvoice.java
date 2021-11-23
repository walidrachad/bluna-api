package com.vaibhav.sec.model;

import javax.persistence.*;

@Entity
@Table(name = "client_invoice")
public class ClientInvoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long clientId;
    private String firstname;
    private String lastname;
    private Integer points;
    private String total;
    private Integer totalAppointment;
    private String dettes;
    private String future;
    private Long organizationId;
    private String present;
    public ClientInvoice() {}
    public ClientInvoice(Long clientId, String firstname, String lastname, Integer points, String total, Integer totalAppointment, String dettes,String future,Long organizationId, String present) {
        this.clientId = clientId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.points = points;
        this.total = total;
        this.totalAppointment = totalAppointment;
        this.dettes = dettes;
        this.future = future;
        this.organizationId = organizationId;
        this.present = present;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
    public Integer getPoints() {
        return points;
    }
    public void setPoints(Integer points) {
        this.points = points;
    }
    public String getTotal() {
        return total;
    }
    public void setTotal(String total) {
        this.total = total;
    }
    public Integer getTotalAppointment() {
        return totalAppointment;
    }
    public void setTotalAppointment(Integer totalAppointment) {
        this.totalAppointment = totalAppointment;
    }
    public String getDettes() {
        return dettes;
    }
    public void setDettes(String dettes) {
        this.dettes = dettes;
    }
    public String getFuture() {
        return future;
    }
    public void setFuture(String future) {
        this.future = future;
    }
    public Long getClientId() {
        return clientId;
    }
    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public String getPresent() {
        return present;
    }

    public void setPresent(String present) {
        this.present = present;
    }
}
