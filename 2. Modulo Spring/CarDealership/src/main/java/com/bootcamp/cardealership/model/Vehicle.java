package com.bootcamp.cardealership.model;

import lombok.Data;

import java.util.List;

@Data
public class Vehicle {

    // if you wonder why everything is a String, it's because of the requirements of the project :)

    private String id;
    private String brand;
    private String model;
    private String manufacturingDate;
    private String numberOfKilometers;
    private String doors;
    private String price;
    private String currency;
    private List<Service> services;
    private String countOfOwners;
}
