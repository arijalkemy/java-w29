package com.mercadolibre.javawave29.concesionaria_de_autos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VehicleDTO {
    private String brand;
    private String model;
    private String manufacturingDate;
    private Integer numberOfKilometers;
    private Integer doors;
    private Double price;
    private String currency;
    private Integer countOfOwners;

    public Integer returnYear() {
        String[] date = getManufacturingDate().split("-");
        return Integer.parseInt(date[0]);
    }
}
