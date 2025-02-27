package com.example.moviesHQL.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @Column(name = "title")
    private String title;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "awards")
    private Integer awards;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "length")
    private Integer length;

    @ManyToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "id", nullable = false)
    private Genre genre;

    @ManyToMany
    @JoinTable(
            name = "actor_movie",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private List<Actor> actors;
}
