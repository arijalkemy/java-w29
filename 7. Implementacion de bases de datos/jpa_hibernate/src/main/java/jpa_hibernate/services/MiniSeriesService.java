package jpa_hibernate.services;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import jpa_hibernate.entities.MiniSeries;
import jpa_hibernate.repositories.IMiniSerieRepository;

@Service
@RequiredArgsConstructor
public class MiniSeriesService implements IMiniSeriesService {

  private final IMiniSerieRepository mini_series_repository;

  @Override
  public MiniSeries createMiniSeries(MiniSeries mini_series) {
    return mini_series_repository.save(mini_series);
    
  }
}
