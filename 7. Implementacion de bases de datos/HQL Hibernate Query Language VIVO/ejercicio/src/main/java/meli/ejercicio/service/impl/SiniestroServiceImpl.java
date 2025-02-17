package meli.ejercicio.service.impl;

import lombok.RequiredArgsConstructor;
import meli.ejercicio.model.Siniestro;
import meli.ejercicio.repository.SiniestroJpaRepository;
import meli.ejercicio.service.SiniestroService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SiniestroServiceImpl implements SiniestroService {

    private final SiniestroJpaRepository siniestroJpaRepository;

    @Override
    public List<Siniestro> findAll() {
        return siniestroJpaRepository.findAll();
    }
}
