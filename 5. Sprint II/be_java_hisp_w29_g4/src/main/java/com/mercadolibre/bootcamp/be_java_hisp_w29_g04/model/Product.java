package com.mercadolibre.bootcamp.be_java_hisp_w29_g04.model;

import lombok.*;

import java.time.LocalDate;

/**
 * Product class
 * * date: format (dd-MM-yyyy)
 * * type: ej.: clothing, footwear, accessory, etc.
 * * category: ej.: (100) chairs, (28) keyboards, (30) monitors
 * * notes: optional, observations about the product
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Integer id;
    private String name;
    private String type;
    private String brand;
    private String color;
    private String notes;
}
