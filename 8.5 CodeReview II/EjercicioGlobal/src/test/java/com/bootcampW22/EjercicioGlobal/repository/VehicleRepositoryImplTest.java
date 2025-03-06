package com.bootcampW22.EjercicioGlobal.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.util.TestVehiclesUtil;

public class VehicleRepositoryImplTest {
  VehicleRepositoryImpl vehicle_repository;

  @BeforeEach
  void setUpEach() throws IOException {
    TestVehiclesUtil.resetJSONFile();
    vehicle_repository = new VehicleRepositoryImpl();
  }

  @Test
  void testFindVehiclesByBrand() {
    //arrange
    String brand = "Pontiac";
    List<Vehicle> expected_response = TestVehiclesUtil.getSomeVehicles().stream()
      .filter(vehicle -> vehicle.getBrand().equals(brand))
      .toList();
    //act
    List<Vehicle> actual_response = vehicle_repository.findVehiclesByBrand(brand);
    //assert
    assertIterableEquals(expected_response, actual_response);
    assertEquals(expected_response, actual_response);
  }
}
