package ejerciciopractico5.seguros.ejercicio_practico_5.seguros.dto;

import lombok.Data;

@Data
public class PatenteDto {
    private String patente;

    public PatenteDto(String patente) {
        this.patente = patente;
    }

    public PatenteDto() {
    }
}
