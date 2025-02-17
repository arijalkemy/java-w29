package com.meli.joyeria.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.joyeria.dto.JoyaDto;
import com.meli.joyeria.entity.Joya;
import com.meli.joyeria.repository.JoyaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JoyaService implements IJoyaService{

    private final JoyaRepository joyaRepository;
    private final ObjectMapper mapper;

    public JoyaService(JoyaRepository joyaRepository) {
        this.joyaRepository = joyaRepository;
        mapper = new ObjectMapper();
    }

    @Override
    public JoyaDto saveJoya(JoyaDto joyaDto) {
        Joya joya = mapper.convertValue(joyaDto, Joya.class);
        joyaRepository.save(joya);
        return joyaDto;
    }

    @Override
    public JoyaDto findBYId(Long idJoya) {
        Joya joya = joyaRepository.findById(idJoya).orElse(null);
        if(joya != null){
            return  mapper.convertValue(joya, JoyaDto.class);
        }
        return null;
    }

    @Override
    public List<JoyaDto> getAll() {
        List<Joya> joyas = joyaRepository.findAll();
        return joyas.stream()
                .map(joya -> mapper.convertValue(joya, JoyaDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public JoyaDto updateJoya(JoyaDto joyaDto) {
        Joya joya = mapper.convertValue(joyaDto, Joya.class);
        joyaRepository.save(joya);
        return joyaDto;
    }

    @Override
    public void deleteJoya(Long idJoya) {
        joyaRepository.deleteById(idJoya);
    }
}
