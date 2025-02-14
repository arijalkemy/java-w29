package exercise.joyeria_perlas.service;

import exercise.joyeria_perlas.dto.request.JoyaRequestDto;
import exercise.joyeria_perlas.entity.Joya;

import java.util.List;

public interface IJoyaService {
    List<Joya> getAll();
    String save(JoyaRequestDto joyaDto);
    String remove(Long id);
    Joya getById(Long id);
    Joya update(JoyaRequestDto joyaDto, Long id);
}
