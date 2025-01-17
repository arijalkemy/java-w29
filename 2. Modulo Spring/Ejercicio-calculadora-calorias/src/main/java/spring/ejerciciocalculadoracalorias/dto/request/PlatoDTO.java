package spring.ejerciciocalculadoracalorias.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlatoDTO {
    private String nombre;
    private int peso;
}
