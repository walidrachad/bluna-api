package com.vaibhav.sec.responce;

import java.util.List;

public class ServiceConfigResponse {
    private String online;
    private String payedOnline;
    private List<Long> employIds;
    private List<Long> roomIds;

    public ServiceConfigResponse() {
    }

    public ServiceConfigResponse(String online, String payedOnline, List<Long> employIds, List<Long> roomIds) {
        this.online = online;
        this.payedOnline = payedOnline;
        this.employIds = employIds;
        this.roomIds = roomIds;
    }

    public String getOnline() {
        return online;
    }

    public void setOnline(String online) {
        this.online = online;
    }

    public String getPayedOnline() {
        return payedOnline;
    }

    public void setPayedOnline(String payedOnline) {
        this.payedOnline = payedOnline;
    }

    public List<Long> getEmployIds() {
        return employIds;
    }

    public void setEmployIds(List<Long> employIds) {
        this.employIds = employIds;
    }

    public List<Long> getRoomIds() {
        return roomIds;
    }

    public void setRoomIds(List<Long> roomIds) {
        this.roomIds = roomIds;
    }
}
