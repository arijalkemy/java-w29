package com.meli.scaffolding.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
    private Integer id;
    private String titulo;
    private String nombre;
    private String fecha;
}
