package com.meli.scaffolding.service;


import com.meli.scaffolding.dto.DishDTO;
import com.meli.scaffolding.dto.DishResponseDTO;

import java.util.List;

public interface IDishService {
  DishResponseDTO calculateCalories(DishDTO dish);

  List<DishResponseDTO> calculateAllCalories(List<DishDTO> dishes);
}
