package com.example.practgicaHibernateVivo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MiniSerie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment strategy
    private Long id;
    private String name;
    private Double rating;
    private int amount_of_awards;
}
