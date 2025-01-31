package com.thiagoschreck.local.ej_concensionaria_autos.dto.response;

public record VehicleResponseDTO(
        String brand,
        String model,
        String manufacturingDate,
        String numberOfKilometers,
        String doors,
        String price,
        String currency,
        String countOfOwners
) {
}
