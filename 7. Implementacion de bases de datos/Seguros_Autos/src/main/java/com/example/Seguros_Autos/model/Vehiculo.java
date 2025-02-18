package com.example.Seguros_Autos.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter@Setter
@Entity
@Table(name = "vehiculos")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vehiculo")
    private Long idVehiculo;
    private String Patente;
    private String Marca;
    private String Modelo;
    @Column(name = "anio_fabricacion")
    private Integer AnioFabricacion;
    @Column(name = "cantidad_de_ruedas")
    private Integer CantidadDeRuedas;

    @OneToMany(mappedBy = "vehiculo")
    private List<Siniestro> siniestros;

    public Vehiculo() {}

    public Vehiculo(String Patente, String Marca, String Modelo, Integer AnioFabricacion, Integer CantidadDeRuedas) {
        this.Patente = Patente;
        this.Marca = Marca;
        this.Modelo = Modelo;
        this.AnioFabricacion = AnioFabricacion;
        this.CantidadDeRuedas = CantidadDeRuedas;
    }

}
