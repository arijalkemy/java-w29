package com.example.obras_literarias.dto;

import com.example.obras_literarias.entity.ObraLiteraria;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ObraLiterariaResponseDto {
    @JsonProperty("id")
    private String id;

    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("autor")
    private String autor;

    @JsonProperty("cantidadDePaginas")
    private Integer cantidadDePaginas;

    @JsonProperty("editorial")
    private String editorial;

    @JsonProperty("year")
    private Integer year;

    public ObraLiterariaResponseDto(ObraLiteraria obraLiteraria) {
        this.id = obraLiteraria.getId();
        this.nombre = obraLiteraria.getNombre();
        this.autor = obraLiteraria.getAutor();
        this.cantidadDePaginas = obraLiteraria.getCantidadDePaginas();
        this.editorial = obraLiteraria.getEditorial();
        this.year = obraLiteraria.getYear();
    }
}
