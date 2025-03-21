package com.bootcamp.movieshql.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Data
@Table(name = "actor_movie")
public class ActorMovie {
    @Id
    private Long id;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    @OneToOne
//    @JoinColumn(name = "actor_id")
    private Actor actor;
    @OneToOne
//    @JoinColumn(name = "movie_id")
    private Movie movie;
}
