package com.example.concesionaria_autos.dto.response;

import com.example.concesionaria_autos.dto.request.ServiceDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class VehiculoWServicesDTO {
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
