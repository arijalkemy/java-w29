package org.melibootcamp.caloriasejercicio.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.melibootcamp.caloriasejercicio.dto.request.DishDTORequest;
import org.melibootcamp.caloriasejercicio.entities.Ingredient;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DishDTOResponse {

    private Integer id;
    private String name;
    private IngredientDTOResponse MaxCalory;
    private Double totalCalories;
    private List<IngredientDTOResponse> ingredients;



}
