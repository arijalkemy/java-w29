package com.api.food.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class Plato {
    private String name;
    private List<String> ingredientes;

}
