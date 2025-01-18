package com.bootcamp.youtuber.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class EntradaBlog {
    private int id;
    private String titulo;
    private String nombreAutor;
    private LocalDate fechaPublicacion;
}
