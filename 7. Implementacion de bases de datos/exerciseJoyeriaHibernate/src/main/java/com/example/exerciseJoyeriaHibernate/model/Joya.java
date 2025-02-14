package com.example.exerciseJoyeriaHibernate.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Joya {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nro_identificatorio;
    private String nombre;
    private String material;
    private Integer peso;
    private String particularidad;
    private boolean posee_piedra;
    private boolean ventaONo;

}
