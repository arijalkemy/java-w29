package com.blog.excepcionesblog.Entity;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EntradaBlog {
    private Integer id;
    private String titulo;
    private String autor;
    private LocalDateTime fechaPublicacion;
}
