package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class VehicleRepositoryTest {

    private VehicleRepositoryImpl vehicleRepository;

    @BeforeEach
    public void setUp() throws IOException {
        vehicleRepository = new VehicleRepositoryImpl();
    }

    @Test
    @DisplayName("EP01 - Happy Path: Search Vehicule By Year and Color")
    public void findVehiclesByYearAndColor() {
        List<Vehicle> result = vehicleRepository.findVehiclesByYearAndColor("Maroon", 2002);
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }


}
