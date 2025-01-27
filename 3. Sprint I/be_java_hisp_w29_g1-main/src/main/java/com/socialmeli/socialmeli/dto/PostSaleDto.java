package com.socialmeli.socialmeli.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"user_id", "date", "product", "category", "price", "has_promo", "discount"})
public class PostSaleDto {
    @JsonProperty("user_id")
    private Integer idUser;

    private LocalDate date;

    private ProductDto product;

    private Integer category;

    private Double price;

    @JsonProperty("has_promo")
    private Boolean hasPromo;

    private Double discount;
}
