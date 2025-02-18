package com.example.demo.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ObraLiterariaDto {
    private String nombre;
    private String autor;
    private Integer cantPaginas;
    private String editorial;
    private Date anioPublicacion;
}
