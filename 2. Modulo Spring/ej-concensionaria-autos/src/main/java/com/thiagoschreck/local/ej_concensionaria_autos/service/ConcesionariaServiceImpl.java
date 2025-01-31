package com.thiagoschreck.local.ej_concensionaria_autos.service;

import com.thiagoschreck.local.ej_concensionaria_autos.dto.request.NewVehicleRequestDTO;
import com.thiagoschreck.local.ej_concensionaria_autos.dto.response.NewVehicleResponseDTO;
import com.thiagoschreck.local.ej_concensionaria_autos.dto.response.VehicleResponseDTO;
import com.thiagoschreck.local.ej_concensionaria_autos.entity.Vehicle;
import com.thiagoschreck.local.ej_concensionaria_autos.repository.IVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@Service
public class ConcesionariaServiceImpl implements IConcesionariaService {
    private final IVehicleRepository repository;

    @Autowired
    public ConcesionariaServiceImpl(IVehicleRepository repository) {
        this.repository = repository;
    }


    @Override
    public NewVehicleResponseDTO addVehicle(NewVehicleRequestDTO newVehicle) {
        return mapToResponse(repository.save(map(newVehicle)));
    }

    @Override
    public List<VehicleResponseDTO> getVehicles() {
        return mapVehicleResponse(repository.find());
    }

    @Override
    public List<VehicleResponseDTO> getVehiclesByManufacturingDate(String since, String to) {
        return mapVehicleResponse(repository.find(since, to)).stream()
                .sorted(Comparator.comparing(v -> LocalDate.parse(v.manufacturingDate())))
                .toList();
    }

    @Override
    public List<VehicleResponseDTO> getVehiclesByPrice(String since, String to) {
        return mapVehicleResponse(repository.find(since, to)).stream()
                .sorted(Comparator.comparing(VehicleResponseDTO::price))
                .toList();
    }

    @Override
    public VehicleResponseDTO getVehicleById(Integer id) {
        return null;
    }

    private List<VehicleResponseDTO> mapVehicleResponse(List<Vehicle> vehicles) {
        return vehicles.stream().map(this::mapVehicleResponse).toList();
    }

    private VehicleResponseDTO mapVehicleResponse(Vehicle vehicle) {
        return new VehicleResponseDTO(vehicle.getBrand(), vehicle.getModel(), vehicle.getManufacturingDate(),
                vehicle.getNumberOfKilometers(), vehicle.getDoors(), vehicle.getPrice(), vehicle.getCurrency(),
                vehicle.getCountOfOwners());
    }

    private Vehicle map(NewVehicleRequestDTO vehicle) {
        return new Vehicle(vehicle.brand(), vehicle.model(), vehicle.manufacturingDate(), vehicle.numberOfKilometers(),
                vehicle.doors(), vehicle.price(), vehicle.currency(), map(vehicle.services()), vehicle.countOfOwners());
    }

    private List<Vehicle.Service> map(List<NewVehicleRequestDTO.NewVehicleServiceRequestDTO> services) {
        return services.stream().map(this::map).toList();
    }

    private Vehicle.Service map(NewVehicleRequestDTO.NewVehicleServiceRequestDTO service) {
        return new Vehicle.Service(service.date(), service.kilometers(), service.descriptions());
    }

    private NewVehicleResponseDTO mapToResponse(Vehicle vehicle) {
        return new NewVehicleResponseDTO(vehicle.getId(), vehicle.getBrand(), vehicle.getModel(),
                vehicle.getManufacturingDate(), vehicle.getNumberOfKilometers(), vehicle.getDoors(), vehicle.getPrice(), vehicle.getCurrency(), mapToResponse(vehicle.getServices()), vehicle.getCountOfOwners());
    }

    private NewVehicleResponseDTO.NewVehicleServicesResponseDTO mapToResponse(Vehicle.Service service) {
        return new NewVehicleResponseDTO.NewVehicleServicesResponseDTO(service.date(), service.kilometers(), service.descriptions());
    }

    private List<NewVehicleResponseDTO.NewVehicleServicesResponseDTO> mapToResponse(List<Vehicle.Service> services) {
        return services.stream().map(this::mapToResponse).toList();
    }
}
