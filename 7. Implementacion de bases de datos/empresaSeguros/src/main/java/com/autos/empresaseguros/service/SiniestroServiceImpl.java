package com.autos.empresaseguros.service;

import com.autos.empresaseguros.dto.PerdidaEconomicaInfoProjection;
import com.autos.empresaseguros.repository.ISiniestroRepository;
import com.autos.empresaseguros.dto.PerdidaEconomicaProjection;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiniestroServiceImpl implements ISiniestroService {

    private final ISiniestroRepository siniestroRepository;

    final ModelMapper mp = new ModelMapper();

    public SiniestroServiceImpl(ISiniestroRepository siniestroRepository) {
        this.siniestroRepository = siniestroRepository;
    }

    @Override
    public List<PerdidaEconomicaProjection> getSiniestrosMayores() {
        return siniestroRepository.findVehiculosConPerdidaEconomicaAlta();
    }

    @Override
    public List<PerdidaEconomicaInfoProjection> getInfoSiniestrosMayores() {
        return siniestroRepository.findInfoVehiculosConPerdidaEconomicaAlta();
    }
}
