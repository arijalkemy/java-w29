package com.example.obrasliterarias.service.impl;

import com.example.obrasliterarias.dto.request.LiteralyPlayRequestDto;
import com.example.obrasliterarias.dto.response.LiteralyPlayResponseDto;
import com.example.obrasliterarias.model.LiteralyWork;
import com.example.obrasliterarias.repository.LiteralyPlayRepository;
import com.example.obrasliterarias.service.ILiteralyPlayService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class LiteralyPlayServiceImpl implements ILiteralyPlayService {

    LiteralyPlayRepository literalyPlayRepository;
    ModelMapper mapper;

    public LiteralyPlayServiceImpl(LiteralyPlayRepository literalyPlayRepository) {
        this.literalyPlayRepository = literalyPlayRepository;
        this.mapper = new ModelMapper();
    }

    @Override
    public LiteralyWork saveLiteralyPlay(LiteralyWork literalyWork) {
//        LiteralyWork literalyWork = mapper.map(literalyPlayRequestDto, LiteralyWork.class);
//        return mapper.map(literalyPlayRepository.save(literalyWork), LiteralyPlayResponseDto.class);
        return literalyPlayRepository.save(literalyWork);
    }

    @Override
    public Iterable<LiteralyWork> findAllLiteralyPlay() {
        return literalyPlayRepository.findAll();
    }

    @Override
    public LiteralyWork findLiteralyPlayById(String id) {
        return literalyPlayRepository.findById(id).get();
    }

    @Override
    public LiteralyPlayResponseDto updateLiteralyPlay(Long id, LiteralyPlayRequestDto literalyPlayRequestDto) {
        return null;
    }
}
