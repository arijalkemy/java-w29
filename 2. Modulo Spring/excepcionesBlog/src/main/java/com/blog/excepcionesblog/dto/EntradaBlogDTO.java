package com.blog.excepcionesblog.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EntradaBlogDTO {
    private Integer id;
    private String titulo;
    private String autor;
    private LocalDate fechaPublicacion;
}
