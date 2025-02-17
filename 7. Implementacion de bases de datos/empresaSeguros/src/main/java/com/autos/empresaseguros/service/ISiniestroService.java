package com.autos.empresaseguros.service;

import com.autos.empresaseguros.dto.PerdidaEconomicaInfoProjection;
import com.autos.empresaseguros.dto.PerdidaEconomicaProjection;

import java.util.List;

public interface ISiniestroService {
    List<PerdidaEconomicaProjection> getSiniestrosMayores();

    List<PerdidaEconomicaInfoProjection> getInfoSiniestrosMayores();
}
