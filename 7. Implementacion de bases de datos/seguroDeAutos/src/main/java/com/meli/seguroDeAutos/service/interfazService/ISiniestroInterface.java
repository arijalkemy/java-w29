package com.meli.seguroDeAutos.service.interfazService;

import com.meli.seguroDeAutos.dto.SiniestroDto;

import java.util.List;

public interface ISiniestroInterface {
    SiniestroDto save(SiniestroDto siniestro);
    SiniestroDto searchById(Integer idSiniestro);
    List<SiniestroDto> searchAll();
}
