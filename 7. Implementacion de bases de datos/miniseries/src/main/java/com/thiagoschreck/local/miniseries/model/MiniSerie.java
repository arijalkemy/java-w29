package com.thiagoschreck.local.miniseries.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public record MiniSerie(
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        Long id,
        String name,
        Double rating,
        int amount_of_awards
) {
}
