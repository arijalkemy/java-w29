package com.mdaneri.concesionariap2vivo2.entity;

import java.time.LocalDate;
import java.util.List;

public class Car {

    private Integer id;
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private String numberOfKilometers;
    private String doors;
    private Integer price;
    private String currency;
    private List<Service> services;
    private String countOfOwners;

    public Car(Integer id, String brand, String model, LocalDate manufacturingDate, String numberOfKilometers, String doors, Integer price, String currency, List<Service> services, String countOfOwners) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.manufacturingDate = manufacturingDate;
        this.numberOfKilometers = numberOfKilometers;
        this.doors = doors;
        this.price = price;
        this.currency = currency;
        this.services = services;
        this.countOfOwners = countOfOwners;
    }

    public Car(String brand, String model, LocalDate manufacturingDate, String numberOfKilometers, String doors, Integer price, String currency, List<Service> services, String countOfOwners) {
        this.brand = brand;
        this.model = model;
        this.manufacturingDate = manufacturingDate;
        this.numberOfKilometers = numberOfKilometers;
        this.doors = doors;
        this.price = price;
        this.currency = currency;
        this.services = services;
        this.countOfOwners = countOfOwners;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setManufacturingDate(LocalDate manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public void setNumberOfKilometers(String numberOfKilometers) {
        this.numberOfKilometers = numberOfKilometers;
    }

    public void setDoors(String doors) {
        this.doors = doors;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public void setCountOfOwners(String countOfOwners) {
        this.countOfOwners = countOfOwners;
    }

    public Integer getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public LocalDate getManufacturingDate() {
        return manufacturingDate;
    }

    public String getNumberOfKilometers() {
        return numberOfKilometers;
    }

    public String getDoors() {
        return doors;
    }

    public Integer getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    public List<Service> getServices() {
        return services;
    }

    public String getCountOfOwners() {
        return countOfOwners;
    }
}
