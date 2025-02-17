package com.social_media.social_media.dto.response;

import lombok.*;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ProductResponseDto {
    private Long product_id;
    private String product_name;
    private String type;
    private String brand;
    private String color;
    private String notes;
}