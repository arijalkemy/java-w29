package com.meli.concesionarioseguros.service;

import java.util.HashMap;
import java.util.List;

public interface IVehiculoService {
    List<String> findAllVehiclesPatents(Integer minWheels, Integer year);

    List<HashMap<String, String>> findAllVehiclesPatentsAndBrands(String sortOrder);

    List<HashMap<String, String>> findVehiclesByAmountAccidentsDetails(String minLoss);

    List<HashMap<String, String>> findVehiclesByAmountAccidentSummary(String minLoss);
}
