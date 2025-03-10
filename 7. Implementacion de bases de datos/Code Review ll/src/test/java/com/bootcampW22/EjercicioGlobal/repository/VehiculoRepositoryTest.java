package com.bootcampW22.EjercicioGlobal.repository;


import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VehiculoRepositoryTest {

    private IVehicleRepository repository;

    @BeforeEach
    public void SetUp() throws IOException {
        this.repository = new VehicleRepositoryImpl();
    }


    @Test
    void findAll() {
        List<Vehicle> vehicles = repository.findAll();
        assertEquals(5, vehicles.size());
    }

    @Test
    void givenExistingVehicule_WhenFindVehiclesByYearAndColor_thenReturnListOfVehicles() {

        List<Vehicle> vehicles = repository.findVehiclesByYearAndColor("Green", 2005);

        assertEquals(1, vehicles.size());
        assertEquals("Green", vehicles.get(0).getColor());
        assertEquals(2005, vehicles.get(0).getYear());

    }

    @Test
    void givenExistingVehicule_WhenfindVehiclesByBrandAndRangeOfYear_thenReturnListOfVehicles() {

        List<Vehicle> vehicles = repository.findVehiclesByBrandAndRangeOfYear("Toyota", 1994, 2000);

        assertEquals(1, vehicles.size());
        assertTrue(vehicles.get(0).getYear() >= 1994 && vehicles.get(0).getYear() <= 2000);
        assertEquals("Toyota", vehicles.get(0).getBrand());

    }

    //Para completar 100% code average
    @Test
    void givenExistingVehicule_WhenfindVehiclesByBrandAndRangeOfYear2_thenReturnListOfVehicles2() {

        List<Vehicle> vehicles = repository.findVehiclesByBrandAndRangeOfYear("Toyota", 1, 3);

        assertEquals(0, vehicles.size());

    }

    //Para completar 100% code average
    @Test
    void givenExistingVehicule_WhenfindVehiclesByBrandAndRangeOfYear22_thenReturnListOfVehicles2() {

        List<Vehicle> vehicles = repository.findVehiclesByBrandAndRangeOfYear("Toyota", 89908, 209989800);

        assertEquals(0, vehicles.size());

    }

    @Test
    void givenExistingVehicle_whenFindVehiclesByBrand_thenReturnListOfVehicles() {

        List<Vehicle> vehicles = repository.findVehiclesByBrand("Toyota");

        assertEquals(1, vehicles.size());
        assertEquals("Toyota", vehicles.get(0).getBrand());
        assertEquals(4, vehicles.get(0).getId());
    }

    @Test
    void givenExistingVehicle_whenFindVehiclesByRangeOfWeight_thenReturnListOfVehicles() {

        List<Vehicle> vehicles = repository.findVehiclesByRangeOfWeight(50, 150);

        assertEquals(2, vehicles.size());
        assertTrue(vehicles.get(0).getWeight() >= 50 && vehicles.get(0).getWeight() <= 150);

    }


    //Para completar 100% code average
    @Test
    void givenExistingVehicle_whenFindVehiclesByRangeOfWeight_thenReturnListOfVehicles2() {

        List<Vehicle> vehicles = repository.findVehiclesByRangeOfWeight(11111, 151110);

        assertEquals(0, vehicles.size());

    }


}
