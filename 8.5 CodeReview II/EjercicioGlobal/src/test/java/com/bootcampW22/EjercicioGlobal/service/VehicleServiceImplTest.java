package com.bootcampW22.EjercicioGlobal.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.bootcampW22.EjercicioGlobal.util.TestVehiclesUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
public class VehicleServiceImplTest {

  @Mock
  private VehicleRepositoryImpl vehicle_repository;
  
  @InjectMocks
  private VehicleServiceImpl vehicle_service;

  @Test
  void testSearchVehiclesByBrandAndRangeOfYear() {
    //arrage
    String brand = "Pontiac";
    Integer start_year = 1900;
    Integer end_year = 2000;

    ObjectMapper mapper = new ObjectMapper();
    List<Vehicle> vehicles = TestVehiclesUtil.getSomeVehicles();
    List<VehicleDto> expected_response = mapper.convertValue(vehicles, new TypeReference<List<VehicleDto>> () {});
    when(vehicle_repository.findVehiclesByBrandAndRangeOfYear("Pontiac", start_year, end_year)).thenReturn(vehicles);
    //act
    List<VehicleDto> actual_response = vehicle_service.searchVehiclesByBrandAndRangeOfYear(brand, start_year, end_year);
    //assert
    verify(
      vehicle_repository,
      atLeastOnce()
    ).findVehiclesByBrandAndRangeOfYear("Pontiac", start_year, end_year);
    assertEquals(expected_response, actual_response);
  }

  @Test
  void testSearchVehiclesByBrandAndRangeOfYearIsEmpty() {
    //arrage
    String brand = "Pontiac";
    Integer start_year = 1900;
    Integer end_year = 2000;

    List<Vehicle> vehicles = new ArrayList<Vehicle>();
    when(vehicle_repository.findVehiclesByBrandAndRangeOfYear("Pontiac", start_year, end_year)).thenReturn(vehicles);
    //act //assert
    NotFoundException exception = assertThrows(NotFoundException.class, () -> {
      vehicle_service.searchVehiclesByBrandAndRangeOfYear(brand, start_year, end_year);
    });
    verify(
      vehicle_repository,
      atLeastOnce()
    ).findVehiclesByBrandAndRangeOfYear("Pontiac", start_year, end_year);
    assertEquals(exception.getMessage(), "No se encontraron vehículos con esos criterios.");
  }
}
