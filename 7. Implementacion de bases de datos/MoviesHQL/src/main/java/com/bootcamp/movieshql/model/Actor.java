package com.bootcamp.movieshql.model;

import jakarta.persistence.*;
import lombok.Data;

import java.security.Timestamp;

@Entity
@Data
@Table(name = "actors")
public class Actor {
    @Id
    private Long id;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String firstName;
    private String lastName;
    private Integer rating;
    @OneToOne
//    @JoinColumn(name = "favorite_movie_id")
    private Movie favoriteMovie;
}
