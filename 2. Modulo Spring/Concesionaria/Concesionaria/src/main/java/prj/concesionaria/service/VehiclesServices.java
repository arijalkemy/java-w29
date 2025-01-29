package prj.concesionaria.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import prj.concesionaria.dto.ResponseDto;
import prj.concesionaria.dto.VehiclesDto;
import prj.concesionaria.model.Vehicle;
import prj.concesionaria.repository.IVehiclesRepository;

import java.util.List;

public class VehiclesServices implements IVehiclesService{

    private IVehiclesRepository vehiclesRepository;
    private final ObjectMapper mapper = new ObjectMapper();

    public VehiclesServices(IVehiclesRepository vehiclesRepository) {
        this.vehiclesRepository = vehiclesRepository;
    }

    @Override
    public ResponseDto addVehicle(VehiclesDto vehicle) {
        vehiclesRepository.save(mapper.convertValue(vehicle,Vehicle.class));
        return new ResponseDto("Vehiculo agregado");
    }

    @Override
    public List<VehiclesDto> getVehicles() {
        return vehiclesRepository.allVehicles().stream().map(v -> mapper.convertValue(v, VehiclesDto.class)).toList();
    }

    @Override
    public List<VehiclesDto> getByYears(Integer since, Integer to) {
        return vehiclesRepository.vehiclesByYears(since,to).stream().map(v -> mapper.convertValue(v, VehiclesDto.class)).toList();
    }

    @Override
    public List<VehiclesDto> getByPrices(Integer since, Integer to) {
        return vehiclesRepository.vehiclesByPrice(since,to).stream().map(v -> mapper.convertValue(v, VehiclesDto.class)).toList();
    }

    @Override
    public VehiclesDto getById(Integer id) {
        Vehicle vehicle = vehiclesRepository.findById(id);
        return mapper.convertValue(vehicle,VehiclesDto.class);
    }
}
