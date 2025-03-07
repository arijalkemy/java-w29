package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.bootcampW22.EjercicioGlobal.util.VehicleUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class VehicleServiceTest {

    @Mock
    private VehicleRepositoryImpl vehicleRepository;

    @InjectMocks
    private VehicleServiceImpl vehicleService;

    @Test
    public void searchVehiclesByYearAndColor_ReturnVehicleListFiltered(){
        String color = "Green";
        int year = 1960;

        List<Vehicle> vehicleList = VehicleUtil.getVehiclesListYearAndColor();
        List<VehicleDto> expectedVehicleDtoList = vehicleList.stream().map(VehicleUtil::entityToDTO).toList();

        when(vehicleRepository.findVehiclesByYearAndColor(color, year)).thenReturn(vehicleList);

        List<VehicleDto> vehicleDtoListRes = vehicleService.searchVehiclesByYearAndColor(color, year);

        verify(vehicleRepository).findVehiclesByYearAndColor(color, year);
        assertEquals(expectedVehicleDtoList, vehicleDtoListRes);
    }


    @Test
    public void searchVehiclesByYearAndColor_returnThrowNotFoundException(){
        String color = "Green";
        int year = 1960;

        when(vehicleRepository.findVehiclesByYearAndColor(color, year)).thenReturn(new ArrayList<>());

        Exception exception = assertThrows(NotFoundException.class, () -> vehicleService.searchVehiclesByYearAndColor(color, year));

        assertEquals("No se encontraron vehículos con esos criterios.", exception.getMessage());
        verify(vehicleRepository).findVehiclesByYearAndColor(color, year);
    }
}
