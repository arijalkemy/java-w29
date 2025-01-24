package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;

public interface IVehicleRepository {
    List<Vehicle> findAll();
    boolean agregarVehiculo(Vehicle vehiculo);
    boolean existeId(Long id);
    List<Vehicle> obtenerVehiculosPorColorYanio(String color, int anio);
    List<Vehicle> buscarVehiculosPorYrangoDeAnios(String brand, int start_year, int end_year);
    double conocerLaVelocidadPromedioPorMarca(String brand);
    List<Vehicle> obtenerVehiculosPorMarca(String brand);
    void cargarListaDeVehiculos(List<Vehicle> vehicles);
    boolean contieneIdDuplicado(List<Vehicle> vehiculos);
    void actualizarVelocidad(Long id, String velocidad);
    List<Vehicle> listarPorDimensiones(double length, double width);
}
