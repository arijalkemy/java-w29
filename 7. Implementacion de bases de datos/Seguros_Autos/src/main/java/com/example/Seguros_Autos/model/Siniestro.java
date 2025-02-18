package com.example.Seguros_Autos.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter@Setter
@Entity
@Table(name = "siniestros")
public class Siniestro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSiniestro;
    private Date fechaSiniestro;
    @Column(name = "perdida_economica")
    private Double perdidaEconomica;

    @ManyToOne
    @JoinColumn(name = "id_vehiculo")
    private Vehiculo vehiculo;


    public Siniestro() {}


    public Siniestro(Long idSiniestro, Date fechaSiniestro, Double perdidaEconomica, Long idVehiculoDenunciado) {
        this.idSiniestro = idSiniestro;
        this.fechaSiniestro = fechaSiniestro;
        this.perdidaEconomica = perdidaEconomica;
    }

}
