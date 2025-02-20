package com.org.meli.obrasliterarias.service;

import com.org.meli.obrasliterarias.dto.LiteraryWorkDto;

import java.util.List;

public interface ILiteraryWorkService {
    List<LiteraryWorkDto> findLiteraryWorksByAuthor(String author);

    List<LiteraryWorkDto> findLiteraryWorksByTitleContaining(String name);

    List<LiteraryWorkDto> findTopFiveLiteraryWorksByNumberPages();

    List<LiteraryWorkDto> findLiteraryWorksByYear(String year);

    List<LiteraryWorkDto> findLiteraryWorksByEditorial(String editorial);
}
