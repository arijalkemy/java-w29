package com.meli.concesionarioseguros.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="vehiculos")
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_vehiculo")
    private Long idVehicle;
    private String patente;
    private String marca;
    private String modelo;
    private Integer añoDeFabricacion;
    private Integer numeroDeRuedas;

    @OneToMany(mappedBy = "idVehiculoDenunciado")
    private Set<Siniestro> siniestros;
}
