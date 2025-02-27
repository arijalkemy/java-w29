package com.example.moviesHQL.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "series")
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @Column(name = "title")
    private String title;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "id", nullable = false)
    private Genre genre;

    @OneToMany(mappedBy = "serie")
    private List<Season> seasons;
}
