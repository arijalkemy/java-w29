package com.meli.seguroDeAutos.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "vehiculo")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Long patente;
    private String modelo;
    @Column(name = "year_de_fabricacion")
    private Integer yearDeFabricacion;
    @Column(name = "cantidad_de_ruedas")
    private Integer cantidadDeRuedas;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_vehiculo")
    private List<Siniestro> siniestros;
}
