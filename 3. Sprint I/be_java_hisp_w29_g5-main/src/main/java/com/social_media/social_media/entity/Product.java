package com.social_media.social_media.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    private Long productId;
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;

}
