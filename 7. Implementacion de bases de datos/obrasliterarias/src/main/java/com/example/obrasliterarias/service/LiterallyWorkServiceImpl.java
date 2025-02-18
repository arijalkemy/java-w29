package com.example.obrasliterarias.service;

import com.example.obrasliterarias.dto.request.LiterallyWorkRequestDto;
import com.example.obrasliterarias.dto.response.LiterallyWorkResponseDto;
import com.example.obrasliterarias.model.LiterallyWork;
import com.example.obrasliterarias.repository.LiterallyWorkRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class LiterallyWorkServiceImpl implements ILiterallyWorkService {

    LiterallyWorkRepository literallyWorkRepository;
    ModelMapper mapper;

    public LiterallyWorkServiceImpl(LiterallyWorkRepository literallyWorkRepository) {
        this.literallyWorkRepository = literallyWorkRepository;
        this.mapper = new ModelMapper();
    }

    @Override
    public LiterallyWorkResponseDto saveLiterallyWork(LiterallyWorkRequestDto literallyWorkDTO) {
        LiterallyWork literallyWork = mapper.map(literallyWorkDTO, LiterallyWork.class);
        return mapper.map(literallyWorkRepository.save(literallyWork), LiterallyWorkResponseDto.class);
    }

    @Override
    public Iterable<LiterallyWork> findAllLiterallyWork() {
        return literallyWorkRepository.findAll();
    }

    @Override
    public LiterallyWorkResponseDto findLiterallyWorkById(String id) {
        return convertEntityToDto(literallyWorkRepository.findById(id).get());
    }

    @Override
    public List<LiterallyWorkResponseDto>  findLiterallyWorkByAuthorName(String name) {
        return literallyWorkRepository.findLiterallyWorkByAuthorNameContaining(name)
                .stream()
                .map(this::convertEntityToDto)
                .toList();
    }

    @Override
    public List<LiterallyWorkResponseDto>  findLiterallyWorkByNameTitle(String name) {
        return literallyWorkRepository.findLiterallyWorkByNameContaining(name)
                .stream()
                .map(this::convertEntityToDto)
                .toList();
    }

    @Override
    public List<LiterallyWorkResponseDto> findLiterallyWorkTopFiveByMaxPages() {
        return literallyWorkRepository.findAllByOrderByQuantityPagesDesc()
                .stream()
                .limit(5)
                .map(this::convertEntityToDto)
                .toList();
    }

    @Override
    public List<LiterallyWorkResponseDto> findLiteralWorkByBeforeYear(Integer year) {
        return literallyWorkRepository.findLiterallyWorkByYearBefore(year)
                .stream()
                .map(this::convertEntityToDto)
                .toList();
    }

    @Override
    public List<LiterallyWorkResponseDto> findLiterallyWorkByNameEditorial(String name) {
        return literallyWorkRepository.findLiterallyWorkByEditorial_NameContaining(name)
                .stream()
                .map(this::convertEntityToDto)
                .toList();
    }

    private LiterallyWorkResponseDto convertEntityToDto(LiterallyWork literallyWork){
        return mapper.map(literallyWork, LiterallyWorkResponseDto.class);
    }
}
