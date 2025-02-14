package ejerciciopractico3.QATesters.ejercicio_practico_3.QATesters.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter @Setter
public class MessageDto {
    private String message;

    public MessageDto() {
    }

    public MessageDto(String message) {
        this.message = message;
    }
}
