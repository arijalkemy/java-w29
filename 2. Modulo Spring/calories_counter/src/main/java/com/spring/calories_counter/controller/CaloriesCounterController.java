package com.spring.calories_counter.controller;

import com.spring.calories_counter.dto.request.DishRequestDto;
import com.spring.calories_counter.dto.response.DishResponseDto;
import com.spring.calories_counter.service.CaloriesCounterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CaloriesCounterController {
    @Autowired
    CaloriesCounterServiceImpl caloriesCounterService;

    @GetMapping("/calories/{dishName}")
    public ResponseEntity<List<DishResponseDto>> getDishCalories(@RequestBody List<DishRequestDto> receivedDishes) {
        return ResponseEntity.ok(caloriesCounterService.findDishesDetail(receivedDishes));
    }
}
