package ejerciciopractico5.seguros.ejercicio_practico_5.seguros.dto;

import ejerciciopractico5.seguros.ejercicio_practico_5.seguros.model.Vehiculo;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Getter @Setter
public class SiniestroDto {
    private Long id;
    private Date fecha;
    private Double perdida;
    private VehiculoDto vehiculo;

    public SiniestroDto(Long id, Date fecha, Double perdida, VehiculoDto vehiculo) {
        this.id = id;
        this.fecha = fecha;
        this.perdida = perdida;
        this.vehiculo = vehiculo;
    }

    public SiniestroDto() {
    }
}
