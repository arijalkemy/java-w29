package com.example.moviesHQL.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "password_resets")
@IdClass(value= PasswordResetKey.class)
public class PasswordReset {
    @Id
    private String email;

    @Id
    private String token;

    @Column(name = "created_at")
    private LocalDate createdAt;
}
