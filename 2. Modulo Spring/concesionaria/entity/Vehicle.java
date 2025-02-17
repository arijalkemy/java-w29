package com.api.concesionaria.entity;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Vehicle {
    private String brand;
    private String model;
    private String manufacturingDate;
    private int numberOfKilometers;
    private int doors;
    private double price;
    private String currency;
    private List<ServiceRecord> services;
    private int countOfOwners;

    public static class ServiceRecord {
        private String date;
        private int kilometers;
        private String descriptions;

    }
}
