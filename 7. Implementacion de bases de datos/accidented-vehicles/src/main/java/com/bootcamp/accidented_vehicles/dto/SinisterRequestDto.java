package com.bootcamp.accidented_vehicles.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class SinisterRequestDto {
    @JsonProperty("accidents_date")
    private LocalDate accidentsDate;
    @JsonProperty("economic_loss")
    private double economicLoss;
    @JsonProperty("vehicle_id")
    private int vehicleId;
}
