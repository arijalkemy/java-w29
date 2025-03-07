package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleAvgCapacityByBrandDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleAvgSpeedByBrandDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.*;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Random;

import static com.bootcampW22.EjercicioGlobal.utils.TestUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class VehicleServiceTestPractica {
    private static final Faker faker = new Faker();
    private static final Random random = new Random();

    @Mock
    VehicleRepositoryImpl vehicleRepository;

    @InjectMocks
    VehicleServiceImpl vehicleService;

    @Test
    @DisplayName("US0001 - Test Search Vehicles By Year And Color - Happy Path")
    void searchVehiclesByYearAndColorOkTest() {
        // Arrange
        Integer year = 1980 + random.nextInt(45);
        String color = faker.color().name();
        List<Vehicle> vehicles = createListRandomVehiclesWithYearAndColor(10, year, color);

        when(vehicleRepository.findVehiclesByYearAndColor(color, year)).thenReturn(vehicles);

        // Act
        List<VehicleDto> actualResponse = vehicleService.searchVehiclesByYearAndColor(color, year);

        // Assert
        assertEquals(vehicles.size(), actualResponse.size());
        assertTrue(actualResponse.stream().allMatch(v -> v.getColor().equals(color)));
        assertTrue(actualResponse.stream().allMatch(v -> v.getYear() == year));
    }

    @Test
    @DisplayName("US0001 - Test Search Vehicles By Year And Color - NotFoundException")
    void searchVehiclesByYearAndColorThrowNotFoundExceptionTest() {
        // Arrange
        when(vehicleRepository.findVehiclesByYearAndColor(anyString(), anyInt())).thenReturn(List.of());

        // Act & Assert
        String exceptionMessage = "No se encontraron vehículos con esos criterios.";
        NotFoundException exception = assertThrows(NotFoundException.class,
                () -> vehicleService.searchVehiclesByYearAndColor(anyString(), anyInt()));
        assertEquals(exceptionMessage, exception.getMessage());
    }

    @Test
    @DisplayName("US0002 - Test Search Vehicles By Brand And Range Of Year - Happy Path")
    void searchVehiclesByBrandAndRangeOfYearOkTest() {
        // Arrange
        String brand = faker.company().name();
        Integer start_year = 1980 + random.nextInt(45);
        Integer end_year = start_year + random.nextInt(15);

        List<Vehicle> vehicles = createListRandomVehiclesWithBrandAndRangeOfYear(10, brand, start_year, end_year);
        when(vehicleRepository.findVehiclesByBrandAndRangeOfYear(brand,start_year,end_year)).thenReturn(vehicles);

        // Act
        List<VehicleDto> actualResponse = vehicleService.searchVehiclesByBrandAndRangeOfYear(brand, start_year, end_year);

        // Assert
        assertEquals(vehicles.size(), actualResponse.size());
        assertTrue(actualResponse.stream().allMatch(v -> v.getBrand().equalsIgnoreCase(brand)));
        assertTrue(actualResponse.stream().allMatch(v -> start_year <= v.getYear() && v.getYear() <= end_year));
    }

    @Test
    @DisplayName("US0002 - Test Search Vehicles By Brand And Range Of Year - NotFoundException")
    void searchVehiclesByBrandAndRangeOfYearThrowNotFoundExceptionTest() {
        // Arrange
        when(vehicleRepository.findVehiclesByBrandAndRangeOfYear(anyString(), anyInt(), anyInt())).thenReturn(List.of());

        // Act & Assert
        String exceptionMessage = "No se encontraron vehículos con esos criterios.";
        NotFoundException exception = assertThrows(NotFoundException.class,
                () -> vehicleService.searchVehiclesByBrandAndRangeOfYear(anyString(), anyInt(), anyInt()));
        assertEquals(exceptionMessage, exception.getMessage());
    }

    @Test
    @DisplayName("US0003 - Test Calculate Avg Speed By Brand - Happy Path")
    void calculateAvgSpeedByBrandOkTest() {
        // Arrange
        String brand = faker.company().name();
        Vehicle vehicleA = createRandomVehicleWithBrandAndMaxSpeed(brand, "255");
        Vehicle vehicleB = createRandomVehicleWithBrandAndMaxSpeed(brand, "77");
        Vehicle vehicleC = createRandomVehicleWithBrandAndMaxSpeed(brand, "0");
        Vehicle vehicleD = createRandomVehicleWithBrandAndMaxSpeed(brand, "127");
        when(vehicleRepository.findVehiclesByBrand(brand)).thenReturn(List.of(vehicleA, vehicleB, vehicleC, vehicleD));

        // Act
        VehicleAvgSpeedByBrandDto actualResponse = vehicleService.calculateAvgSpeedByBrand(brand);

        // Assert
        assertEquals(114.75, actualResponse.getAverage_speed());
    }

    @Test
    @DisplayName("US0003 - Test Calculate Avg Speed By Brand - NotFoundException")
    void calculateAvgSpeedByBrandThrowNotFoundExceptionTest() {
        // Arrange
        when(vehicleRepository.findVehiclesByBrand(anyString())).thenReturn(List.of());

        // Act & Assert
        String exceptionMessage = "No se encontraron vehículos de esa marca.";
        NotFoundException exception = assertThrows(NotFoundException.class,
                () -> vehicleService.calculateAvgSpeedByBrand(anyString()));
        assertEquals(exceptionMessage, exception.getMessage());
    }

    @Test
    @DisplayName("US0004 - Test Calculate Avg Capacity By Brand - Happy Path")
    void calculateAvgCapacityByBrandOkTest() {
        // Arrange
        String brand = faker.company().name();
        Vehicle vehicleA = createRandomVehicleWithBrandAndPassengers(brand, 3);
        Vehicle vehicleB = createRandomVehicleWithBrandAndPassengers(brand, 7);
        Vehicle vehicleC = createRandomVehicleWithBrandAndPassengers(brand, 2);
        Vehicle vehicleD = createRandomVehicleWithBrandAndPassengers(brand, 10);
        when(vehicleRepository.findVehiclesByBrand(brand)).thenReturn(List.of(vehicleA, vehicleB, vehicleC, vehicleD));

        // Act
        VehicleAvgCapacityByBrandDto actualResponse = vehicleService.calculateAvgCapacityByBrand(brand);

        // Assert
        assertEquals(5.5, actualResponse.getAverage_capacity());
    }

    @Test
    @DisplayName("US0004 - Test Calculate Avg Capacity By Brand - NotFoundException")
    void calculateAvgCapacityByBrandThrowNotFoundExceptionTest() {
        // Arrange
        when(vehicleRepository.findVehiclesByBrand(anyString())).thenReturn(List.of());

        // Act & Assert
        String exceptionMessage = "No se encontraron vehículos de esa marca.";
        NotFoundException exception = assertThrows(NotFoundException.class,
                () -> vehicleService.calculateAvgCapacityByBrand(anyString()));
        assertEquals(exceptionMessage, exception.getMessage());
    }

    @Test
    @DisplayName("US0005 - Test Search Vehicles By Range Of Weight - Happy Path")
    void searchVehiclesByRangeOfWeightOkTest() {
        // Arrange
        Double weight_min = 200 + random.nextDouble() * 1000;
        Double weight_max = weight_min + random.nextDouble() * 1000;

        List<Vehicle> vehicles = createListRandomVehiclesWithRangeOfWeight(10, weight_min, weight_max);
        when(vehicleRepository.findVehiclesByRangeOfWeight(weight_min, weight_max)).thenReturn(vehicles);

        // Act
        List<VehicleDto> actualResponse = vehicleService.searchVehiclesByRangeOfWeight(weight_min, weight_max);

        // Assert
        assertEquals(vehicles.size(), actualResponse.size());
        assertTrue(actualResponse.stream().allMatch(v -> weight_min <= v.getWeight() && v.getWeight() <= weight_max));
    }

    @Test
    @DisplayName("US0005 - Test Search Vehicles By Range Of Weight - NotFoundException")
    void searchVehiclesByRangeOfWeightThrowNotFoundExceptionTest() {
        // Arrange
        when(vehicleRepository.findVehiclesByRangeOfWeight(anyDouble(), anyDouble())).thenReturn(List.of());

        // Act & Assert
        String exceptionMessage = "No se encontraron vehículos en ese rango de peso.";
        NotFoundException exception = assertThrows(NotFoundException.class,
                () -> vehicleService.searchVehiclesByRangeOfWeight(anyDouble(), anyDouble()));
        assertEquals(exceptionMessage, exception.getMessage());
    }
}
