package org.melibootcamp.caloriasejercicio.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DishCaloriesDTO {
    private String name;
     private Integer totalCalories;
}
