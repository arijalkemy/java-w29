package com.example.dto;

import lombok.Data;

@Data
public class LinkDto {
    private Integer id;
    private String url;
    private int contador;
    private boolean isValid;
    private String password;
}
