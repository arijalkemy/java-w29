package com.example.moviesHQL.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "seasons")
public class Season {
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

    @Column(name = "number")
    private Integer number;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "serie_id", referencedColumnName = "id", nullable = false)
    private Serie serie;

    @OneToMany(mappedBy = "season")
    private List<Episode> episodes;
}
