package com.bootcampw29.siniestros_autos.dto.response;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class VehicleTotalLossDTO extends VehicleSummaryDTO {
    private Double totalEconomicLoss;

    public VehicleTotalLossDTO(String patent, String brand, String model, Double totalEconomicLoss) {
        super(patent, brand, model);
        this.totalEconomicLoss = totalEconomicLoss;
    }
}
