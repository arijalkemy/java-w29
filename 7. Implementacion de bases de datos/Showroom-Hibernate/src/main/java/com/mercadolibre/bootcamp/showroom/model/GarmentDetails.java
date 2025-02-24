package com.mercadolibre.bootcamp.showroom.model;

import jakarta.persistence.*;

@Entity
public class GarmentDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Integer amount;
    private Double price;

    @OneToOne(mappedBy = "garmentDetails")
    private Garment garment;

    public GarmentDetails() {}

    public GarmentDetails(Long id, Integer amount, Double price, Garment garment) {
        this.id = id;
        this.amount = amount;
        this.price = price;
        this.garment = garment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Garment getGarment() {
        return garment;
    }

    public void setGarment(Garment garment) {
        this.garment = garment;
    }
}
