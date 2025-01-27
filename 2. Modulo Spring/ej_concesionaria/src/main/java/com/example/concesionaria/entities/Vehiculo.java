package com.example.concesionaria.entities;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
public class Vehiculo {

    private Long id;

    private String brand;

    private String model;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date manufacturingDate;

    private Integer numberOfKilometers;

    private Integer doors;

    private Integer price;

    private String currency;

    private List<Servicio> services;

    private Integer countOfOwners;

}
