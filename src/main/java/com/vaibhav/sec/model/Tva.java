package com.vaibhav.sec.model;

import javax.persistence.*;

@Entity
@Table(name = "tva")
public class Tva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String totalOurTx;
    private String totalTtc;
    public Tva() {}
    public Tva(String totalOurTx, String totalTtc) {
        this.totalOurTx = totalOurTx;
        this.totalTtc = totalTtc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTotalOurTx() {
        return totalOurTx;
    }

    public void setTotalOurTx(String totalOurTx) {
        this.totalOurTx = totalOurTx;
    }

    public String getTotalTtc() {
        return totalTtc;
    }

    public void setTotalTtc(String totalTtc) {
        this.totalTtc = totalTtc;
    }
}
