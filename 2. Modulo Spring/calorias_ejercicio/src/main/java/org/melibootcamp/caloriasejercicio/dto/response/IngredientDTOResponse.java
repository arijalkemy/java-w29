package org.melibootcamp.caloriasejercicio.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IngredientDTOResponse {
    private String name;
    private Double totalCalories;
}
