package com.bootcampw29.siniestros_autos.service;

import com.bootcampw29.siniestros_autos.dto.response.VehiclePatentBrandDTO;
import com.bootcampw29.siniestros_autos.dto.response.VehicleSummaryDTO;
import com.bootcampw29.siniestros_autos.dto.response.VehicleTotalLossDTO;
import com.bootcampw29.siniestros_autos.projection.VehicleEconomicLossTotalProjection;
import com.bootcampw29.siniestros_autos.projection.VehiclePatentProjection;
import com.bootcampw29.siniestros_autos.projection.VehicleSummaryProjection;
import com.bootcampw29.siniestros_autos.repository.VehicleRepository;
import jdk.swing.interop.SwingInterOpUtils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;
    private final ModelMapper modelMapper;

    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public List<String> searchAllPatents() {
        List<VehiclePatentProjection> vehiclePatents = this.vehicleRepository.findAllPatents();
        return vehiclePatents.stream()
                .map(VehiclePatentProjection::getPatent)
                .toList();
    }

    @Override
    public List<VehiclePatentBrandDTO> searchAllVehiclesOrderedByFabricationYear() {
        List<VehicleSummaryProjection> vehiclesSummary = this.vehicleRepository.findAllVehiclesOrderedByFabricationYear();
        return vehiclesSummary.stream()
                .map(vs -> modelMapper.map(vs, VehiclePatentBrandDTO.class))
                .toList();
    }

    @Override
    public List<String> searchAllPatentsInCurrentYearByTiresGreaterThan(Integer numberOfTires) {
        numberOfTires = Objects.isNull(numberOfTires) ? 4 : numberOfTires;
        List<VehiclePatentProjection> vehiclesSummary = this.vehicleRepository
                .findVehiclesByNumberOfTiresGreaterThanAndCurrentFabricationYear(numberOfTires);
        return vehiclesSummary.stream()
                .map(VehiclePatentProjection::getPatent)
                .toList();
    }

    @Override
    public List<VehicleSummaryDTO> searchVehiclesByEconomicLossGreaterThan(Double economicLoss) {
        economicLoss = Objects.isNull(economicLoss) ? 10000 : economicLoss;
        List<VehicleSummaryProjection> vehiclesSummary = this.vehicleRepository
                .findVehiclesWithAccidentEconomicLossGreaterThan(economicLoss);
        return vehiclesSummary.stream()
                .map(vs -> modelMapper.map(vs, VehicleSummaryDTO.class))
                .toList();
    }

    @Override
    public List<VehicleTotalLossDTO> searchVehiclesWithTotalLossGreaterThan(Double economicLoss) {
        economicLoss = Objects.isNull(economicLoss) ? 10000 : economicLoss;
        List<VehicleEconomicLossTotalProjection> vehiclesSummary = this.vehicleRepository
                .findVehiclesWithAccidentEconomicLossGreaterThanAndTotalEconomicLoss(economicLoss);
        return vehiclesSummary.stream()
                .map(vs -> modelMapper.map(vs, VehicleTotalLossDTO.class))
                .toList();
    }
}
