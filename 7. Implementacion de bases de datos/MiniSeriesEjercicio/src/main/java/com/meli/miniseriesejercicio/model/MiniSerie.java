package com.meli.miniseriesejercicio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class MiniSerie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Double rating;
    private Integer amount_of_awards;

    public MiniSerie(Long id, String name, Double rating, Integer amount_of_awards) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.amount_of_awards = amount_of_awards;
    }

    public MiniSerie() {

    }
}
