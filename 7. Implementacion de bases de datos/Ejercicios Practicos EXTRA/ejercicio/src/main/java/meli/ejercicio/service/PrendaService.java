package meli.ejercicio.service;

import meli.ejercicio.dto.IdPrendaDto;
import meli.ejercicio.dto.PrendaDTO;

import java.util.List;

public interface PrendaService {
    IdPrendaDto create(PrendaDTO prendaDTO);
    List<PrendaDTO> getAll();

    PrendaDTO getById(Long id);

    PrendaDTO update(Long id, PrendaDTO prendaDTO);
}
