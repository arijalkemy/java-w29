package com.example.moviesHQL.model;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.Data;

@Enabled
@Data
@Table(name = "migrations")
public class Migration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "migration")
    private String migration;

    @Column(name = "batch")
    private Integer batch;
}
