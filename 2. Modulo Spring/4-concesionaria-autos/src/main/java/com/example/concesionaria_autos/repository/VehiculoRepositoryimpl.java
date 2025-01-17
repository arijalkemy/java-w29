package com.example.concesionaria_autos.repository;

import com.example.concesionaria_autos.dto.request.VehiculoDTO;
import com.example.concesionaria_autos.entity.Service;
import com.example.concesionaria_autos.entity.Vehiculo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class VehiculoRepositoryimpl implements IVehiculoRepository{
    private final static String JSON_PATH = "src/main/resources/concesionaria.json";
    private List<Vehiculo> vehiculos;
    ObjectMapper mapper;

    public VehiculoRepositoryimpl(){
        mapper = new ObjectMapper();
        this.vehiculos = new ArrayList<>(List.of(
                new Vehiculo(1L, "Chevrolet", "Onix", 1990,323, 4, 100, "AR", List.of(new Service(200, "cambio de motor")), 2),
                new Vehiculo(2L, "Toyota", "Corolla", 2010, 500, 4, 200, "BR", List.of(new Service(300, "alineación")), 3),
                new Vehiculo(3L, "Ford", "Fiesta", 2024,250, 4, 150, "UY", List.of(new Service(150, "cambio de aceite")), 4),
                new Vehiculo(4L, "Renault", "Duster",1991, 600, 5, 180, "AR", List.of(new Service(400, "revisión general")), 5),
                new Vehiculo(5L, "Volkswagen", "Golf", 1946, 400, 4, 170, "CL", List.of(new Service(220, "reparación de frenos")), 2),
                new Vehiculo(6L, "Honda", "Civic", 1983, 350, 4, 190, "PE", List.of(new Service(250, "cambio de batería")), 4),
                new Vehiculo(7L, "Nissan", "Sentra",1988, 300, 4, 160, "CO", List.of(new Service(180, "rotación de neumáticos")), 3),
                new Vehiculo(8L, "Mazda", "CX-5", 1997,450, 5, 210, "MX", List.of(new Service(320, "ajuste de suspensión")), 5),
                new Vehiculo(9L, "Kia", "Seltos", 1999,370, 5, 200, "AR", List.of(new Service(270, "reemplazo de filtro de aire")), 3),
                new Vehiculo(10L, "Hyundai", "Tucson", 1987,480, 5, 220, "CL", List.of(new Service(290, "cambio de correa de distribución")), 4)
        ));
    }



    public Optional<Vehiculo> getById(Long id){
        return this.vehiculos.stream().filter(v -> v.getId() == id).findFirst();
    }

    public Boolean addVehiculo(Vehiculo v){
        return this.vehiculos.add(v);
    }

    @Override
    public Optional<List<Vehiculo>> findVehicles() {
        return Optional.ofNullable(this.vehiculos);
    }

    @Override
    public Optional<List<Vehiculo>> findVehiclesbyYearRange(Integer since, Integer to) {
        return Optional.of(this.vehiculos.stream()
                .filter(v -> v.getYear() >= since && v.getYear() <= to)
                .toList());
    }

    @Override
    public Optional<List<Vehiculo>> findVehiclesbyPriceRange(Integer since, Integer to) {
        return Optional.of(this.vehiculos.stream()
                .filter(v -> v.getPrice() >= since && v.getPrice() <= to)
                .toList());
    }

    @Override
    public Optional<Vehiculo> findVehicleByID(Long id) {
        return this.vehiculos.stream()
                .filter(vehiculo -> vehiculo.getId().equals(id)).findFirst();
    }

}
