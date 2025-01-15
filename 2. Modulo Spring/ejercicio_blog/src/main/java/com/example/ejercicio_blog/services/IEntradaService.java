package com.example.ejercicio_blog.services;

import com.example.ejercicio_blog.dto.EntradaBlogDto;
import com.example.ejercicio_blog.dto.response.EntradaSuccessDto;

import java.util.List;

public interface IEntradaService {
    List<EntradaBlogDto> listAll();
    EntradaSuccessDto add(EntradaBlogDto entrada);
    EntradaBlogDto findById(Integer id);
}
