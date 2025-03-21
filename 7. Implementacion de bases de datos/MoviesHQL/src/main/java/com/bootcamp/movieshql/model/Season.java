package com.bootcamp.movieshql.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "seasons")
public class Season {
    @Id
    @GeneratedValue
    private Long id;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String title;
    private Integer number;
    private LocalDate releaseDate;
    private LocalDate endDate;
    @OneToOne
//    @JoinColumn(name = "serie_id")
    private Serie serie;
}
