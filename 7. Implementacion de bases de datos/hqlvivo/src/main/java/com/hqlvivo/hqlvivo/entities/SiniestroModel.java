package com.hqlvivo.hqlvivo.entities;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
@Data
@Entity
@Table(name = "siniestros")
public class SiniestroModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private Double amountLost;

    @ManyToOne
    @JoinColumn(name = "id_vehicle",nullable = false)
    private VehicleModel vehicle;
}
