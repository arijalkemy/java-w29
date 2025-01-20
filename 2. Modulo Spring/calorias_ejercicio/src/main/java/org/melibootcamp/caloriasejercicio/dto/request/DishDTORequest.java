package org.melibootcamp.caloriasejercicio.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.melibootcamp.caloriasejercicio.entities.Ingredient;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DishDTORequest {

    private String name;
    private List<Ingredient> ingredients;
}
