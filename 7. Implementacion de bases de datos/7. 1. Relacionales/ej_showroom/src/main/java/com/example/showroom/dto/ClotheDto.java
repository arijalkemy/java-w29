package com.example.showroom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClotheDto {
    private String name;

    private String type;

    private String brand;

    private String size;

    private String color;

    private Integer stock;

    private Double price;
}
