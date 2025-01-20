package com.example.entities;

import lombok.Data;

@Data
public class Link {
    private Integer id;
    private String url;
    private int contador;
    private boolean isValid;
    private String password;
}
