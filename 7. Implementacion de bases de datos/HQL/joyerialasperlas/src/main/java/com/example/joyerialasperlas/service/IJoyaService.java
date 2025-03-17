package com.example.joyerialasperlas.service;

import com.example.joyerialasperlas.dto.JoyaDto;
import com.example.joyerialasperlas.dto.in.JoyaIdDto;
import com.example.joyerialasperlas.dto.out.EditadoDto;
import com.example.joyerialasperlas.dto.out.MessageDto;

import javax.validation.Valid;
import java.util.List;

public interface IJoyaService {
    MessageDto addJewerly(JoyaDto joyaDto);

    List<JoyaDto> searchAll();

    MessageDto deleteById(Long id) throws Exception;

    EditadoDto modify(@Valid JoyaIdDto joyaIdDto) throws Exception;
}
