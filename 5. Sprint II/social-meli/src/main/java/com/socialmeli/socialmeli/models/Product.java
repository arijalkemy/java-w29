package com.socialmeli.socialmeli.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    private Integer id;

    private String name;

    private String type;

    private String brand;

    private String color;

    private String notes;
}
