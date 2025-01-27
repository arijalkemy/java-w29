package com.example.concesionaria.entities;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Servicio {

    private LocalDate date;

    private Integer kilometers;

    private String descriptions;

}
