package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleRepositoryImpl implements IVehicleRepository{

    private List<Vehicle> listOfVehicles = new ArrayList<>();

    public VehicleRepositoryImpl() throws IOException {
        loadDataBase();
    }

    @Override
    public List<Vehicle> findAll() {
        return listOfVehicles;
    }

    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<Vehicle> vehicles ;

        file= ResourceUtils.getFile("classpath:vehicles_100.json");
        vehicles= objectMapper.readValue(file,new TypeReference<List<Vehicle>>(){});

        listOfVehicles = vehicles;
    }

    @Override
    public boolean agregarVehiculo(Vehicle vehiculo){
        if(existeId(vehiculo.getId())){
            return false;
        }else {
            listOfVehicles.add(vehiculo);
            return true;
        }
    }

    @Override
    public boolean existeId(Long id){
        return listOfVehicles.stream().anyMatch(v -> v.getId().equals(id));
    }

    @Override
    public List<Vehicle> obtenerVehiculosPorColorYanio(String color, int anio){
        return listOfVehicles
                .stream()
                .filter(vehicle -> vehicle.getColor().equalsIgnoreCase(color) && vehicle.getYear() == anio)
                .toList();
    }

    @Override
    public List<Vehicle> buscarVehiculosPorYrangoDeAnios(String brand, int start_year, int end_year){
        return listOfVehicles
                .stream()
                .filter(v -> v.getYear() <= end_year && v.getYear()>=start_year && v.getBrand().equals(brand))
                .toList();
    }

    @Override
    public double conocerLaVelocidadPromedioPorMarca(String brand){
        List<Vehicle> vehiculos = obtenerVehiculosPorMarca(brand);

        return vehiculos.stream()
                .mapToDouble(v -> Double.parseDouble(v.getMax_speed()))
                .average()
                .orElse(0);
    }

    @Override
    public List<Vehicle> obtenerVehiculosPorMarca(String brand){
        return listOfVehicles.stream().filter(v -> v.getBrand().equals(brand)).toList();
    }

    @Override
    public void cargarListaDeVehiculos(List<Vehicle> vehiculos){
        listOfVehicles.addAll(vehiculos);
    }

    @Override
    public boolean contieneIdDuplicado(List<Vehicle> vehiculos){
        return listOfVehicles.stream()
                .anyMatch(v -> vehiculos.stream()
                        .anyMatch(veh -> veh.getId()
                                .equals(v.getId())));
    }

    @Override
    public void actualizarVelocidad(Long id, String velocidad){
     listOfVehicles.stream()
               .filter(v-> v.getId() == id.intValue())
                .findFirst()
                .get()
                .setMax_speed(velocidad);
    }

    public double obtenerCapacidadPromedio(String brand){
        List<Vehicle> lista = listOfVehicles.stream().filter(v -> v.getBrand().equals(brand)).toList();
        return lista.stream().mapToInt(Vehicle::getPassengers).average().orElse(0);
    }

    @Override
    public List<Vehicle> listarPorDimensiones(double length, double width){
        return listOfVehicles.stream()
                .filter(v-> v.getHeight() == length && v.getWidth() == width).toList();
    }

    public void actualizarTipoCombustible(int id){

    }

    public void eliminarVehiculo(int id){
        //Forma 1
        listOfVehicles.remove(id);
      //Forma 2
       listOfVehicles = listOfVehicles.stream().filter(v-> v.getId().intValue() != id).toList();

       //Forma 3
       listOfVehicles.removeIf(v->v.getId().intValue() == id);
    }

}

