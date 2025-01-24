package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();
    String agregarVehiculo(Vehicle vehiculo);
    List<VehicleDto> obtenerVehiculosPorColorYanio(String color, int anio);
    List<VehicleDto> buscarVehiculosPorYrangoDeAnios(String brand, int start_year, int end_year);
    double conocerLaVelocidadPromedioPorMarca(String brand);
    String cargarListaDeVehiculos(List<Vehicle> vehiculos);
    String actualizarVelocidad(Long id, String velocidad);
    List<VehicleDto> listarPorDimensiones(double length, double width);
}
