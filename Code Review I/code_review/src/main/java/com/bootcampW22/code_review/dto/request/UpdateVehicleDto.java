package com.bootcampW22.code_review.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateVehicleDto {
    private String max_speed;
    private String fuel_type;
}
