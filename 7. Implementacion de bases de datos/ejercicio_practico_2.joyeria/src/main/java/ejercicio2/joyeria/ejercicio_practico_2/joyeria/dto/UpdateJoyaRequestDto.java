package ejercicio2.joyeria.ejercicio_practico_2.joyeria.dto;

import lombok.*;

@Data
@Getter @Setter
public class UpdateJoyaRequestDto {
    private Long nroIdentificatorio;
    private String nombre;
    private String material;
    private Double peso;
    private String particularidad;
    private Boolean poseePiedra;
    private Boolean ventaONo;

    public UpdateJoyaRequestDto() {
    }

    public UpdateJoyaRequestDto(Long nro_identificatorio, String nombre, String material, Double peso, String particularidad, Boolean poseePieda, Boolean ventaONo) {
        this.nroIdentificatorio = nro_identificatorio;
        this.nombre = nombre;
        this.material = material;
        this.peso = peso;
        this.particularidad = particularidad;
        this.poseePiedra = poseePieda;
        this.ventaONo = ventaONo;
    }
}
