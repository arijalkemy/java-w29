package exercise.calculadora_calorias.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Plato {
    private String nombre;
    private Map<Ingrediente, Integer> ingredientes;
}
