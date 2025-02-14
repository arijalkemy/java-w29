package meli.ejercicio.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import meli.ejercicio.dto.JoyaDto;
import meli.ejercicio.model.Joya;
import meli.ejercicio.repository.JoyaJpaRepository;
import meli.ejercicio.service.JoyaService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JoyaServiceImpl implements JoyaService {

    private final JoyaJpaRepository joyaJpaRepository;
    private final ObjectMapper objectMapper;

    @Override
    public Long create(JoyaDto joyaDto) {
        Joya joya = objectMapper.convertValue(joyaDto, Joya.class);
        joya.setVentaONo(true);
        joyaJpaRepository.save(joya);
        return joya.getNro_identificatorio();
    }

    @Override
    public JoyaDto read(Long id) {
        Joya joya = joyaJpaRepository.findById(id).orElse(null);
        return objectMapper.convertValue(joya, JoyaDto.class);
    }

    @Override
    public JoyaDto update(JoyaDto joyaDto) {
        Joya joya = objectMapper.convertValue(joyaDto, Joya.class);
        joyaJpaRepository.save(joya);
        return objectMapper.convertValue(joya, JoyaDto.class);
    }

    @Override
    public void delete(Long id) {
        Joya joya = joyaJpaRepository.findById(id).orElse(null);
        assert joya != null;
        joya.setVentaONo(false);
    }

    @Override
    public List<JoyaDto> readAll() {
        List<Joya> joyas = joyaJpaRepository.findAll();
        List<JoyaDto> joyasDto = new ArrayList<>();
        for (Joya joya : joyas) {
            if(joya.getVentaONo()){
                joyasDto.add(objectMapper.convertValue(joya, JoyaDto.class));
            }
        }
        return joyasDto;
    }
}
