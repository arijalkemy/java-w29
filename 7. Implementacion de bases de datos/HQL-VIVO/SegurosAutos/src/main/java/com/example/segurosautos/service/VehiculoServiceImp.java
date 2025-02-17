package com.example.segurosautos.service;

import com.example.segurosautos.dto.response.MatriculaMarcaModeloVehiculoResponseDto;
import com.example.segurosautos.dto.response.PatenteMarcaVehiculoResponseDto;
import com.example.segurosautos.entity.Vehiculo;
import com.example.segurosautos.repository.IVehiculoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class VehiculoServiceImp implements IVehiculoService {
    private final IVehiculoRepository vehiculoRepository;


    @Override
    public List<String> searchAllPatentes(String cantidadRuedasMax, String anioFabricacion) {
        if (cantidadRuedasMax.isEmpty() && anioFabricacion.isEmpty()) {
            return vehiculoRepository.findAllPatentes();
        } else {
            Integer cantidadRuedasMaxInteger = Integer.parseInt(cantidadRuedasMax);
            Integer anioFabricacionInteger = Integer.parseInt(anioFabricacion);
            return vehiculoRepository.findPatenteByAnioFabricacionAndCantidadRuedas(anioFabricacionInteger, cantidadRuedasMaxInteger);
        }
    }

    @Override
    public List<PatenteMarcaVehiculoResponseDto> searchAllPatentesAndMarca(String order, String by) {

        List<Vehiculo> vehiculos = vehiculoRepository.findAllVehicles(order, by);

        return vehiculos.stream().map(v -> PatenteMarcaVehiculoResponseDto
                .builder()
                .patente(v.getPatente())
                .marca(v.getMarca())
                .build()).toList();

    }

    @Override
    public List<MatriculaMarcaModeloVehiculoResponseDto> searchVehicleByPerdidaEconomica(Double perdidaEconomica) {
        List<Vehiculo> vehiculos = vehiculoRepository.findVehiculosByPerdidaEconomica(perdidaEconomica);

        return vehiculos.stream().map(v -> MatriculaMarcaModeloVehiculoResponseDto
                .builder()
                .matricula(v.getIdVehiculo())
                .marca(v.getMarca())
                .modelo(v.getModelo())
                .build()).toList();
    }
}
