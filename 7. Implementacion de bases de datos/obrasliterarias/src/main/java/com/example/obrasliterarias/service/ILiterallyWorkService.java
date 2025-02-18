package com.example.obrasliterarias.service;

import com.example.obrasliterarias.dto.request.LiterallyWorkRequestDto;
import com.example.obrasliterarias.dto.response.LiterallyWorkResponseDto;
import com.example.obrasliterarias.model.LiterallyWork;

import java.util.List;

public interface ILiterallyWorkService {

    LiterallyWorkResponseDto saveLiterallyWork(LiterallyWorkRequestDto literallyWorkDTO);
    Iterable<LiterallyWork> findAllLiterallyWork();
    LiterallyWorkResponseDto findLiterallyWorkById(String id);
    List<LiterallyWorkResponseDto> findLiterallyWorkByAuthorName(String name);
    List<LiterallyWorkResponseDto> findLiterallyWorkByNameTitle(String name);
    List<LiterallyWorkResponseDto> findLiterallyWorkTopFiveByMaxPages();
    List<LiterallyWorkResponseDto> findLiteralWorkByBeforeYear(Integer year);
    List<LiterallyWorkResponseDto> findLiterallyWorkByNameEditorial(String name);

}
