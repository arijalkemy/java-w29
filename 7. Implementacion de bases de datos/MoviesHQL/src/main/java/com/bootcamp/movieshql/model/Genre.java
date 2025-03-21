package com.bootcamp.movieshql.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Data
@Table(name = "genres")
public class Genre {
    @Id
    @GeneratedValue
    private Long id;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String name;
    private Integer ranking;
    private boolean active;
}
