package com.meli.scaffolding.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IngredientDTO {
  private String name;
  private Integer calories;
  private Integer weight;
}
