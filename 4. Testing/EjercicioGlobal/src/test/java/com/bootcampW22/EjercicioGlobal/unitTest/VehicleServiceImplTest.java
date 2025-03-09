package com.bootcampW22.EjercicioGlobal.unitTest;

import com.bootcampW22.EjercicioGlobal.dto.VehicleAvgSpeedByBrandDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import com.bootcampW22.EjercicioGlobal.utils.TestDataUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class VehicleServiceImplTest {

    @Mock
    private VehicleRepositoryImpl vehicleRepository;

    @InjectMocks
    private VehicleServiceImpl vehicleService;

    @Test
    @DisplayName("Happy path")
    void testFindVehicleByYearAndColor_Found() {
        String color = "Red";
        int year = 2020;
        when(vehicleRepository.findVehiclesByYearAndColor(color, year))
                .thenReturn(List.of(TestDataUtil.getVehicleRedAnd2020()));

        List<VehicleDto> result = vehicleService.searchVehiclesByYearAndColor(color, year);

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
        assertEquals(color, result.get(0).getColor());

        verify(vehicleRepository, times(1)).findVehiclesByYearAndColor(color, 2020);
    }

    @Test
    @DisplayName("Sad path")
    void testFindVehicleByYearAndColor_NotFound() {
        when(vehicleRepository.findVehiclesByYearAndColor("pink", 2050))
                .thenReturn(List.of());

        NotFoundException exception = assertThrows(NotFoundException.class, () ->
                vehicleService.searchVehiclesByYearAndColor("pink", 2050)
        );

        assertEquals("No se encontraron vehículos con esos criterios.", exception.getMessage());

        verify(vehicleRepository, times(1)).findVehiclesByYearAndColor("pink", 2050);
    }

    @Test
    @DisplayName("Happy path")
    void testSearchVehiclesByBrandAndRangeOfYear_found(){
        String brand = "Pontiac";
        int start_year = 1980;
        int end_year = 2000;

        when(this.vehicleRepository.findVehiclesByBrandAndRangeOfYear(brand, start_year, end_year))
                .thenReturn(List.of(TestDataUtil.getVehiclePontiac1987()));

        List<VehicleDto> result = this.vehicleService.searchVehiclesByBrandAndRangeOfYear(brand, start_year, end_year);
        assertEquals(brand, result.get(0).getBrand());
    }

    @Test
    @DisplayName("Sad path")
    void testSearchVehiclesByBrandAndRangeOfYear_Not_found(){
        String brand = "Pontiac";
        int start_year = 2040;
        int end_year = 2050;

        when(this.vehicleRepository
                        .findVehiclesByBrandAndRangeOfYear(brand, start_year, end_year))
                        .thenReturn(List.of());

        assertThrows(NotFoundException.class, () -> this.vehicleService.searchVehiclesByBrandAndRangeOfYear(brand, start_year, end_year));
    }

    @Test
    @DisplayName("Happy Path | Value different from 0")
    void calculateAvgSpeedByBrand_Found(){
        String brand = "Toyota";
        when(this.vehicleRepository
                .findVehiclesByBrand(brand))
                .thenReturn(TestDataUtil.getToyotaTestVehicles());

        VehicleAvgSpeedByBrandDto result = this.vehicleService.calculateAvgSpeedByBrand(brand);
        assertNotEquals(0.0, result.getAverage_speed());

    }

    @Test @DisplayName("Sad Path")
    void calculateAvgSpeedByBrand_NotFound(){
        String brand = "Toyota";

        when(this.vehicleRepository
                .findVehiclesByBrand(brand))
                .thenReturn(List.of());

        assertThrows(NotFoundException.class, () -> this.vehicleService.calculateAvgSpeedByBrand(brand));
    }

    @Test
    @DisplayName("Happy Path | Value different from 0")
    void VehicleAvgCapacityByBrandDto_Found(){
        String brand = "Toyota";
        when(this.vehicleRepository.findVehiclesByBrand(brand))
                .thenReturn(TestDataUtil.getToyotaTestVehicles());

        assertNotEquals(0.0, this.vehicleService.calculateAvgCapacityByBrand(brand).getAverage_capacity());
        assertEquals(5.0, this.vehicleService.calculateAvgCapacityByBrand(brand).getAverage_capacity());

    }

    @Test @DisplayName("Sad Path")
    void cVehicleAvgCapacityByBrandDto_NotFound(){
        String brand = "Toyota";

        when(this.vehicleRepository
                .findVehiclesByBrand(brand))
                .thenReturn(List.of());

        assertThrows(NotFoundException.class, () -> this.vehicleService.calculateAvgCapacityByBrand(brand));
    }

    @Test
    @DisplayName("Happy Path | Vehicles found in weight range")
    void testSearchVehiclesByRangeOfWeight_Found() {
        double minWeight = 1000.0;
        double maxWeight = 2000.0;

        when(vehicleRepository.findVehiclesByRangeOfWeight(minWeight, maxWeight))
                .thenReturn(TestDataUtil.getVehiclesByWeightRange());

        List<VehicleDto> result = vehicleService.searchVehiclesByRangeOfWeight(minWeight, maxWeight);

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertTrue(result.get(0).getWeight() >= minWeight && result.get(0).getWeight() <= maxWeight);

        verify(vehicleRepository, times(1)).findVehiclesByRangeOfWeight(minWeight, maxWeight);
    }
    @Test
    @DisplayName("Sad Path | No vehicles found in weight range")
    void testSearchVehiclesByRangeOfWeight_NotFound() {
        double minWeight = 5000.0;
        double maxWeight = 6000.0;

        when(vehicleRepository.findVehiclesByRangeOfWeight(minWeight, maxWeight))
                .thenReturn(List.of());

        NotFoundException exception = assertThrows(NotFoundException.class, () ->
                vehicleService.searchVehiclesByRangeOfWeight(minWeight, maxWeight));

        assertEquals("No se encontraron vehículos en ese rango de peso.", exception.getMessage());

        verify(vehicleRepository, times(1)).findVehiclesByRangeOfWeight(minWeight, maxWeight);
    }

}
