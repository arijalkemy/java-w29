package com.blog.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EntradaBlogDTO {
    private int id;
    private String titulo;
    private String autor_name;
    private String fecha;
}
