package spring.ejerciciocalculadoracalorias.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude
public class Ingrediente {
    @JsonProperty("name")
    private String nombre;
    @JsonProperty("calories")
    private int calorias; // Calorías por cada 100 gramos

    public int getCaloriasPorPeso(int peso) {
        return (calorias * peso) / 100;
    }
}
