package com.meli.socialmeli.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.meli.socialmeli.constants.ValidationValues;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
    @JsonProperty("product_id")
    @NotNull(message = ValidationValues.ID_CANT_BE_EMPTY)
    @Positive(message = ValidationValues.ID_POSITIVE_NUMBER)
    private Integer productId;

    @JsonProperty("product_name")
    @NotNull(message = ValidationValues.FIELD_CANT_BE_EMPTY)
    @Size(max = ValidationValues.PRODUCT_NAME_MAX_LENGTH_NUMBER, message = ValidationValues.PRODUCT_NAME_MAX_LENGTH)
    @Pattern(regexp = ValidationValues.REGEX_NO_SPECIAL_CHARACTERS,
            message = ValidationValues.REGEX_NO_SPECIAL_CHARACTERS_STRING)
    private String productName;


    @NotNull(message = ValidationValues.FIELD_CANT_BE_EMPTY)
    @Size(max = ValidationValues.TYPE_NAME_MAX_LENGTH_NUMBER, message = ValidationValues.TYPE_MAX_LENGTH)
    @Pattern(regexp = ValidationValues.REGEX_NO_SPECIAL_CHARACTERS,
            message = ValidationValues.REGEX_NO_SPECIAL_CHARACTERS_STRING)
    private String type;

    @NotNull(message = ValidationValues.FIELD_CANT_BE_EMPTY)
    @Size(max = ValidationValues.BRAND_ID_MAX_LENGTH_NUMBER, message = ValidationValues.BRAND_ID_MAX_LENGTH)
    @Pattern(regexp = ValidationValues.REGEX_NO_SPECIAL_CHARACTERS,
            message = ValidationValues.REGEX_NO_SPECIAL_CHARACTERS_STRING)
    private String brand;

    @NotNull(message = ValidationValues.FIELD_CANT_BE_EMPTY)
    @Size(max = ValidationValues.COLOT_MAX_LENGTH_NUMBER, message = ValidationValues.COLOR_MAX_LENGTH)
    @Pattern(regexp = ValidationValues.REGEX_NO_SPECIAL_CHARACTERS,
            message = ValidationValues.REGEX_NO_SPECIAL_CHARACTERS_STRING)
    private String color;

    @Size(max = ValidationValues.NOTES_MAX_LENGTH_NUMBER, message = ValidationValues.NOTES_MAX_LENGTH)
    @Pattern(regexp = ValidationValues.REGEX_NO_SPECIAL_CHARACTERS,
            message = ValidationValues.REGEX_NO_SPECIAL_CHARACTERS_STRING)
    private String notes;

}
