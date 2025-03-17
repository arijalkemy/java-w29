package com.example.obrasliterarias.service;

import com.example.obrasliterarias.model.ObraLiteraria;

import java.util.List;

public interface IObrasLiterariasService {

    List<ObraLiteraria> getObrasByAutor(String autor);

    List<ObraLiteraria> getObrasByTitleContaining(String keyword);

    List<ObraLiteraria> getTop5ObrasByPages();

    List<ObraLiteraria> getObrasPublishedBeforeYear(Integer year);

    List<ObraLiteraria> getObrasByEditorial(String editorial);
}
