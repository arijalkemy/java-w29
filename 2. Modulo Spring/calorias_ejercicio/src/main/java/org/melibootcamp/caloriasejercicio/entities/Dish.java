package org.melibootcamp.caloriasejercicio.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dish {

    private Integer id;
    private String name;
    private Double weigth;
    private List<Ingredient> ingredients;

}
