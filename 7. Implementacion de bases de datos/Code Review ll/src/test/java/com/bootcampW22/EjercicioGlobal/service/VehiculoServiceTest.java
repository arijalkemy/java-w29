package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleAvgCapacityByBrandDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleAvgSpeedByBrandDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.bootcampW22.EjercicioGlobal.util.UtilVehicle;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.jshell.execution.Util;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class VehiculoServiceTest {

    @Mock
    private VehicleRepositoryImpl vehicleRepository;

    @InjectMocks
    public VehicleServiceImpl service;


    @Test
    void findAll() {
        ObjectMapper mapper = new ObjectMapper();
        String color = "Green";
        int year = 2005;
        Vehicle vehicle = new Vehicle();
        vehicle.setColor(color);
        vehicle.setYear(year);
        List<Vehicle> mockVehicles = List.of(vehicle);
        List<VehicleDto> expected = mockVehicles.stream().map(vehicle1 -> mapper.convertValue(vehicle1, VehicleDto.class)).toList();
        when(vehicleRepository.findAll()).thenReturn(mockVehicles);
        List<VehicleDto> result = service.searchAllVehicles();
        assertEquals(1, result.size());
        assertEquals(expected, result);

    }

    @Test
    void findAllSad() {
        when(vehicleRepository.findAll()).thenReturn(List.of());

        Exception exception = assertThrows(NotFoundException.class, () -> {
            service.searchAllVehicles();
        });

        assertNotNull(exception);
        assertEquals("No se encontró ningun auto en el sistema.", exception.getMessage());
    }

    @Test
    void givenExistingVehicles_whenSearchVehiclesByYearAndColor_thenReturnListOfVehicles() {
        ObjectMapper mapper = new ObjectMapper();
        String color = "Green";
        int year = 2005;

        Vehicle vehicle = new Vehicle();
        vehicle.setColor(color);
        vehicle.setYear(year);
        List<Vehicle> mockVehicles = List.of(vehicle);
        List<VehicleDto> expected = mockVehicles.stream()
                .map(UtilVehicle::toDto)
                .toList();

        when(vehicleRepository.findVehiclesByYearAndColor(color, year)).thenReturn(mockVehicles);

        List<VehicleDto> result = service.searchVehiclesByYearAndColor(color, year);

        assertNotNull(result);
        assertEquals(expected, result);
        assertEquals(1, result.size());
        assertEquals(color, result.get(0).getColor());
        assertEquals(year, result.get(0).getYear());
    }

    @Test
    public void givenNoExistingVehicle_whenSearchVehiclesByYearAndColor_thenReturnNoFoundException() {
        String color = "Green";
        int year = 2005;
        when(vehicleRepository.findVehiclesByYearAndColor(color, year)).thenReturn(List.of());

        Exception exception = assertThrows(NotFoundException.class, () -> {
            service.searchVehiclesByYearAndColor(color, year);
        });

        assertNotNull(exception);
        assertEquals("No se encontraron vehículos con esos criterios.", exception.getMessage());
    }

    @Test
    public void searchVehiclesByBrandAndRangeOfYear() {
        ObjectMapper mapper = new ObjectMapper();
        Vehicle vehicle = UtilVehicle.createDefaultVehicle();
        List<Vehicle> mockVehicle = List.of(vehicle);
        List<VehicleDto> expected = mockVehicle.stream().map(UtilVehicle::toDto).toList();
        when(vehicleRepository.findVehiclesByBrandAndRangeOfYear("Toyota", 2003, 2009)).thenReturn(mockVehicle);

        List<VehicleDto> result = service.searchVehiclesByBrandAndRangeOfYear("Toyota", 2003, 2009);

        assertNotNull(result);
        assertEquals(expected, result);
        assertEquals(1, result.size());
    }

    @Test
    public void searchVehiclesByBrandAndRangeOfYearsad() {
        String brand = "Toyota";
        int starYear = 2003;
        int endYear = 2007;
        when(vehicleRepository.findVehiclesByBrandAndRangeOfYear(brand, starYear, endYear)).thenReturn(List.of());

        Exception exception = assertThrows(NotFoundException.class, () -> {
            service.searchVehiclesByBrandAndRangeOfYear(brand, starYear, endYear);
        });

        assertNotNull(exception);
        assertEquals("No se encontraron vehículos con esos criterios.", exception.getMessage());
    }

    @Test
    public void calculateAvgSpeedByBrand() {
        Vehicle vehicle = UtilVehicle.createDefaultVehicle();
        List<Vehicle> mockVehicle = List.of(vehicle);
        when(vehicleRepository.findVehiclesByBrand(vehicle.getBrand())).thenReturn(mockVehicle);

        VehicleAvgSpeedByBrandDto result = service.calculateAvgSpeedByBrand(vehicle.getBrand());

        assertNotNull(result);
        assertEquals(120, result.getAverage_speed());
        verify(vehicleRepository, atLeastOnce()).findVehiclesByBrand(vehicle.getBrand());

    }

    @Test
    public void calculateAvgSpeedByBrand_WhenNoVehiclesFound_ThrowsNotFoundException() {
        String brand = "Toyota";

        when(vehicleRepository.findVehiclesByBrand(brand)).thenReturn(List.of());

        Exception exception = assertThrows(NotFoundException.class, () -> {
            service.calculateAvgSpeedByBrand(brand);
        });

        assertEquals("No se encontraron vehículos de esa marca.", exception.getMessage());
    }

    @Test
    public void calculateAvgCapacityByBrand() {
        Vehicle vehicle = UtilVehicle.createDefaultVehicle();
        List<Vehicle> mockVehicle = List.of(vehicle);
        when(vehicleRepository.findVehiclesByBrand(vehicle.getBrand())).thenReturn(mockVehicle);

        VehicleAvgCapacityByBrandDto result = service.calculateAvgCapacityByBrand(vehicle.getBrand());

        assertNotNull(result);
        assertEquals(5, result.getAverage_capacity());
        verify(vehicleRepository, atLeastOnce()).findVehiclesByBrand(vehicle.getBrand());
    }

    @Test
    public void calculateAvgCapacityByBrandSad() {
        String brand = "Toyota";

        when(vehicleRepository.findVehiclesByBrand(brand)).thenReturn(List.of());

        Exception exception = assertThrows(NotFoundException.class, () -> {
            service.calculateAvgCapacityByBrand(brand);
        });

        assertEquals("No se encontraron vehículos de esa marca.", exception.getMessage());
    }

    @Test
    public void searchVehiclesByRangeOfWeight() {
        ObjectMapper mapper = new ObjectMapper();
        double minWeight = 1000.0;
        double maxWeight = 2000.0;
        Vehicle vehicle = UtilVehicle.createDefaultVehicle();
        List<Vehicle> mockVehicle = List.of(vehicle);
        List<VehicleDto> expetected = mockVehicle.stream().map(vehicle1 -> mapper.convertValue(vehicle1, VehicleDto.class)).toList();
        when(vehicleRepository.findVehiclesByRangeOfWeight(minWeight, maxWeight)).thenReturn(mockVehicle);

        List<VehicleDto> result = service.searchVehiclesByRangeOfWeight(minWeight, maxWeight);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(expetected, result);
        verify(vehicleRepository, atLeastOnce()).findVehiclesByRangeOfWeight(minWeight, maxWeight);

    }

    @Test
    public void searchVehiclesByRangeOfWeightsad() {
        double minWeight = 1000.0;
        double maxWeight = 2000.0;
        when(vehicleRepository.findVehiclesByRangeOfWeight(minWeight, maxWeight)).thenReturn(List.of());

        Exception exception = assertThrows(NotFoundException.class, () -> {
            service.searchVehiclesByRangeOfWeight(minWeight, maxWeight);
        });
        assertNotNull(exception);
        assertEquals("No se encontraron vehículos en ese rango de peso.", exception.getMessage());
    }

}


