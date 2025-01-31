package com.thiagoschreck.local.ej_concensionaria_autos.dto.request;

import java.util.List;

public record NewVehicleRequestDTO(
        String brand,
        String model,
        String manufacturingDate,
        String numberOfKilometers,
        String doors,
        String price,
        String currency,
        List<NewVehicleServiceRequestDTO> services,
        String countOfOwners
) {
    public record NewVehicleServiceRequestDTO(String date, String kilometers, String descriptions) {
    }
}
