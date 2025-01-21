package Model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Persona {

    private String nombre;
    private String apellido;
    private int edad;
    private Deporte deporte;
}
