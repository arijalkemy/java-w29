package com.org.meli.vehiculoshql.service;

import com.org.meli.vehiculoshql.repository.IVehicleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VehicleServiceImpl implements IVehicleService {
    private final IVehicleRepository vehicleRepository;

    public List<String> getAllLicensePlates() {
        return vehicleRepository.findAllLicensePlates();
    }

    @Override
    public List<Object[]> getLicensePlateAndBrandOrderedByYear() {
        return vehicleRepository.findLicensePlateAndBrandOrderedByYear();
    }

    @Override
    public List<String> getLicensePlatesWithMoreThanFourWheelsCurrentYear() {
        return vehicleRepository.findLicensePlatesWithMoreThanFourWheelsCurrentYear();
    }

    @Override
    public List<Object[]> getVehiclesWithAccidentLossGreaterThan10000() {
        return vehicleRepository.findVehiclesWithAccidentLossGreaterThan10000();
    }

    @Override
    public List<Object[]> getVehiclesWithAccidentLossGreaterThan10000WithTotalLoss() {
        return vehicleRepository.findVehiclesWithAccidentLossGreaterThan10000WithTotalLoss();
    }

}
