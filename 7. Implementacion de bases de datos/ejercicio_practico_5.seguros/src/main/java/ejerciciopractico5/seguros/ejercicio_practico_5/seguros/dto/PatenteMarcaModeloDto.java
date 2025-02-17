package ejerciciopractico5.seguros.ejercicio_practico_5.seguros.dto;

import lombok.*;

@Data
@Getter @Setter
public class PatenteMarcaModeloDto {
    private String patente;
    private String marca;
    private String modelo;

    public PatenteMarcaModeloDto(String patente, String marca, String modelo) {
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
    }
}
