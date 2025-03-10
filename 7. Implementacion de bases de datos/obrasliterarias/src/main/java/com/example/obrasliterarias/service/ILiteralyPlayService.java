package com.example.obrasliterarias.service;

import com.example.obrasliterarias.dto.request.LiteralyPlayRequestDto;
import com.example.obrasliterarias.dto.response.LiteralyPlayResponseDto;
import com.example.obrasliterarias.model.LiteralyWork;

public interface ILiteralyPlayService {

    LiteralyWork saveLiteralyPlay(LiteralyWork literalyWork);
    Iterable<LiteralyWork> findAllLiteralyPlay();
    LiteralyWork findLiteralyPlayById(String id);
    LiteralyPlayResponseDto updateLiteralyPlay(Long id, LiteralyPlayRequestDto literalyPlayRequestDto);
}
