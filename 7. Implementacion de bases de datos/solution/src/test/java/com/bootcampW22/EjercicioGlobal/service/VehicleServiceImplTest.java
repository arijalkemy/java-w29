package com.bootcampW22.EjercicioGlobal.service;


import com.bootcampW22.EjercicioGlobal.dto.VehicleAvgCapacityByBrandDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleAvgSpeedByBrandDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class VehicleServiceImplTest {
    @Mock
    private VehicleRepositoryImpl vehicleRepository;

    @InjectMocks
    private VehicleServiceImpl vehicleService;

    @Test
    @DisplayName("Happy Path")
    void testSearchVehiclesByYearAndColorFound(){
        //arrange
        List<Vehicle> vehicles = List.of(
                new Vehicle(1L, "Renault", "Kwid", "JVO", "Red", 2021, "150", 5, "Gasoline", "Manual", 1.0, 1.0, 1000.0 )
        );
        when(vehicleRepository.findVehiclesByYearAndColor("Red", 2021)).thenReturn(vehicles);
        //Act
        List<VehicleDto> result = vehicleService.searchVehiclesByYearAndColor("Red", 2021);
        //assert
        Assertions.assertEquals(1,result.size());
    }
    @Test
    @DisplayName("Sad path")
    void testSearchVehiclesByYearAndColorNotFound(){
        //arrange
        when(vehicleRepository.findVehiclesByYearAndColor("Red", 2021)).thenReturn(Collections.emptyList());
        //act & assert
        NotFoundException exception = Assertions.assertThrows(NotFoundException.class, () -> vehicleService.searchVehiclesByYearAndColor("Red", 2021));
        Assertions.assertEquals("No se encontraron vehículos con esos criterios.", exception.getMessage());
    }
    @Test
    void testSearchVehiclesByBrandAndRangeOfYearFound(){
        //arrange
        List<Vehicle> vehicles = List.of(new Vehicle(2416L, "Renault", "Kwid", "JVO", "Red", 2021, "167", 5, "Gasoline", "Manual", 1.0, 2.0, 1000.0));
        when(vehicleRepository.findVehiclesByBrandAndRangeOfYear("Renault", 2020,2023)).thenReturn(vehicles);
        //act
        List<VehicleDto> result = vehicleService.searchVehiclesByBrandAndRangeOfYear("Renault", 2020,2023);
        //assert
        Assertions.assertEquals(2416L, result.get(0).getId());
    }
    @Test
    void testSearchVehiclesByBrandAndRangeOfYearNotFound(){
        //arrange
        when(vehicleRepository.findVehiclesByBrandAndRangeOfYear("Renault", 2020, 2023)).thenReturn(Collections.emptyList());
        //act & assert
        NotFoundException exception = Assertions.assertThrows(NotFoundException.class, () -> vehicleService.searchVehiclesByBrandAndRangeOfYear("Renault", 2020, 2023));
        Assertions.assertEquals("No se encontraron vehículos con esos criterios.", exception.getMessage());
    }
    @Test
    void testCalculateAvgSpeedByBrandFound() {
        // Arrange
        List<Vehicle> vehicles = List.of(
                new Vehicle(2416L, "Renault", "Kwid", "JVO", "Red", 2021, "167", 5, "Gasoline", "Manual", 1.0, 2.0, 1000.0),
                new Vehicle(1001L, "Renault", "Duster", "XYZ", "Blue", 2019, "150", 5, "Gasoline", "Automatic", 1.2, 2.2, 1200.0)
        );
        when(vehicleRepository.findVehiclesByBrand("Renault")).thenReturn(vehicles);

        // Act
        VehicleAvgSpeedByBrandDto result = vehicleService.calculateAvgSpeedByBrand("Renault");

        // Assert
        Assertions.assertEquals(158.5, result.getAverage_speed());
    }
    @Test
    @DisplayName("Calcular velocidad promedio por marca - Marca no encontrada - Excepción esperada")
    void testCalculateAvgSpeedByBrandNotFound() {
        // Arrange
        when(vehicleRepository.findVehiclesByBrand("UnknownBrand")).thenReturn(Collections.emptyList());

        // Act & Assert
        NotFoundException exception = Assertions.assertThrows(NotFoundException.class, () -> vehicleService.calculateAvgSpeedByBrand("UnknownBrand"));
        Assertions.assertEquals("No se encontraron vehículos de esa marca.", exception.getMessage());
    }
    @Test
    void testCalculateAvgCapacityByBrandFound(){
        //arrange
        List<Vehicle> vehicles = List.of(new Vehicle(
                2416L, "Renault", "Kwid", "JVO", "Red", 2021, "167", 5, "Gasoline", "Manual", 1.0, 1.0, 1000.0
        ), new Vehicle(
                26L, "Renault", "Kwid", "JVO", "Blue", 2021, "167", 3, "Gasoline", "Manual", 1.0, 1.0, 1000.0
        ));
        when(vehicleRepository.findVehiclesByBrand("Renault")).thenReturn(vehicles);
        //act
        VehicleAvgCapacityByBrandDto result = vehicleService.calculateAvgCapacityByBrand("Renault");
        //assert
        Assertions.assertEquals(4, result.getAverage_capacity());
    }
    @Test
    void testCalculateAvgCapacityByBrandNotFound (){
        //arrange
        when(vehicleRepository.findVehiclesByBrand("Renault")).thenReturn(Collections.emptyList());
        //act & assert
        NotFoundException exception = Assertions.assertThrows(NotFoundException.class, () -> vehicleService.calculateAvgCapacityByBrand("Renault"));
        Assertions.assertEquals("No se encontraron vehículos de esa marca.", exception.getMessage());
    }
    @Test
    void testSearchVehiclesByRangeOfWeightFound(){
        //arrange
        List<Vehicle> vehicles = List.of(
                new Vehicle(
                        2416L, "Renault", "Kwid", "Jvo", "Red", 2021, "167", 5, "Gasoline", "Manual", 1.0, 1.0, 1000.0
                )
        );
        when(vehicleRepository.findVehiclesByRangeOfWeight(999.0,1001.0)).thenReturn(vehicles);
        //act
        List<VehicleDto> result = vehicleService.searchVehiclesByRangeOfWeight(999.0,1001.0);
        //assert
        Assertions.assertEquals(2416L,result.get(0).getId());
    }
    @Test
    void testSearchVehiclesByRangeOfWeightNotFound(){
        //arrange
        when(vehicleRepository.findVehiclesByRangeOfWeight(999.0,1001.0)).thenReturn(Collections.emptyList());
        //act & assert
        NotFoundException exception = Assertions.assertThrows(NotFoundException.class, () -> vehicleService.searchVehiclesByRangeOfWeight(999.0,1001.0));
        Assertions.assertEquals("No se encontraron vehículos en ese rango de peso.", exception.getMessage());
    }
}