package com.socialmeli.socialmeli.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonPropertyOrder({"product_id", "product_name"})
public class ProductDto {
    @JsonProperty("product_id")
    @NotNull(message = "Product id is required")
    private Integer id;

    @Size(max = 40, message = "Name must be less than 40 characters")
    @NotBlank(message = "Name is required")
    @JsonProperty("product_name")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "Name must contain only letters, numbers and spaces")
    private String name;

    @Size(max = 15, message = "Type must be less than 15 characters")
    @NotBlank(message = "Type is required")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "Type must contain only letters, numbers and spaces")
    private String type;

    @Size(max = 25, message = "Brand must be less than 25 characters")
    @NotBlank(message = "Brand is required")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "Brand must contain only letters, numbers and spaces")
    private String brand;

    @NotBlank(message = "Color is required")
    @Size(max = 15, message = "Color must be less than 15 characters")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "Color must contain only letters, numbers and spaces")
    private String color;

    @NotBlank(message = "Notes is required")
    @Size(max = 80, message = "Notes must be less than 80 characters")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "Notes must contain only letters, numbers and spaces")
    private String notes;
}
