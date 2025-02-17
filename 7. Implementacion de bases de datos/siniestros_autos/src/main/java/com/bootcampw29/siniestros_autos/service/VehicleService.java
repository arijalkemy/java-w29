package com.bootcampw29.siniestros_autos.service;

import com.bootcampw29.siniestros_autos.dto.response.VehiclePatentBrandDTO;
import com.bootcampw29.siniestros_autos.dto.response.VehicleSummaryDTO;
import com.bootcampw29.siniestros_autos.dto.response.VehicleTotalLossDTO;

import java.util.List;

public interface VehicleService {
    List<String> searchAllPatents();
    List<VehiclePatentBrandDTO> searchAllVehiclesOrderedByFabricationYear();
    List<String> searchAllPatentsInCurrentYearByTiresGreaterThan(Integer numberOfTires);
    List<VehicleSummaryDTO> searchVehiclesByEconomicLossGreaterThan(Double economicLoss);
    List<VehicleTotalLossDTO> searchVehiclesWithTotalLossGreaterThan(Double economicLoss);
}
