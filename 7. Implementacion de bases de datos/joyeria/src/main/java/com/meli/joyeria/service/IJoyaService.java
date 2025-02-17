package com.meli.joyeria.service;

import com.meli.joyeria.dto.JoyaDto;

import java.util.List;

public interface IJoyaService {
    JoyaDto saveJoya(JoyaDto joyaDto);
    JoyaDto findBYId(Long idJoya);
    List<JoyaDto> getAll();
    JoyaDto updateJoya(JoyaDto joyaDto);
    void deleteJoya(Long idJoya);
}
