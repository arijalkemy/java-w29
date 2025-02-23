package com.meli.miniseriesejercicio.service;

import com.meli.miniseriesejercicio.model.MiniSerie;
import com.meli.miniseriesejercicio.repository.IMiniserieRepository;
import org.springframework.stereotype.Service;

@Service
public class MiniSerieService {

    private final IMiniserieRepository miniserieRepository;

    public MiniSerieService(IMiniserieRepository miniserieRepository) {
        this.miniserieRepository = miniserieRepository;
    }

    public MiniSerie addMiniSerie(MiniSerie miniSerie) {
        return miniserieRepository.save(miniSerie);
    }
}
