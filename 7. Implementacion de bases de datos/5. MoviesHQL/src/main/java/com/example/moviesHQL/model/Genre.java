package com.example.moviesHQL.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "genres")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @Column(name = "name")
    private String name;

    @Column(name = "ranking")
    private Integer ranking;

    @Column(name = "active")
    private Boolean active;
}
