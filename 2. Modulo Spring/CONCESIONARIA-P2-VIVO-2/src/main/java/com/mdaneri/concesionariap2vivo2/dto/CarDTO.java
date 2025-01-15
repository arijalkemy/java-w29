package com.mdaneri.concesionariap2vivo2.dto;


import com.mdaneri.concesionariap2vivo2.entity.Service;
import java.util.List;

public class CarDTO {

    private String brand;
    private String model;
    private String manufacturingDate;
    private String numberOfKilometers;
    private String doors;
    private String price;
    private String currency;
    private String countOfOwners;

    public CarDTO(String brand, String model, String manufacturingDate, String numberOfKilometers, String doors, String price, String currency, String countOfOwners) {
        this.brand = brand;
        this.model = model;
        this.manufacturingDate = manufacturingDate;
        this.numberOfKilometers = numberOfKilometers;
        this.doors = doors;
        this.price = price;
        this.currency = currency;
        this.countOfOwners = countOfOwners;
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

    public String getCountOfOwners() {
        return countOfOwners;
    }
}

