package com.meli.elastic_example.service;

import com.meli.elastic_example.dto.LiteraryWorkDTO;

import java.util.List;

public interface ILiteraryWorkService {
    List<LiteraryWorkDTO> findLiteraryWorksByAuthor(String author);

    List<LiteraryWorkDTO> findLiteraryWorksByTitleContaining(String name);

    List<LiteraryWorkDTO> findTopFiveLiteraryWorksByNumberPages();

    List<LiteraryWorkDTO> findLiteraryWorksByYear(String year);

    List<LiteraryWorkDTO> findLiteraryWorksByEditorial(String editorial);
}
