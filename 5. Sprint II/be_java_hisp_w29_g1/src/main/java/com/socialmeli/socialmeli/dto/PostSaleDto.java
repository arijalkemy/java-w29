package com.socialmeli.socialmeli.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonPropertyOrder({"user_id", "date", "product", "category", "price", "has_promo", "discount"})
public class PostSaleDto {
    @JsonProperty("user_id")
    @Positive(message = "User id must be positive")
    @NotNull(message = "User id is required")
    private Integer idUser;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate date;

    @Valid
    @NotNull(message = "Product is required")
    private ProductDto product;

    @NotNull(message = "Category is required")
    private Integer category;

    @NotNull(message = "Price is required")
    @DecimalMax(value = "10000000.0", message = "Price must be less than 10000000.0")
    @DecimalMin(value = "0.0", message = "Price must be greater than 0.0")
    private Double price;

    @NotNull(message = "Has promo is required")
    @JsonProperty("has_promo")
    private Boolean hasPromo;

    @NotNull(message = "Discount is required")
    @DecimalMin(value = "0.0", message = "Discount must be greater than 0.0")
    private Double discount;
}
