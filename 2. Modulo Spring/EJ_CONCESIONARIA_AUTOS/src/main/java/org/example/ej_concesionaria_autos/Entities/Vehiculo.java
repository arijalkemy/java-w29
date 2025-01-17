package org.example.ej_concesionaria_autos.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehiculo {
    private Integer id;
    private String brand;
    private String model;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date manufacturingDate;

    private Integer numberOfKilometers;
    private Integer doors;
    private Integer price;
    private String currency;
    private List<Servicio> services;
    private Integer countOfOwners;
}
