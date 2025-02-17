package com.example.segurosautos.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "vehiculo")
public class Vehiculo {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "id_vehiculo")
    private Long idVehiculo;
    private String patente;
    private String marca;
    private String modelo;

    @Column(name = "anio_fabricacion")
    private int anioFabricacion;

    @Column(name = "cantidad_ruedas")
    private int cantidadRuedas;

    @OneToMany(mappedBy = "vehiculo", cascade = CascadeType.ALL)
    private List<Siniestro> siniestros;

}
