package com.org.meli.showroom.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GarmentDto {
    Long id;
    String name;
    String type;
    String brand;
    String color;
    String size;
    Integer amount;
    Double price;
}
