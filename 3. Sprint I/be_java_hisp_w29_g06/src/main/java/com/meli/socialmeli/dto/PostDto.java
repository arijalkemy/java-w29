package com.meli.socialmeli.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDto {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer id;
    @JsonProperty("user_id")
    private Integer userId;
    private LocalDate date;
    private ProductDto product;
    private Integer category;
    private Double price;
    @JsonProperty("has_promo")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean hasPromo;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double discount;
}