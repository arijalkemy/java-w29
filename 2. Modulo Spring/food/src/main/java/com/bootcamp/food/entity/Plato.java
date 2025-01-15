package com.bootcamp.food.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Plato {
    private String name;
    private List<String> ingredientes;
}
