package ejerciciopractico6.productos.ejercicio_practico_6.productos.dto;

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
