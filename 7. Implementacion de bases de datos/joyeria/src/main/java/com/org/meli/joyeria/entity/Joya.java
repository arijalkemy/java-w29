package com.org.meli.joyeria.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Joya {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long nroIdentificatorio;
    String nombre;
    String material;
    Double peso;
    String particularidad;
    Boolean poseePiedra;
    Boolean ventaONo;
}
