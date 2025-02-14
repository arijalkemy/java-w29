package meli.ejercicio.service;

import meli.ejercicio.dto.JoyaDto;

import java.util.List;

public interface JoyaService {

    Long create(JoyaDto joyaDto);

    JoyaDto read(Long id);

    JoyaDto update(JoyaDto joyaDto);

    void delete(Long id);

    List<JoyaDto> readAll();
}
