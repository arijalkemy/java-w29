package com.example.ejercicioextra1.service.venta;

import com.example.ejercicioextra1.dto.reponse.GetPrendasForVentaResponseDto;
import com.example.ejercicioextra1.dto.reponse.PostVentaResponseDto;
import com.example.ejercicioextra1.dto.request.PostVentaRequestDto;

import java.time.LocalDate;
import java.util.List;

public interface IVentaService {

    PostVentaResponseDto save(PostVentaRequestDto postVentaRequestDto);
    List<PostVentaResponseDto> findAll(String fecha);
    PostVentaResponseDto findById(Long id);
    void modifyById(Long id, PostVentaRequestDto postVentaRequestDto);
    void deleteById(Long id);
    GetPrendasForVentaResponseDto getPrendasForVenta(Long id);
}
