package com.mercadolibre.bootcamp.showroom.model;

import jakarta.persistence.*;

@Entity
public class Garment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;
    private String type;
    private String brand;
    private String color;
    private Integer size;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "garment_id", referencedColumnName = "id")
    private GarmentDetails garmentDetails;

    @ManyToOne
    @JoinColumn(name = "sale_id", referencedColumnName = "id")
    private Sale sale;

    public Garment() {}

    public Garment(Long id, String name, String type, String brand, String color, Integer size, GarmentDetails garmentDetails) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.brand = brand;
        this.color = color;
        this.size = size;
        this.garmentDetails = garmentDetails;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public GarmentDetails getGarmentDetails() {
        return garmentDetails;
    }

    public void setGarmentDetails(GarmentDetails garmentDetails) {
        this.garmentDetails = garmentDetails;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }
}
