package com.meli.segurovehiculos.dto;


import com.meli.segurovehiculos.model.Accident;
import lombok.*;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDto {
    private Long vehicleId;

    private String plate;

    private String type;

    private String model;

    private String brand;

    private int year;

    private int numberOfWheels;

    private List<Accident> accidents;
}
