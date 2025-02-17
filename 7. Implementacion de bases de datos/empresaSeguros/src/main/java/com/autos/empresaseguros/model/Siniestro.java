package com.autos.empresaseguros.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "siniestro")
public class Siniestro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_siniestro")
    private Long idSiniestro;
    @Column(name = "fecha_siniestro")
    private LocalDate fechaSiniestro;
    @Column(name = "perdida_economica")
    private float perdidaEconomica;
    @ManyToOne
    @JoinColumn(name = "id_vehiculo_denunciado", referencedColumnName = "id")
    private Vehiculo vehiculo;
}
