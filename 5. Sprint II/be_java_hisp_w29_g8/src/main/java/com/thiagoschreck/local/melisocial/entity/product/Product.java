package com.thiagoschreck.local.melisocial.entity.product;
import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class Product {
    private int id;
    private String name;
    private String type;
    private String brand;
    private String color;
    private String notes;
}
