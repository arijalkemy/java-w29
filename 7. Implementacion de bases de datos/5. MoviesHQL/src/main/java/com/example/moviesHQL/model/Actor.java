package com.example.moviesHQL.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "actors")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "rating")
    private Double rating;

    @ManyToOne
    @JoinColumn(name = "favorite_movie_id", referencedColumnName = "id")
    private Movie favoriteMovieId;

    @ManyToMany(mappedBy = "actors")
    private List<Movie> movies;

    @ManyToMany(mappedBy = "actors")
    private List<Episode> episodes;
}
