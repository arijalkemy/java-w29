package ejerciciopractico7.obrasliterarias.ejercicio_practico_7.obras_literarias.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter @Setter
public class MessageDto {
    private String message;

    public MessageDto(String message) {
        this.message = message;
    }
}
