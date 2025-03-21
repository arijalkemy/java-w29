package com.mercadolibre.final_project_bootcamp_esp_2.dto;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable {

    private String name;
    private String username;
    private String password;
    private String repeated_password;



}