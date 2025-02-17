package com.meli.jpa_hibernate.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Setter
@Getter
@Entity
public class MiniSerie {
    @Id
    @GeneratedValue
    Long id;

    @Column
    String name;

    @Column
    Double rating;

    @Column
    int amount_of_awards;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "miniSerie")
    List<Episode> episode;
}