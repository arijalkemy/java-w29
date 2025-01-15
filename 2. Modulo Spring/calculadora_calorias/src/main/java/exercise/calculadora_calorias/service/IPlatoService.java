package exercise.calculadora_calorias.service;

import exercise.calculadora_calorias.dto.PlatoResponseDto;
import exercise.calculadora_calorias.entity.Plato;

import java.util.List;

public interface IPlatoService {
    public PlatoResponseDto getplato(String nombre);

    public List<PlatoResponseDto> getAllplatos(List<String> platos);
}
