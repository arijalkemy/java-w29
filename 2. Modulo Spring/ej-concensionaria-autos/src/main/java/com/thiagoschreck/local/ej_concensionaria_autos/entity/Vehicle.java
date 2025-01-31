package com.thiagoschreck.local.ej_concensionaria_autos.entity;

import java.util.List;

public class Vehicle {
    private Integer id;
    private final String brand;
    private final String model;
    private final String manufacturingDate;
    private final String numberOfKilometers;
    private final String doors;
    private final String price;
    private final String currency;
    private final List<Service> services;
    private final String countOfOwners;

    public Vehicle(String brand, String model, String manufacturingDate, String numberOfKilometers, String doors, String price, String currency, List<Service> services, String countOfOwners) {
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

    public Integer getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getManufacturingDate() {
        return manufacturingDate;
    }

    public String getNumberOfKilometers() {
        return numberOfKilometers;
    }

    public String getDoors() {
        return doors;
    }

    public String getPrice() {
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

    public record Service(String date, String kilometers, String descriptions) {
    }
}
