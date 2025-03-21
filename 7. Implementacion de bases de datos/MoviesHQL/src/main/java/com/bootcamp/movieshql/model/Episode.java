package com.bootcamp.movieshql.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "episodes")
public class Episode {
    @Id
    @GeneratedValue
    private Long id;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String title;
    private Integer number;
    private LocalDate releaseDate;
    private Long rating;
    @ManyToOne
//    @JoinColumn(name = "season_id")
    private Season season;
}
