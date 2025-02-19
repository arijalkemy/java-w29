package com.example.obras_literarias.service;

import com.example.obras_literarias.dto.ObraLiterariaRequestDto;
import com.example.obras_literarias.dto.ObraLiterariaResponseDto;
import com.example.obras_literarias.entity.ObraLiteraria;
import com.example.obras_literarias.repository.ObraLiterariaRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ObrasLiterariasService implements IObrasLiterariasService {

    private final ObraLiterariaRepository repository;

    @Override
    public ObraLiterariaResponseDto createObraLiteraria(ObraLiterariaRequestDto request){
        ModelMapper mapper = new ModelMapper();
        ObraLiteraria obraLiteraria = mapper.map(request, ObraLiteraria.class);

       ObraLiteraria response = repository.save(obraLiteraria);
       return mapper.map(response, ObraLiterariaResponseDto.class);
    }

    @Override
    public List<ObraLiterariaResponseDto> searchAll() {
        Iterable<ObraLiteraria> obras = repository.findAll();
        return getObraLiterariaResponseDtos(obras);
    }

    private List<ObraLiterariaResponseDto> getObraLiterariaResponseDtos(Iterable<ObraLiteraria> obras) {
        ModelMapper mapper = new ModelMapper();
        List<ObraLiterariaResponseDto> response = new ArrayList<>();

        obras.forEach(obraLiteraria ->
            response.add(mapper.map(obraLiteraria, ObraLiterariaResponseDto.class))
        );
        return response;
    }

    @Override
    public List<ObraLiterariaResponseDto> searchByAutor(String autor) {
        var obras = repository.findByAutor(autor);
        return getObraLiterariaResponseDtos(obras);
    }

    private List<ObraLiterariaResponseDto> getObraLiterariaResponseDtos(List<ObraLiteraria> obras) {
        ModelMapper mapper = new ModelMapper();
        List<ObraLiterariaResponseDto> response = new ArrayList<>();

        obras.forEach(obraLiteraria ->
                response.add(mapper.map(obraLiteraria, ObraLiterariaResponseDto.class))
        );
        return response;
    }

    @Override
    public List<ObraLiterariaResponseDto> searchByPalabarasClaveTitulo(String titulo) {
        var obras = repository.findByNombreContainingIgnoreCase(titulo);
        return getObraLiterariaResponseDtos(obras);
    }

    @Override
    public List<ObraLiterariaResponseDto> searchByCantidadDePaginas(Integer cantidadDePaginas) {
        var obras = repository.findByCantidadDePaginasGreaterThan(cantidadDePaginas);
        return getObraLiterariaResponseDtos(obras);
    }

    @Override
    public List<ObraLiterariaResponseDto> searchBeforeYear(Integer year) {
        var obras = repository.findByYearBefore(year);
        return getObraLiterariaResponseDtos(obras);
    }

    @Override
    public List<ObraLiterariaResponseDto> searchByEditorial(String editorial) {
        var obras = repository.findByEditorial(editorial);
        return getObraLiterariaResponseDtos(obras);
    }
}
