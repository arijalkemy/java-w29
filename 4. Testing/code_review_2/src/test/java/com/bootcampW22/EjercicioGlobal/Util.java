package com.bootcampW22.EjercicioGlobal;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;

public class Util {

    public static List<Vehicle> getVehiculeList() {
        return List.of(new Vehicle(1L, "test", 2022), new Vehicle(2L, "test2", 2022));
    }

    public static List<VehicleDto> getVehiculeDtoList() {
        return List.of(new VehicleDto(1L, "test", 2022), new VehicleDto(2L, "test2", 2022));
    }


}
