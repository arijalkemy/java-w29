package com.org.meli.MiniSeries.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class MiniSerie {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    Long id;
    String name;
    Double rating;
    Integer amount_of_awards;
}
