package com.bootcamp.cardealership.dto;

import java.util.List;

public record VehicleDTO(
        String id,
        String brand,
        String model,
        String manufacturingDate,
        String numberOfKilometers,
        String doors,
        String price,
        String currency,
        List<ServiceDTO> services,
        String countOfOwners
) {
}
