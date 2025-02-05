package com.bootcamp.be_java_hisp_w29_g3.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Post {
    private Integer id;
    private LocalDate date;
    private Product product;
    private Integer category;
    private Double price;
    private Boolean hasProm;
    private Double discount;
}
