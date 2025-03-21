package com.bootcamp.movieshql.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Data
@Table(name = "actor_episode")
public class ActorEpisode {
    @Id
    private Long id;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    @OneToOne
//    @JoinColumn(name = "actor_id")
    private Actor actor;
    @OneToOne
//    @JoinColumn(name = "episode_id")
    private Episode episode;
}
