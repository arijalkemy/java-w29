package com.org.meli.vehiculoshql.service;

import java.util.List;

public interface IVehicleService {
    public List<String> getAllLicensePlates();
    List<Object[]> getLicensePlateAndBrandOrderedByYear();
    List<String> getLicensePlatesWithMoreThanFourWheelsCurrentYear();
    List<Object[]> getVehiclesWithAccidentLossGreaterThan10000();
    List<Object[]> getVehiclesWithAccidentLossGreaterThan10000WithTotalLoss();
}
