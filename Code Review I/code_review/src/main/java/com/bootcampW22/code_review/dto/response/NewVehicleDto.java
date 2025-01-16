package com.bootcampW22.code_review.dto.response;

public record NewVehicleDto(Long id) {
    @Override
    public String toString() {
        return "Se creó satisfactoriamente el vehículo de id: " + id;
    }
}
