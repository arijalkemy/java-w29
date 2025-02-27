package com.example.moviesHQL.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "episodes")
public class Episode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @Column(name = "title")
    private String title;

    @Column(name = "number")
    private Integer number;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "rating")
    private Double rating;

    @ManyToOne
    @JoinColumn(name = "season_id", referencedColumnName = "id", nullable = false)
    private Season season;

    @ManyToMany
    @JoinTable(
            name = "actor_episode",
            joinColumns = @JoinColumn(name = "episode_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private List<Actor> actors;
}
