package exercise.es_obras_literarias.service;

import exercise.es_obras_literarias.domain.Obra;
import exercise.es_obras_literarias.dto.request.ObraRequestDto;
import exercise.es_obras_literarias.dto.response.ObraResponseDto;

import java.util.List;

public interface IObraService {
    ObraResponseDto save(ObraRequestDto obraRequestDto);
    List<ObraResponseDto> findByAuthor(String author);
    List<ObraResponseDto> findTop5CantidadPaginas();
    List<ObraResponseDto> findByAnioPublicacionBefore(Integer year);
    List<ObraResponseDto> findByEditorial(String editorial);
    List<ObraResponseDto> findByName(String name);
}
