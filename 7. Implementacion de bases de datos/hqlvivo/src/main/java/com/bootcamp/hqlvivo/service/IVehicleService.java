package com.bootcamp.hqlvivo.service;

import com.bootcamp.hqlvivo.dto.VehicleAccidentTotalLossDTO;
import com.bootcamp.hqlvivo.dto.VehicleLicensePlateAndBrandAndModelDTO;
import com.bootcamp.hqlvivo.dto.VehicleLicensePlateAndBrandDTO;
import com.bootcamp.hqlvivo.dto.VehicleLicensePlateDTO;

import java.util.List;

public interface IVehicleService {
    //    Listar las patentes de todos los vehículos registrados.
    List<VehicleLicensePlateDTO> findAllLicensePlates();

    //    Listar la patente y la marca de todos los vehículos ordenados por año de fabricación.
    List<VehicleLicensePlateAndBrandDTO> findAllLicensePlatesAndBrandsOrderedByManufacturingYear();

    //    Listar la patente de todos los vehículos que tengan más de cuatro ruedas y hayan sido fabricados en el corriente año.
    List<VehicleLicensePlateDTO> findAllLicensePlatesWithMoreThanFourWheelsAndManufacturedInCurrentYear();

    //    Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos.
    List<VehicleLicensePlateAndBrandAndModelDTO> findAllLicensePlatesAndBrandsAndModelWithLossGreaterThan10000();

    //    Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor
    //    de 10000 pesos y mostrar a cuánto ascendió la pérdida total de todos ellos.
    List<VehicleAccidentTotalLossDTO> findAllLicensePlatesAndBrandsAndModelWithLossGreaterThan10000AndTotalLoss();
}
