package com.example.demo.service;

import com.example.demo.dto.ObraLiterariaDto;
import com.example.demo.dto.response.ApiResponseDto;
import com.example.demo.model.ObraLiteraria;
import com.example.demo.repository.IObraLiterariaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class ObraLiterariaService implements IObraLiterariaService{
    private ObjectMapper objectMapper;
    private IObraLiterariaRepository obraLiterariaRepository;

    public ObraLiterariaService(IObraLiterariaRepository obraLiterariaRepository) {
       this.obraLiterariaRepository = obraLiterariaRepository;
       objectMapper = new ObjectMapper();
    }

    @Override
    public ApiResponseDto saveObra(ObraLiterariaDto obraDto) {
        ObraLiteraria obra = objectMapper.convertValue(obraDto, ObraLiteraria.class);
        obraLiterariaRepository.save(obra);

        return new ApiResponseDto("Libro cargado exitosamente");
    }

    @Override
    public List<ObraLiterariaDto> searchObrasByAutor(String autor) {
        Iterable<ObraLiteraria> iter = obraLiterariaRepository.findByAutor(autor);
        List<ObraLiteraria> obras = new ArrayList<>();
        iter.forEach(obras::add);
        return obras.stream().map(o->objectMapper.convertValue(o,ObraLiterariaDto.class)).toList();
    }

    @Override
    public List<ObraLiterariaDto> searchObrasByKeyWord(String keyword){
        List<ObraLiteraria> obra = obraLiterariaRepository.findByNombreContaining(keyword);
        return obra.stream().map(o -> objectMapper.convertValue(o,ObraLiterariaDto.class)).toList();
    }

   // Retornar el top 5 de las obras literarias con más cantidad de páginas. Ordenar el resultado de mayor a menor.
    @Override
   public List<ObraLiterariaDto> searchTopObrasAndOrderDesc(){
       List<ObraLiteraria> obra = obraLiterariaRepository.findTop5ByOrderByCantPaginasDesc();
       return obra.stream().map(o -> objectMapper.convertValue(o,ObraLiterariaDto.class)).toList();
   }

    // Retornar las obras que fueron publicadas antes de un determinado año. Por ejemplo: Antes de 1998.
    @Override
    public List<ObraLiterariaDto> searchByDate(Date fecha){
        List<ObraLiteraria> obra = obraLiterariaRepository.findByAnioPublicacionBefore(fecha);
        return obra.stream().map(o -> objectMapper.convertValue(o,ObraLiterariaDto.class)).toList();
    }
    //Retornar todas las obras de una determinada editorial. Por ejemplo: Todas las obras de la editorial “Santillana”

    @Override
    public List<ObraLiterariaDto> searchByEditorial(String editorial){
        List<ObraLiteraria> obra = obraLiterariaRepository.findByEditorial(editorial);
        return obra.stream().map(o -> objectMapper.convertValue(o,ObraLiterariaDto.class)).toList();
    }

}
