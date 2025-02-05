package com.project.be_java_hisp_w29_g10.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequestDto {
        private Long product_id;
        private String product_name;
        private String type;
        private String brand;
        private String color;
        private String notes;
}
