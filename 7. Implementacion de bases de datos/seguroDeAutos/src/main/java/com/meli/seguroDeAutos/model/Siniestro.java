package com.meli.seguroDeAutos.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "siniestro")
public class Siniestro {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private LocalDate fechaSiniestro;
    private Integer id_vehiculo;
}
