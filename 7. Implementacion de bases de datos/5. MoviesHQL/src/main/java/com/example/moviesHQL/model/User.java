package com.example.moviesHQL.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "remember_token")
    private String rememberToken;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDate updatedAt;
}
