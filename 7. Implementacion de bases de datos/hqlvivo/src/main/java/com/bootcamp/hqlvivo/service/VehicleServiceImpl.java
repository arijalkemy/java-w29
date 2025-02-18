package com.bootcamp.hqlvivo.service;

import com.bootcamp.hqlvivo.dto.VehicleAccidentTotalLossDTO;
import com.bootcamp.hqlvivo.dto.VehicleLicensePlateAndBrandAndModelDTO;
import com.bootcamp.hqlvivo.dto.VehicleLicensePlateAndBrandDTO;
import com.bootcamp.hqlvivo.dto.VehicleLicensePlateDTO;
import com.bootcamp.hqlvivo.repository.IVehicleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VehicleServiceImpl implements IVehicleService {

    private final IVehicleRepository vehicleRepository;

    private final ModelMapper modelMapper;

    public VehicleServiceImpl(IVehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
        this.modelMapper = new ModelMapper();
    }

    //    Listar las patentes de todos los vehículos registrados.
    @Override
    public List<VehicleLicensePlateDTO> findAllLicensePlates() {
        return vehicleRepository.findAll()
                .stream()
                .map(v -> modelMapper.map(v, VehicleLicensePlateDTO.class))
                .toList();
    }

    //    Listar la patente y la marca de todos los vehículos ordenados por año de fabricación.
    @Override
    public List<VehicleLicensePlateAndBrandDTO> findAllLicensePlatesAndBrandsOrderedByManufacturingYear() {
        return vehicleRepository.findAllOrderedByManufacturingYear()
                .stream()
                .map(v -> modelMapper.map(v, VehicleLicensePlateAndBrandDTO.class))
                .toList();
    }

    //    Listar la patente de todos los vehículos que tengan más de cuatro ruedas y hayan sido fabricados en el corriente año.
    @Override
    public List<VehicleLicensePlateDTO> findAllLicensePlatesWithMoreThanFourWheelsAndManufacturedInCurrentYear() {
        return vehicleRepository.findAllWithMoreThanFourWheelsAndManufacturedInYear(LocalDate.now().getYear())
                .stream()
                .map(v -> modelMapper.map(v, VehicleLicensePlateDTO.class))
                .toList();
    }

    //    Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos.
    @Override
    public List<VehicleLicensePlateAndBrandAndModelDTO> findAllLicensePlatesAndBrandsAndModelWithLossGreaterThan10000() {
        return vehicleRepository.findAllWithLossGreaterThan10000()
                .stream()
                .map(v -> modelMapper.map(v, VehicleLicensePlateAndBrandAndModelDTO.class))
                .toList();
    }

    //    Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor
    //    de 10000 pesos y mostrar a cuánto ascendió la pérdida total de todos ellos.
    @Override
    public List<VehicleAccidentTotalLossDTO> findAllLicensePlatesAndBrandsAndModelWithLossGreaterThan10000AndTotalLoss() {
        return vehicleRepository.findAllWithLossGreaterThan10000AndTotalLoss()
                .stream().map(arr -> {
                    VehicleAccidentTotalLossDTO dto = modelMapper.map(arr[0], VehicleAccidentTotalLossDTO.class);
                    dto.setTotalLoss((Double) arr[1]);
                    return dto;
                }).toList();
    }

}
