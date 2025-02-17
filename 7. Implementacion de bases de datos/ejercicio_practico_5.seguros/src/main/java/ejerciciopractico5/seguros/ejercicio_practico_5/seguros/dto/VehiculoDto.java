package ejerciciopractico5.seguros.ejercicio_practico_5.seguros.dto;

import jakarta.persistence.Column;
import lombok.*;

@Getter @Setter
@Data
public class VehiculoDto {
    private Long id;
    private String patente;
    private Integer año;
    private Integer cantRuedad;
    private String marca;
    private String modelo;

    public VehiculoDto(Long id, String patente, Integer año, Integer cantRuedad, String marca, String modelo) {
        this.id = id;
        this.patente = patente;
        this.año = año;
        this.cantRuedad = cantRuedad;
        this.marca = marca;
        this.modelo = modelo;
    }

    public VehiculoDto() {
    }
}
