package ejercicio2.joyeria.ejercicio_practico_2.joyeria.service;

import com.fasterxml.jackson.databind.JsonMappingException;
import ejercicio2.joyeria.ejercicio_practico_2.joyeria.dto.CreateJoyaRequestDto;
import ejercicio2.joyeria.ejercicio_practico_2.joyeria.dto.CreateJoyaResponseDto;
import ejercicio2.joyeria.ejercicio_practico_2.joyeria.dto.ReadJoyasResponseDto;
import ejercicio2.joyeria.ejercicio_practico_2.joyeria.dto.UpdateJoyaRequestDto;
import ejercicio2.joyeria.ejercicio_practico_2.joyeria.model.Joya;

import java.util.List;

public interface IJoyaService {

    //create
    public CreateJoyaResponseDto createJoya(CreateJoyaRequestDto joya);
    //read
    public List<ReadJoyasResponseDto> readJoyas();
    //update
    public ReadJoyasResponseDto updateJoya(Long id , UpdateJoyaRequestDto joya) throws JsonMappingException;
    //delete
    public List<ReadJoyasResponseDto> deleteJoyas(Long joyaId);
}
