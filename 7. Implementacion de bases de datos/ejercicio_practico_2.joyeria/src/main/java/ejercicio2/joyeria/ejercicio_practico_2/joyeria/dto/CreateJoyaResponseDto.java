package ejercicio2.joyeria.ejercicio_practico_2.joyeria.dto;

import lombok.*;

@Data
@Getter @Setter
public class CreateJoyaResponseDto {
    private Long nroIdentificatorio;

    public CreateJoyaResponseDto() {
    }

    public CreateJoyaResponseDto(Long nroIdentificatorio) {
        this.nroIdentificatorio = nroIdentificatorio;
    }
}
