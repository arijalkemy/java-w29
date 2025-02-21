package com.example.hqlvehiculos.model.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "losses")
public class Loss {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    Date date;
    Double amount;
    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    Vehicle vehicle;
}
