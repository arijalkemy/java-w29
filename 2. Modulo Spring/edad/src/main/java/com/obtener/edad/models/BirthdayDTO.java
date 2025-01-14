package com.obtener.edad.models;

import lombok.Data;

import java.util.UUID;

@Data
public class BirthdayDTO {
    private Integer year;
    private Integer month;
    private Integer day;
}
