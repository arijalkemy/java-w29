package com.mercadolibre.bootcamp.joyerialasperlas.service;

import com.mercadolibre.bootcamp.joyerialasperlas.dto.JoyaDto;
import com.mercadolibre.bootcamp.joyerialasperlas.dto.res.JoyaResponseDto;
import com.mercadolibre.bootcamp.joyerialasperlas.model.Joya;
import com.mercadolibre.bootcamp.joyerialasperlas.repository.JoyaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JoyaServiceImpl implements IJoyaService {

    private final JoyaRepository joyaRepository;

    public JoyaServiceImpl(JoyaRepository joyaRepository) {
        this.joyaRepository = joyaRepository;
    }

    @Override
    @Transactional
    public List<JoyaDto> getJoyas() {
        return joyaRepository
                .findAll()
                .stream()
                .filter(Joya::getVenta)
                .map(JoyaDto::from)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public JoyaResponseDto saveJoya(JoyaDto j) {
        return JoyaResponseDto.from(joyaRepository.save(JoyaDto.to(j)));
    }

    @Override
    @Transactional
    public void deleteJoya(Integer id) {
        Optional<Joya> joyaOptional = joyaRepository.findById(id);
        joyaOptional.ifPresent(joya -> joya.setVenta(false));
    }

    @Override
    @Transactional
    public JoyaDto update(Integer id, JoyaDto req) {
        Optional<Joya> joyaOptional = joyaRepository.findById(id);

        if (joyaOptional.isEmpty())
            throw new IllegalArgumentException("Id not found");

        Joya joya = joyaOptional.get();
        joya.setNombre(req.getNombre());
        joya.setMaterial(req.getMaterial());
        joya.setPeso(req.getPeso());
        joya.setParticularidad(req.getParticularidad());
        joya.setPoseePiedra(req.getPoseePiedra());

        joyaRepository.save(joya);

        return JoyaDto.from(joya);
    }

}
