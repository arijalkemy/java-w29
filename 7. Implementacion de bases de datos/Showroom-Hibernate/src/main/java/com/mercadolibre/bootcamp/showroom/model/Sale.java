package com.mercadolibre.bootcamp.showroom.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private LocalDate soldOn;
    private String meansOfpayment;
    private Double total;

    @OneToMany(mappedBy = "sale")
    private List<Garment> garmentList;



    public Sale() {}

    public Sale(Long id, LocalDate soldOn, String meansOfpayment, Double total, List<Garment> garmentList) {
        this.id = id;
        this.soldOn = soldOn;
        this.meansOfpayment = meansOfpayment;
        this.total = total;
        this.garmentList = garmentList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getSoldOn() {
        return soldOn;
    }

    public void setSoldOn(LocalDate soldOn) {
        this.soldOn = soldOn;
    }

    public String getMeansOfpayment() {
        return meansOfpayment;
    }

    public void setMeansOfpayment(String meansOfpayment) {
        this.meansOfpayment = meansOfpayment;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<Garment> getGarmentList() {
        return garmentList;
    }

    public void setGarmentList(List<Garment> garmentList) {
        this.garmentList = garmentList;
    }
}
