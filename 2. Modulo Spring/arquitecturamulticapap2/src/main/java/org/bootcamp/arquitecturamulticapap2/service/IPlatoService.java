package org.bootcamp.arquitecturamulticapap2.service;

import org.bootcamp.arquitecturamulticapap2.dto.request.PlatoDTO_In;
import org.bootcamp.arquitecturamulticapap2.dto.response.PlatoDTO_Out;

import java.util.List;

public interface IPlatoService {
    PlatoDTO_Out calcularCalorias(PlatoDTO_In plato);
    List<PlatoDTO_Out> calcularCaloriasListado(List<PlatoDTO_In> plato);
}