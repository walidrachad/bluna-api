package com.vaibhav.sec.responce;
import com.vaibhav.sec.model.Client;
import com.vaibhav.sec.model.Order;
import com.vaibhav.sec.model.PaymentMethode;

import java.util.List;
public class InvoiceResponse {
    private Long id;
    private String title;
    private String image;
    private String date;
    private String total;
    private Client client;
    private Long employId;
    private PaymentMethode paymentMethode;
    private List<Order> orders;
    private String message;
    private String time;
    private Long walletId;
    private Long organizationId;
    public InvoiceResponse() {
    }

    public InvoiceResponse(Long id, String title, String image, String date, String total, Client client, PaymentMethode paymentMethode, Long walletId, List<Order> orders,
                           String message, String time, Long employId, Long organizationId) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.date = date;
        this.total = total;
        this.client = client;
        this.paymentMethode = paymentMethode;
        this.orders = orders;
        this.message = message;
        this.walletId=walletId;
        this.time=time;
        this.employId=employId;
        this.organizationId = organizationId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }



    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public PaymentMethode getPaymentMethode() {
        return paymentMethode;
    }

    public void setPaymentMethode(PaymentMethode paymentMethode) {
        this.paymentMethode = paymentMethode;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Long getWalletId() {
        return walletId;
    }

    public void setWalletId(Long walletId) {
        this.walletId = walletId;
    }

    public Long getEmployId() {
        return employId;
    }

    public void setEmployId(Long employId) {
        this.employId = employId;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }
}