package ejercicio2.joyeria.ejercicio_practico_2.joyeria.dto;

import lombok.*;

@Data
@Getter @Setter
public class ReadJoyasResponseDto {
    private Long nroIdentificatorio;
    private String nombre;
    private String material;
    private Double peso;
    private String particularidad;
    private Boolean poseePiedra;
    private Boolean ventaONo;

    public ReadJoyasResponseDto() {
    }

    public ReadJoyasResponseDto(Boolean ventaONo, Boolean poseePieda, String particularidad, Double peso, String material, String nombre, Long nro_identificatorio) {
        this.ventaONo = ventaONo;
        this.poseePiedra = poseePieda;
        this.particularidad = particularidad;
        this.peso = peso;
        this.material = material;
        this.nombre = nombre;
        this.nroIdentificatorio = nro_identificatorio;
    }
}
