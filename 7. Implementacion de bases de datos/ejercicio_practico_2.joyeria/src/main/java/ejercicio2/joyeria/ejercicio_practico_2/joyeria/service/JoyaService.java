package ejercicio2.joyeria.ejercicio_practico_2.joyeria.service;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ejercicio2.joyeria.ejercicio_practico_2.joyeria.dto.CreateJoyaRequestDto;
import ejercicio2.joyeria.ejercicio_practico_2.joyeria.dto.CreateJoyaResponseDto;
import ejercicio2.joyeria.ejercicio_practico_2.joyeria.dto.ReadJoyasResponseDto;
import ejercicio2.joyeria.ejercicio_practico_2.joyeria.dto.UpdateJoyaRequestDto;
import ejercicio2.joyeria.ejercicio_practico_2.joyeria.model.Joya;
import ejercicio2.joyeria.ejercicio_practico_2.joyeria.repository.IJoyaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoyaService implements IJoyaService {
    private final IJoyaRepository repository;


    public JoyaService(IJoyaRepository reposotory) {
        this.repository = reposotory;
    }

    @Override
    public CreateJoyaResponseDto createJoya(CreateJoyaRequestDto joya) {
        ObjectMapper mapper = new ObjectMapper();
        Joya j = mapper.convertValue(joya, Joya.class);
        j.setNroIdentificatorio(null);
        Joya newJoya = repository.save(j);
        return new CreateJoyaResponseDto(j.getNroIdentificatorio());
    }

    @Override
    public List<ReadJoyasResponseDto> readJoyas() {
        ObjectMapper mapper = new ObjectMapper();
        List<Joya> joyas = repository.findAll();
        return joyas.stream()
                .filter(Joya::getVentaONo)
                .map(joya -> mapper.convertValue(joya,ReadJoyasResponseDto.class))
                .toList() ;
    }

    @Override
    public ReadJoyasResponseDto updateJoya(Long id, UpdateJoyaRequestDto joya) throws JsonMappingException {
        ObjectMapper mapper = new ObjectMapper();
        // Buscar la joya existente
        Joya existingJoya = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Joya con id " + id + " no encontrada"));

        // Mapear los datos nuevos a la entidad existente
        mapper.updateValue(existingJoya, joya);

        // Guardar la joya actualizada en la BD
        Joya updatedJoya = repository.save(existingJoya);

        // Convertir la entidad actualizada al DTO de respuesta
        return mapper.convertValue(updatedJoya, ReadJoyasResponseDto.class);
    }

    @Override
    public List<ReadJoyasResponseDto> deleteJoyas(Long joyaId) {
        Joya joya = repository.findById(joyaId)
                .orElseThrow(() -> new EntityNotFoundException("Joya con id " + joyaId + " no encontrada"));

        // Marcar la joya como "eliminada lógicamente"
        joya.setVentaONo(false);
        repository.save(joya);


        return readJoyas();
    }



}
