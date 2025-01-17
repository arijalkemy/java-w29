package org.example.ej_concesionaria_autos.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Servicio {
    private String date;
    private Integer kilometers;
    private String descriptions;
}
