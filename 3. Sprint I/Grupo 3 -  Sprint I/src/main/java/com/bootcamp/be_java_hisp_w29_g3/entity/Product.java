package com.bootcamp.be_java_hisp_w29_g3.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
    private Integer id;
    private String name;
    private String type;
    private String brand;
    private String color;
    private String notes;
}
