package com.meli.laperlaejercicio.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Jewelry {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long nro_id;
    private String nombre;
    private String material;
    private Double peso;
    private String particularidad;
    private boolean posee_piedra;
    private boolean ventaONo;

    public Jewelry() {
    }

    public Jewelry(Long nro_id, String nombre, String material, Double peso, String particularidad, boolean posee_piedra, boolean ventaONo) {
        this.nro_id = nro_id;
        this.nombre = nombre;
        this.material = material;
        this.peso = peso;
        this.particularidad = particularidad;
        this.posee_piedra = posee_piedra;
        this.ventaONo = ventaONo;
    }
}
