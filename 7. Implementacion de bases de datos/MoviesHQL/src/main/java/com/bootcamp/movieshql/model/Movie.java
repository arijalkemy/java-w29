package com.bootcamp.movieshql.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue
    private Long id;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String title;
    private Long rating;
    private Integer awards;
    private LocalDate releaseDate;
    private Integer length;
    @OneToOne
//    @JoinColumn(name = "genre_id")
    private Genre genre;
}
