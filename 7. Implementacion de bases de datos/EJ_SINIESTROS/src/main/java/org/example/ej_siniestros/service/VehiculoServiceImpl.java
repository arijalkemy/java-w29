package org.example.ej_siniestros.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.ej_siniestros.dto.PatenteDto;
import org.example.ej_siniestros.dto.PatenteMarcaDto;
import org.example.ej_siniestros.dto.PatenteMarcaModeloDto;
import org.example.ej_siniestros.dto.VehiculoDto;
import org.example.ej_siniestros.model.Vehiculo;
import org.example.ej_siniestros.projection.PatenteProjection;
import org.example.ej_siniestros.repository.IVehiculoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehiculoServiceImpl implements IVehiculoService {

    private final IVehiculoRepository repository;
    private final ModelMapper mapper = new ModelMapper();

    @Override
    public List<String> getallPatentes() {

        List<PatenteProjection> patente = repository.findAllPatents();
        System.out.println(patente);
        return patente.stream().map(PatenteProjection::getPatente).toList();
    }

    @Override
    public List<PatenteMarcaDto> getAllPatentesAndBrandByAnio() {

        List<String> vehiculo = repository.getAllPatentesAndBrandByAnio();
        return vehiculo.stream()
                .map(s -> {
                    String[] partes = s.split(",");
                    return new PatenteMarcaDto(
                            partes.length > 0 ? partes[0] : "",
                            partes.length > 1 ? partes[1] : ""
                    );
                })
                .toList();
    }

    @Override
    public List<VehiculoDto> findVehiclesWithAccidentEconomicLossGreaterThan10000() {
        ObjectMapper mapper = new ObjectMapper();

        List<Vehiculo> vehiculo = repository.findVehiclesWithAccidentEconomicLossGreaterThan10000();
        return vehiculo.stream().map(vehiculo1 -> mapper.convertValue(vehiculo1, VehiculoDto.class)).toList();
    }
}
