package com.meli.scaffolding.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DishResponseDTO extends DishDTO {
  private Integer calories;
  private IngredientDTO caloric;

  public DishResponseDTO(DishDTO dish) {
  }
}
