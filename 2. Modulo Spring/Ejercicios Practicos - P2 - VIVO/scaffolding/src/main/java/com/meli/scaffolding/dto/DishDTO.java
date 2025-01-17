package com.meli.scaffolding.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DishDTO {
  private String name;
  private List<IngredientDTO> ingredients;
}
