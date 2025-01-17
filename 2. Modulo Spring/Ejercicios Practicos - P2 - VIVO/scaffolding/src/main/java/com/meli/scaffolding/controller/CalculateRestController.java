package com.meli.scaffolding.controller;

import com.meli.scaffolding.dto.DishDTO;
import com.meli.scaffolding.dto.DishResponseDTO;
import com.meli.scaffolding.service.IDishService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CalculateRestController {
  private final IDishService dishService;

  public CalculateRestController(IDishService dishService) {
    this.dishService = dishService;
  }

  @PostMapping("/calculate")
  public DishResponseDTO calculate(@RequestBody DishDTO dish){
    return dishService.calculateCalories(dish);
  }

  @PostMapping("/calculateAll")
  public List<DishResponseDTO> calculate(@RequestBody List<DishDTO> dishes){
    return dishService.calculateAllCalories(dishes);
  }
}
