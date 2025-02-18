package com.bootcamp.hqlvivo.controller;

import com.bootcamp.hqlvivo.dto.VehicleLicensePlateAndBrandAndModelDTO;
import com.bootcamp.hqlvivo.dto.VehicleLicensePlateAndBrandDTO;
import com.bootcamp.hqlvivo.dto.VehicleLicensePlateDTO;
import com.bootcamp.hqlvivo.service.IVehicleService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/vehicles")
@AllArgsConstructor
public class VehicleController {

    private final IVehicleService vehicleService;

    @GetMapping("/license-plates")
    public ResponseEntity<List<VehicleLicensePlateDTO>> getAllLicensePlates() {
        return ResponseEntity.ok(vehicleService.findAllLicensePlates());
    }


    @GetMapping("/license-plates-and-brands")
    public ResponseEntity<List<VehicleLicensePlateAndBrandDTO>> getAllLicensePlatesAndBrandsOrderedByManufacturingYear() {
        return ResponseEntity.ok(vehicleService.findAllLicensePlatesAndBrandsOrderedByManufacturingYear());
    }

    @GetMapping("/license-plates-with-more-than-four-wheels-and-manufactured-in-current-year")
    public ResponseEntity<List<VehicleLicensePlateDTO>> getAllLicensePlatesWithMoreThanFourWheelsAndManufacturedInCurrentYear() {
        return ResponseEntity.ok(vehicleService.findAllLicensePlatesWithMoreThanFourWheelsAndManufacturedInCurrentYear());
    }

    @GetMapping("/license-plates-and-brands-and-model-with-loss-greater-than-10000")
    public ResponseEntity<List<VehicleLicensePlateAndBrandAndModelDTO>> getAllLicensePlatesAndBrandsAndModelWithLossGreaterThan10000() {
        return ResponseEntity.ok(vehicleService.findAllLicensePlatesAndBrandsAndModelWithLossGreaterThan10000());
    }


    @GetMapping("/license-plates-and-brands-and-model-with-loss-greater-than-10000-and-total-loss")
    public ResponseEntity<?> getAllLicensePlatesAndBrandsAndModelWithLossGreaterThan10000AndTotalLoss() {
        return ResponseEntity.ok(vehicleService.findAllLicensePlatesAndBrandsAndModelWithLossGreaterThan10000AndTotalLoss());
    }
}
