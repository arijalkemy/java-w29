package com.social_media.social_media.dto.request;

import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StockRequestDto {
    @PositiveOrZero(message = "El campo no puede ser menor a 0.")
    private Long units;
}
