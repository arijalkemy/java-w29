package com.org.meli.vehiculoshql.controller;

import com.org.meli.vehiculoshql.service.IVehicleService;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

public class VehicleControllerImpl {
    @RestController
    @Data
    @RequestMapping("/api/vehicles")
    public class VehicleController {
        private final IVehicleService vehicleService;
        @GetMapping("/license-plates")
        public List<String> getAllLicensePlates() {
            return vehicleService.getAllLicensePlates();
        }
    }
}
