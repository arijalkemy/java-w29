package com.example.joyerialasperlas.model;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
public class Joya {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long nro_identificatorio;

    @Column(nullable = false, length = 100, unique = true)
    private String nombre;

    @Column(nullable = false, length = 50)
    private String material;

    @Column(nullable = false)
    private Double peso;

    @Column(length = 255)
    private String particularidad;

    @Column(nullable = false)
    private Boolean posee_piedra;

    @Column(nullable = false)
    private Boolean ventaONo;
}
