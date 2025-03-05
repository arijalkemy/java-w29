package com.bootcampW22.EjercicioGlobal.service;


import com.bootcampW22.EjercicioGlobal.Util;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class VehicleServiceTest {

    @Mock
    private IVehicleRepository vehicleRepository;

    @InjectMocks
    private VehicleServiceImpl vehicleService;

    @Test
    @DisplayName("EP01 - Happy Path: Search Vehicule By Year and Color")
    public void searchVehiclesByYearAndColor() {
        List<VehicleDto> dtos = new ArrayList<>();
        dtos.add(new VehicleDto());
        List<Vehicle> entities = new ArrayList<>();
        entities.add(new Vehicle());
        when(vehicleRepository.findVehiclesByYearAndColor(anyString(), anyInt())).thenReturn(entities);
        List<VehicleDto> result = vehicleService.searchVehiclesByYearAndColor(anyString(), anyInt());
        assertEquals(dtos, result);
        verify(vehicleRepository).findVehiclesByYearAndColor(anyString(), anyInt());
    }

    @Test
    @DisplayName("EP01 - Sad Path: Search Vehicule By Year and Color Throws NotFoundException.class")
    public void searchVehiclesByYearAndColorThrowsNotFoundException() {
        when(vehicleRepository.findVehiclesByYearAndColor(anyString(), anyInt())).thenThrow(NotFoundException.class);
        assertThrows(NotFoundException.class, () -> vehicleService.searchVehiclesByYearAndColor(anyString(), anyInt()));
    }

    @Test
    @DisplayName("EP02 - Happy path: searchVehiclesByBrandAndRangeOfYear ok")
    public void searchVehiclesByBrandAndRangeOfYear(){
        List<VehicleDto> dtos = new ArrayList<>();
        dtos.add(new VehicleDto());
        List<Vehicle> entities = new ArrayList<>();
        entities.add(new Vehicle());
        when(vehicleRepository.findVehiclesByBrandAndRangeOfYear("test", 2024, 2025)).thenReturn(entities);
        List<VehicleDto> result = vehicleService.searchVehiclesByBrandAndRangeOfYear("test", 2024, 2025);
        assertEquals(dtos, result);
    }

    @Test
    @DisplayName("EP02 - Sad path: searchVehiclesByBrandAndRangeOfYear Throws NotFoundException")
    public void searchVehiclesByBrandAndRangeOfYearThrowsNotFoundException(){
        when(vehicleRepository.findVehiclesByBrandAndRangeOfYear("test", 2024, 2025)).thenThrow(NotFoundException.class);
        assertThrows(NotFoundException.class, () -> vehicleService.searchVehiclesByBrandAndRangeOfYear("test", 2024, 2025));
    }


}
