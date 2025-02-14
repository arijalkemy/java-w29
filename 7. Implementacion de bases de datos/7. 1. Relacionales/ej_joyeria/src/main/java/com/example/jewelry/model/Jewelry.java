package com.example.jewelry.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "jewelry")
public class Jewelry {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nombre;

    private Integer peso;

    private String particularidad;

    @JsonProperty("posee_piedra")
    private Boolean poseePiedra;

    private Boolean ventaONo;
}
