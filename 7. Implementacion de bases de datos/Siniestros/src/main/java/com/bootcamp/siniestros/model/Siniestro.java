package com.bootcamp.siniestros.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "siniestros")
public class Siniestro {
    @Id
    @GeneratedValue
    private Long id;
    private LocalDateTime fecha;
    @Column(name = "perdida_economica")
    private Double perdidaEconomica;
    @ManyToOne
    @JoinColumn(name = "id_vehiculo", referencedColumnName = "id")
    private Vehiculo vehiculo;
}
