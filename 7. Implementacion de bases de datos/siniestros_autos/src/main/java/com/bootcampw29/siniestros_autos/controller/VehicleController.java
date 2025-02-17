package com.bootcampw29.siniestros_autos.controller;

import com.bootcampw29.siniestros_autos.dto.response.VehiclePatentBrandDTO;
import com.bootcampw29.siniestros_autos.dto.response.VehicleSummaryDTO;
import com.bootcampw29.siniestros_autos.dto.response.VehicleTotalLossDTO;
import com.bootcampw29.siniestros_autos.service.VehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/patents")
    public ResponseEntity<List<String>> getAllVehiclePatents() {
        return new ResponseEntity<>(this.vehicleService.searchAllPatents(), HttpStatus.OK);
    }

    @GetMapping("/patents-brand")
    public ResponseEntity<List<VehiclePatentBrandDTO>> getAllVehiclesOrderedByFabricationYear() {
        return new ResponseEntity<>(this.vehicleService.searchAllVehiclesOrderedByFabricationYear(),
                HttpStatus.OK);
    }

    @GetMapping("/patents/current-year")
    public ResponseEntity<List<String>> getAllVehiclePatentsInCurrentYearWithNumberOfTiresGreaterThan(
            @RequestParam(required = false) Integer numberOfTires
    ) {
        return new ResponseEntity<>(
                this.vehicleService.searchAllPatentsInCurrentYearByTiresGreaterThan(numberOfTires),
                HttpStatus.OK);
    }

    @GetMapping("/accidents")
    public ResponseEntity<List<VehicleSummaryDTO>> getAllVehiclesWithAccidents(
            @RequestParam(required = false) Double economicLoss) {
        return new ResponseEntity<>(
                this.vehicleService.searchVehiclesByEconomicLossGreaterThan(economicLoss),
                HttpStatus.OK);
    }

    @GetMapping("/accidents/total-loss")
    public ResponseEntity<List<VehicleTotalLossDTO>> getAllVehiclesWithTotalEconomicLoss(
            @RequestParam(required = false) Double economicLoss) {
        return new ResponseEntity<>(
                this.vehicleService.searchVehiclesWithTotalLossGreaterThan(economicLoss),
                HttpStatus.OK
        );
    }
}
