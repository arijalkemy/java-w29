package com.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Post {
    private Integer id;
    private Integer userId;
    private Integer productId;
    private Integer category;
    private Double price;
    private LocalDate date;
    private Boolean hasPromo;
    private Double discount;

}
