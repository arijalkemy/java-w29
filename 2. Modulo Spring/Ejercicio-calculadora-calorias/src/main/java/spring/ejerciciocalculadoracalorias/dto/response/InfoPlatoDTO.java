package spring.ejerciciocalculadoracalorias.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import spring.ejerciciocalculadoracalorias.model.Ingrediente;

import java.util.List;

@Data
@AllArgsConstructor
public class InfoPlatoDTO {
    private String nombre;
    private int caloriasTotales;
    private List<String> ingredientes;
    private Ingrediente ingredienteMasCalorico;
}

