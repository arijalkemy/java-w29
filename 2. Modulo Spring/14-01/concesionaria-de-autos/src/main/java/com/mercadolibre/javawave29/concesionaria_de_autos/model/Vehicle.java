package com.mercadolibre.javawave29.concesionaria_de_autos.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Vehicle {
    private static Integer nextId = 0;

    private Integer id;
    private String brand;
    private String model;
    private String manufacturingDate;
    private Integer numberOfKilometers;
    private Integer doors;
    private Double price;
    private String currency;
    private List<VehicleService> services;
    private Integer countOfOwners;

    public Vehicle() {
        id = nextId++;
    }

    public Vehicle(String brand, String model, String manufacturingDate, Integer numberOfKilometers, Integer doors, Double price, String currency, List<VehicleService> services, Integer countOfOwners) {
        id = nextId++;
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
}
