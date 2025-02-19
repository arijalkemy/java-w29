package com.bootcamp.hql.service;

import com.bootcamp.hql.dto.SiniestroDto;
import com.bootcamp.hql.dto.VehiculoDto;

import java.util.List;

public interface ISiniestroService {
    public SiniestroDto createSiniestro(SiniestroDto siniestroDto);
    public SiniestroDto getSiniestro(Long id);
    public List<VehiculoDto> findByLosesGraterThan(int loses);
    public Long findTotalLosesGraterThan(int loses);
}
