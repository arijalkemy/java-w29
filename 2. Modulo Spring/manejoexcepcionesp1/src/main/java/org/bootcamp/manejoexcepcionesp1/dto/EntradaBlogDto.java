package org.bootcamp.manejoexcepcionesp1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntradaBlogDto {
    private Long id;
    private String titulo;
    private String nombreAutor;
    private String fechaPublicacion;
}