package com.vaibhav.sec.responce;


import com.vaibhav.sec.model.Client;
import com.vaibhav.sec.model.Employ;

public class AppointmentResponse {

    private Long id;
    private String week;
    private String jour;
    private String start;
    private String end;
    private String title;
    private String content;
    private String color;
    private Long serviceId;
    private Client client;
    private Employ employ;
    private Boolean rappel;

    public AppointmentResponse() {
    }

    public AppointmentResponse(Long id, String week, String jour, String start, String end, String title, String content, String color, Long serviceId, Client client, Employ employ,Boolean rappel) {
        this.id = id;
        this.week = week;
        this.jour = jour;
        this.start = start;
        this.end = end;
        this.title = title;
        this.content = content;
        this.color = color;
        this.serviceId = serviceId;
        this.client = client;
        this.employ = employ;
        this.rappel= rappel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJour() {
        return jour;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Employ getEmploy() {
        return employ;
    }

    public void setEmploy(Employ employ) {
        this.employ = employ;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public Boolean getRappel() {
        return rappel;
    }

    public void setRappel(Boolean rappel) {
        this.rappel = rappel;
    }
}
