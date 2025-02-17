package ejerciciopractico5.seguros.ejercicio_practico_5.seguros.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter @Setter
public class PatenteModeloMarcaDifDto {
    private String patente;
    private String marca;
    private String modelo;
    private String  diferencia;

    public PatenteModeloMarcaDifDto(String patente, String marca, String modelo, String diferencia) {
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.diferencia = diferencia;
    }

    public PatenteModeloMarcaDifDto() {
    }
}
