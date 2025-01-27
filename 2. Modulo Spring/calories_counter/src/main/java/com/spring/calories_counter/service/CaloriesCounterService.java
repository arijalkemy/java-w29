package com.spring.calories_counter.service;

import com.spring.calories_counter.dto.request.DishRequestDto;
import com.spring.calories_counter.dto.response.DishResponseDto;

import java.util.List;

public interface CaloriesCounterService {
    List<DishResponseDto> findDishesDetail(List<DishRequestDto> receivedDishes);
}
