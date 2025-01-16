package org.example.manejo_excepciones_1_vivo.entity;

import lombok.*;

import java.util.Date;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class EntradaBlog {
    private int id;
    private String tituloBlog;
    private String nombreAutor;
    private Date fechaPublicacion;
}
