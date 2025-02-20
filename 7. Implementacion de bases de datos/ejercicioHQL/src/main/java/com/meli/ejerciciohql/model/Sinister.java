package com.meli.ejerciciohql.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name="Sinisters")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sinister {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date fecha;
    private Double perdidaEconomica;
    @ManyToOne
    @JoinColumn(name = "Vehicle_id", nullable = false)
    private Vehicle vehicle;
}
