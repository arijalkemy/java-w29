package com.thiagoschreck.local.ej_concensionaria_autos.dto.response;

import java.util.List;

public record NewVehicleResponseDTO(
        int id,
        String brand,
        String model,
        String manufacturingDate,
        String numberOfKilometers,
        String doors,
        String price,
        String currency,
        List<NewVehicleServicesResponseDTO> services,
        String countOfOwners
) {
    public record NewVehicleServicesResponseDTO(String date, String kilometers, String descriptions) {
    }
}
