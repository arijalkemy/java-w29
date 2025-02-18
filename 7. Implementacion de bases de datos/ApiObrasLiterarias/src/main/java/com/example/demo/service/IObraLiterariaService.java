package com.example.demo.service;

import com.example.demo.dto.response.ApiResponseDto;
import com.example.demo.dto.ObraLiterariaDto;

import java.util.Date;
import java.util.List;


public interface IObraLiterariaService {
    ApiResponseDto saveObra(ObraLiterariaDto obra);
    List<ObraLiterariaDto> searchObrasByAutor(String autor);
    List<ObraLiterariaDto> searchObrasByKeyWord(String keyword);
    List<ObraLiterariaDto> searchTopObrasAndOrderDesc();
    List<ObraLiterariaDto> searchByDate(Date fecha);
    List<ObraLiterariaDto> searchByEditorial(String editorial);
}
