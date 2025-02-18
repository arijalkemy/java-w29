package com.example.ejercicioextra1.service.prenda;

import com.example.ejercicioextra1.dto.reponse.PostPrendasResponseDto;
import com.example.ejercicioextra1.dto.request.PostPrendasRequestDto;

import java.util.List;

public interface IPrendaService {

    PostPrendasResponseDto save(PostPrendasRequestDto postPrendasRequestDto);
    List<PostPrendasResponseDto> findAll(String talle, String name);
    PostPrendasResponseDto findById(Long id);
    void modifyById(Long id, PostPrendasRequestDto postPrendasRequestDto);
    void deleteById(Long id);

}
