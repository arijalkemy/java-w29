package com.meli.concesionarioseguros.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="siniestros")
public class Siniestro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_siniestro")
    private Integer idSiniestro;
    private LocalDate fechaSiniestro;
    private Double perdidaEconomica;

    @ManyToOne
    @JoinColumn(name="vehiculo_id", nullable = false)
    private Vehiculo idVehiculoDenunciado;
}
