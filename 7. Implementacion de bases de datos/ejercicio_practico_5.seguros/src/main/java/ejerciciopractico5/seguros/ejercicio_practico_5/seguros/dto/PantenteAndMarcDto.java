package ejerciciopractico5.seguros.ejercicio_practico_5.seguros.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter @Setter
public class PantenteAndMarcDto {
    private String patente;
    private String marca;

    public PantenteAndMarcDto(String patente, String marca) {
        this.patente = patente;
        this.marca = marca;
    }

}
