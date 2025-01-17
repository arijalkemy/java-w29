package com.example.concesionaria_autos.service;

import com.example.concesionaria_autos.dto.request.VehiculoDTO;
import com.example.concesionaria_autos.dto.response.VehiculoResponseDTO;
import com.example.concesionaria_autos.dto.response.VehiculoWServicesDTO;
import com.example.concesionaria_autos.entity.Vehiculo;
import com.example.concesionaria_autos.repository.IVehiculoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VehiculoServiceImpl implements IVehiculoService{

    private ObjectMapper mapper = new ObjectMapper();
    private final IVehiculoRepository iVehiculoRepository;

    @Override
    public VehiculoResponseDTO agregarVehiculo(VehiculoDTO vehiculoDTO) {
        if(this.iVehiculoRepository.getById(vehiculoDTO.getId()).isEmpty()){
            if(this.iVehiculoRepository.addVehiculo(mapper.convertValue(vehiculoDTO, Vehiculo.class))){
                return new VehiculoResponseDTO("Se ha creado el vehiculo", vehiculoDTO.getId());
            }
        }
        return null;
    }

    @Override
    public List<VehiculoWServicesDTO> getVehicles() {
        return this.iVehiculoRepository.findVehicles().get().stream()
                .map(v -> mapper.convertValue(v, VehiculoWServicesDTO.class))
                .toList();
    }

    @Override
    public List<VehiculoWServicesDTO> searchVehiclesByYearRange(String since, String to) {
        return this.iVehiculoRepository.findVehiclesbyYearRange(Integer.parseInt(since), Integer.parseInt(to)).get()
                .stream()
                .map(v -> mapper.convertValue(v, VehiculoWServicesDTO.class))
                .toList();
    }

    @Override
    public List<VehiculoWServicesDTO> searchVehiclesBypriceRange(String since, String to) {
        return this.iVehiculoRepository.findVehiclesbyPriceRange(Integer.parseInt(since), Integer.parseInt(to)).get()
                .stream()
                .map(v -> mapper.convertValue(v, VehiculoWServicesDTO.class))
                .toList();
    }

    @Override
    public VehiculoWServicesDTO searchVehicleById(Long id) {
        Vehiculo vehiculo = this.iVehiculoRepository.findVehicleByID(id).get();
        return mapper.convertValue(vehiculo, VehiculoWServicesDTO.class);
    }
}
