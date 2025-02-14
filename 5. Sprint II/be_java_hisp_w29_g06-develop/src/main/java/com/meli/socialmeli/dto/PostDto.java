package com.meli.socialmeli.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.meli.socialmeli.constants.ValidationValues;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class PostDto {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer id;

    @NotNull(message = ValidationValues.ID_CANT_BE_EMPTY)
    @Positive(message = ValidationValues.ID_POSITIVE_NUMBER)
    @JsonProperty("user_id")
    private Integer userId;

    @NotNull(message = ValidationValues.DATE_CANT_BE_EMPTY)
    private LocalDate date;

    @NotNull
    @Valid
    private ProductDto product;

    private Integer category;

    @Max(value = ValidationValues.PRODUCT_MAX_VALUE, message = ValidationValues.PRODUCT_MAX_VALUE_STRING)
    @NotNull(message = ValidationValues.FIELD_CANT_BE_EMPTY)
    @Positive
    private Double price;

    @JsonProperty("has_promo")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean hasPromo;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double discount;

}
