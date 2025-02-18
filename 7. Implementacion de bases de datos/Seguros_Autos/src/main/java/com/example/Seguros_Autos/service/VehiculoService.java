package com.example.Seguros_Autos.service;

import com.example.Seguros_Autos.DTO.PatenteMarcaDTO;
import com.example.Seguros_Autos.DTO.VehiculoSiniestroDTO;
import com.example.Seguros_Autos.DTO.VehiculoSiniestroTotalLossDTO;
import com.example.Seguros_Autos.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehiculoService implements IVehiculoService {

    private final VehiculoRepository vehiculoRepository;

    @Autowired
    public VehiculoService(VehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    @Override
    public List<String>     findAllPatentes() {
        return vehiculoRepository.findAllPatentes();
    }

    @Override
    public List<PatenteMarcaDTO> getPatentesAndMarcasOrderedByAnioFabricacion() {
        return vehiculoRepository.findPatenteAndMarcaOrderedByAnioFabricacion()
                .stream()
                .map(v -> new PatenteMarcaDTO((String) v[0], (String) v[1])) // v[0] es patente, v[1] es marca
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getVehiculosCuatroRuedasAndCurrentYear() {
        // Obtenemos el año actual
        Integer currentYear = LocalDate.now().getYear();

        // Llamamos al repositorio para obtener las patentes de los vehículos que cumplen con la condición
        return vehiculoRepository.findPatentesByMoreThanFourRuedasAndCurrentYear(currentYear);
    }

    // Método para obtener vehículos con siniestros y pérdida mayor a 10000 pesos (Patente, Marca, Modelo)
    @Override
    public List<VehiculoSiniestroDTO> findPatenteMarcaModeloBySiniestroWithLossGreaterThan10000() {
        // Obtener la lista de vehículos y siniestros con pérdida mayor a 10,000 pesos
        List<Object[]> siniestros = vehiculoRepository.findPatenteMarcaModeloBySiniestroWithLossGreaterThan10000();

        // Usar stream para mapear la lista de resultados a DTOs
        return siniestros.stream()
                .map(siniestro -> new VehiculoSiniestroDTO(
                        (String) siniestro[0],  // Patente
                        (String) siniestro[1],  // Marca
                        (String) siniestro[2]   // Modelo
                ))
                .collect(Collectors.toList());
    }

    // Método para obtener vehículos con siniestros y pérdida mayor a 10000 pesos (Patente, Marca, Modelo y Total Loss)
    @Override
    public List<VehiculoSiniestroTotalLossDTO> findPatenteMarcaModeloAndTotalLossBySiniestroWithLossGreaterThan10000() {
        // Obtener la lista de vehículos y siniestros con pérdida mayor a 10,000 pesos y su pérdida total
        List<Object[]> siniestros = vehiculoRepository.findPatenteMarcaModeloAndTotalLossBySiniestroWithLossGreaterThan10000();

        // Usar stream para mapear la lista de resultados a DTOs
        return siniestros.stream()
                .map(siniestro -> new VehiculoSiniestroTotalLossDTO(
                        (String) siniestro[0],  // Patente
                        (String) siniestro[1],  // Marca
                        (String) siniestro[2],  // Modelo
                        (Double) siniestro[3]   // Total Loss
                ))
                .collect(Collectors.toList());
    }
}

