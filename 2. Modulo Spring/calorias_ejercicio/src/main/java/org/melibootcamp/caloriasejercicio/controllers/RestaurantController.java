package org.melibootcamp.caloriasejercicio.controllers;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.melibootcamp.caloriasejercicio.service.DishService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RestaurantController {

    private final DishService dishService;

    @GetMapping("/dish/{name}")
    public ResponseEntity<?> getDishCalories(@PathVariable String name){
        return new ResponseEntity<>(dishService.getTotalCalories(name), HttpStatus.OK);
    }

}
