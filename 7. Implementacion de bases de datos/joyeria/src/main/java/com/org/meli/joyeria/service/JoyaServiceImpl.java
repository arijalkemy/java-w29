package com.org.meli.joyeria.service;

import com.org.meli.joyeria.dto.JoyaDTO;
import com.org.meli.joyeria.exception.NotFoundException;
import com.org.meli.joyeria.entity.Joya;
import com.org.meli.joyeria.repository.IJoyaRepository;
import com.org.meli.joyeria.util.ModelMapperUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JoyaServiceImpl implements IJoyaService {


    private final IJoyaRepository joyaRepository;

    public JoyaServiceImpl(IJoyaRepository joyaRepository) {
        this.joyaRepository = joyaRepository;
    }

    @Override
    public JoyaDTO createJoya(JoyaDTO joyaDTO) {
        Joya joya = ModelMapperUtil.map(joyaDTO, Joya.class);
        joya.setVentaONo(true);
        Joya savedJoya = joyaRepository.save(joya);
        return ModelMapperUtil.map(savedJoya, JoyaDTO.class);
    }

    @Override
    public List<JoyaDTO> getAllJoyas() {
        return joyaRepository.findByVentaONoTrue().stream()
                .map(joya -> ModelMapperUtil.map(joya, JoyaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public JoyaDTO deleteJoya(Long id) {
        Optional<Joya> joya = joyaRepository.findById(id);
        if (joya.isPresent()) {
            Joya j = joya.get();
            j.setVentaONo(false);
            Joya updatedJoya = joyaRepository.save(j);
            return ModelMapperUtil.map(updatedJoya, JoyaDTO.class);
        } else {
            throw new NotFoundException("Joya not found with ID: " + id);
        }
    }

    @Override
    public JoyaDTO updateJoya(Long id, JoyaDTO joyaDTO) {
        Optional<Joya> existingJoya = joyaRepository.findById(id);
        if (existingJoya.isPresent()) {
            Joya j = existingJoya.get();
            j.setNombre(joyaDTO.getNombre());
            j.setMaterial(joyaDTO.getMaterial());
            j.setPeso(joyaDTO.getPeso());
            j.setParticularidad(joyaDTO.getParticularidad());
            j.setPoseePiedra(joyaDTO.getPoseePiedra());
            Joya updatedJoya = joyaRepository.save(j);
            return ModelMapperUtil.map(updatedJoya, JoyaDTO.class);
        } else {
            throw new NotFoundException("Joya not found with ID: " + id);
        }
    }
}