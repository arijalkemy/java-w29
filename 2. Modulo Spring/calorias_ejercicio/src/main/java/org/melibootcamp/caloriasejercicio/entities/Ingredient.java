package org.melibootcamp.caloriasejercicio.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient {
    private String name;
    private Integer calories;

    public Double getTotalCalories(Double grames){
       return grames / this.calories * 100;
    }

}
