package com.example.vehicles.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "accident")
public class Accident {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "accident_id")
    private Long id;

    @Column(name = "accident_date")
    private LocalDate accidentDate;

    @Column(name = "economic_loss")
    private Double economicLoss;

    @ManyToOne
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;
}
