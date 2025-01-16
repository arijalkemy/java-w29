package org.example.manejo_excepciones_1_vivo.dto.request;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class EntradaBlogRequestDto {
    private int id;
    private String tituloBlog;
    private String nombreAutor;
    private Date fechaPublicacion;
}
