package com.meli.movies.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Data
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private Timestamp created_at;
    private Timestamp updated_at;
    private String first_name;
    private String last_name;
    private Double rating;
    private Integer favorite_movie;

}
