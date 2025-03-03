package com.bootcampW22.EjercicioGlobal.service;


import com.bootcampW22.EjercicioGlobal.Util;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
        List<VehicleDto> dtos = Util.getVehiculeDtoList();
        List<Vehicle> entities = Util.getVehiculeList();
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


}
