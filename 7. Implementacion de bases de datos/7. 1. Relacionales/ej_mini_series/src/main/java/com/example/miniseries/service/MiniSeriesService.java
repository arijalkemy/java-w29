package com.example.miniseries.service;

import com.example.miniseries.model.MiniSerie;

import java.util.List;

public interface MiniSeriesService {
    List<MiniSerie> getMiniSerie();

    void saveMiniSerie(MiniSerie miniSerie);

    void deleteMiniSerie(Long id);

    MiniSerie findMiniSerie(Long id);
}
