package com.bootcamp.be_java_hisp_w29_g07.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class represents a product that can be posted or sold by a seller.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    /**
     * The unique identifier for the product.
     */
    @JsonProperty("product_id")
    private Integer id;
    /**
     * The name of the product.
     */
    @JsonProperty("product_name")
    private String name;
    /**
     * The type of the product.
     */
    private String type;
    /**
     * The brand of the product.
     */
    private String brand;
    /**
     * The color of the product.
     */
    private String color;
    /**
     * Additional notes or description for the product.
     */
    private String notes;
}
