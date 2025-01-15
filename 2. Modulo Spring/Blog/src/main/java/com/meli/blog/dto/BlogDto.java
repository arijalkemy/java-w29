package com.meli.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogDto {
    private Integer id;
    private String titulo;
    private String nombre;
    Date fecha;
}
