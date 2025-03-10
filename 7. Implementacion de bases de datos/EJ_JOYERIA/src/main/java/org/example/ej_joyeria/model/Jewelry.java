package org.example.ej_joyeria.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "jewelry")
public class Jewelry {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    private String maaterial;
    private String particularidad;
    private Integer peso;
    @JsonProperty("posee_piedra")
    private Boolean poseePiedra;
    private Boolean ventaONo;

}
