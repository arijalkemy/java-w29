package com.bootcamp.ropita_extra.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClothesDto {
    private String code;
    @NotBlank
    private String name;
    @NotBlank
    private String type;
    @NotBlank
    private String brand;
    @NotBlank
    private String color;
    @Pattern(regexp = "^(S|M|L|XL|XXL)$", message = "size can only have the following values: S, M, L, XL, XXL")
    private String size;
    @Positive(message = "amount cant be negative or zero")
    private Integer amount;
    @PositiveOrZero(message = "price cant be negative or zero")
    private Double price;
}
