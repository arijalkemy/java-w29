package com.bootcamp.movieshql.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "series")
public class Serie {
    @Id
    @GeneratedValue
    private Long id;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String title;
    private LocalDate releaseDate;
    private LocalDate endDate;
    @OneToOne
//    @JoinColumn(name = "genre_id")
    private Genre genre;
}
