package com.example.miniseries.service;

import com.example.miniseries.model.MiniSerie;
import com.example.miniseries.repository.MiniSeriesRepository;
import com.example.miniseries.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MiniSeriesServiceImpl implements MiniSeriesService {

    private final MiniSeriesRepository repository;

    @Override
    public List<MiniSerie> getMiniSerie() {
        return repository.findAll();
    }

    @Override
    public void saveMiniSerie(MiniSerie miniSerie) {
        repository.save(miniSerie);
    }

    @Override
    public void deleteMiniSerie(Long id) {
        repository.deleteById(id);
    }

    @Override
    public MiniSerie findMiniSerie(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("MiniSerie not found"));
    }
}
