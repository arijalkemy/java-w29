package com.example.moviesHQL.model;

import lombok.Data;

@Data
public class PasswordResetKey {
    private String email;
    private String token;
}
