package com.example.empresa.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "siniestros")
@Data
public class Siniestro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "perdida_economica")
    private Integer perdidaEconomica;

    @ManyToOne
    @JoinColumn(name = "id_vehiculo", nullable = false, referencedColumnName = "id")
    private Vehiculo vehiculo;
}
