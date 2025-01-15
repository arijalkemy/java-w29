package com.bootcamp.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EntradaBlogDTO {
    private String titulo;
    private String autor;
    private String fecha;
}
