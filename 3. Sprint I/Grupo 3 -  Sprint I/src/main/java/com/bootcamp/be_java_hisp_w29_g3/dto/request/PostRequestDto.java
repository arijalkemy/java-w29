package com.bootcamp.be_java_hisp_w29_g3.dto.request;


import com.bootcamp.be_java_hisp_w29_g3.entity.Product;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostRequestDto {
    private Integer userId;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private Product product;
    private Integer category;
    private Double price;
    @JsonAlias(value = {"has_prom", "has_promo"})
    private Boolean hasProm = false;
    private Double discount;
}
