package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.exception.VehicleAlreadyExistsException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService{

    IVehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepositoryImpl vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }
    @Override
    public List<VehicleDto> searchAllVehicles() {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
        return vehicleList.stream()
                .map(v -> mapper.convertValue(v,VehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public String agregarVehiculo(Vehicle vehiculo){
        boolean seAgrego = vehicleRepository.agregarVehiculo(vehiculo);
        if(seAgrego){
            return "Vehiculo agregado correctamente";
        }else{
            throw new VehicleAlreadyExistsException("El vehiculo ya existe.");
        }
    }

    @Override
    public List<VehicleDto> obtenerVehiculosPorColorYanio(String color, int anio){
        List<Vehicle> listaVehiculos = vehicleRepository.obtenerVehiculosPorColorYanio(color,anio);
        ObjectMapper mapper = new ObjectMapper();

        if(listaVehiculos.isEmpty()){
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }else{
            return listaVehiculos
                    .stream()
                    .map(v -> mapper.convertValue(v,VehicleDto.class))
                    .toList();
        }
    }

    @Override
    public List<VehicleDto> buscarVehiculosPorYrangoDeAnios(String brand, int start_year, int end_year){
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> listaVehiculos = vehicleRepository.buscarVehiculosPorYrangoDeAnios(brand,start_year,end_year);
        return listaVehiculos
                .stream()
                .map(v -> mapper.convertValue(v,VehicleDto.class))
                .toList();
    }

    @Override
    public double conocerLaVelocidadPromedioPorMarca(String brand){

        if(vehicleRepository.obtenerVehiculosPorMarca(brand).isEmpty()){
            throw new NotFoundException("No se encontaron autos de esa marca");
        }else {
            return vehicleRepository.conocerLaVelocidadPromedioPorMarca(brand);
        }
    }

    @Override
    public String cargarListaDeVehiculos(List<Vehicle> vehiculos){
        if(vehicleRepository.contieneIdDuplicado(vehiculos)){
            throw new VehicleAlreadyExistsException("Hay vehiculos ya existentes");
        }else {
            vehicleRepository.cargarListaDeVehiculos(vehiculos);
            return "Vehiculos agregados exitosamente";
        }

    }

    @Override
    public String actualizarVelocidad(Long id, String velocidad){
        if(vehicleRepository.existeId(id)){
            vehicleRepository.actualizarVelocidad(id,velocidad);
            return "Velocidad actualizada correctamente a " + velocidad;
        }else {
            throw new NotFoundException("No se encontro el vehiculo");
        }
    }

    @Override
    public List<VehicleDto> listarPorDimensiones(double length, double width){
            ObjectMapper om = new ObjectMapper();
            List<Vehicle> listaVehiculos = vehicleRepository.listarPorDimensiones(length,width);
            if(listaVehiculos.isEmpty()){
                throw new NotFoundException("No se encontraron vehiculos con esas dimensiones");
            }else {
                return listaVehiculos.stream().map(v-> om.convertValue(v,VehicleDto.class)).toList();
            }
    }
}
