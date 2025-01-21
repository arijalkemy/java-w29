package meli.consecionario.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import meli.consecionario.dto.request.RequestVehicleDto;
import meli.consecionario.dto.response.VehicleDto;
import meli.consecionario.entity.Vehicle;
import meli.consecionario.repository.IDealershipRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DealershipServiceImpl implements IDealershipService {

    IDealershipRepository dealershipRepository;
    private ObjectMapper mapper;

    public DealershipServiceImpl(IDealershipRepository dealershipRepository) {
        this.dealershipRepository = dealershipRepository;
        this.mapper = new ObjectMapper();
    }


    @Override
    public meli.consecionario.dto.response.AddVehicleDto addVehicle(RequestVehicleDto vehicleDto) {
        Vehicle vehicle = mapper.convertValue(vehicleDto, Vehicle.class);
        meli.consecionario.dto.response.AddVehicleDto addVehicleDto = new meli.consecionario.dto.response.AddVehicleDto("Vehiculo Guardado Exitosamente", dealershipRepository.addVehicle(vehicle).getId());
        return addVehicleDto;
    }

    @Override
    public List<VehicleDto> listVehicle(){

        return dealershipRepository
                .findall()
                .stream()
                .map(vehicle -> mapper.convertValue(vehicle, VehicleDto.class))
                .toList();
    }

    @Override
    public List<VehicleDto> filterDates(String since, String to) {
        return dealershipRepository.filterDates(since, to).stream().map(vehicle -> mapper.convertValue(vehicle,VehicleDto.class)).toList();
    }

    @Override
    public List<VehicleDto> filterPrice(Integer since, Integer to) {
        return dealershipRepository.filterPrice(since, to).stream().map(vehicle -> mapper.convertValue(vehicle, VehicleDto.class)).toList();
    }

    @Override
    public VehicleDto findById(Integer id) {
        Vehicle vehicle = dealershipRepository.findById(id);
        return mapper.convertValue(vehicle, VehicleDto.class);

    }
}
