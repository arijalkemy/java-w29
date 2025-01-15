package com.meli.scaffolding.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogDto {
    private Integer id;
    private String titulo;
    private String nombre;
    private String fecha;
}
