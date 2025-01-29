package com.calories.calories.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.calories.calories.dto.request.DishRequestDto;
import com.calories.calories.dto.response.DishCaloriesResponseDto;
import com.calories.calories.service.CaloriesService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@RestController
@RequestMapping("/calories")
public class CaloriesController {

    private final CaloriesService caloriesService;

    @PostMapping("")
    public ResponseEntity<DishCaloriesResponseDto> postDishToCalculate(@RequestBody DishRequestDto dish) {
        return new ResponseEntity<>(this.caloriesService.calculateCalories(dish), HttpStatus.ACCEPTED);
    }

}
