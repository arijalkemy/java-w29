package com.example.concesionaria_autos.dto.request;

import com.example.concesionaria_autos.entity.Service;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoDTO {
    private Long id;
    private String brand;
    private String model;
    private Integer year;
    private Integer numberOfKilometers;
    private Integer doors;
    private Integer price;
    private String currency;
    private List<ServiceDTO> services;
    private Integer countOfOwners;
}
