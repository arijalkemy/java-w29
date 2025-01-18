package com.bootcamp.youtuber.dto;

import java.time.LocalDate;
import java.util.Date;

public record EntradaBlogDTO(
        int id,
        String titulo,
        String nombreAutor,
        LocalDate fechaPublicacion
) {
}
