package com.mercadolibre.final_project_bootcamp_esp_2.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class RegisteredUserDto implements Serializable {

    private Long id;
    private String username;
    private String name;
    private String role;
    private String jwt;

}