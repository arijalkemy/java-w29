package com.org.meli.obrasliterarias.service;

import com.org.meli.obrasliterarias.dto.LiteraryWorkDto;
import com.org.meli.obrasliterarias.entity.LiteraryWork;
import com.org.meli.obrasliterarias.repository.ILiteraryWorkRepository;
import com.org.meli.obrasliterarias.util.ModelMapperUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LiteraryWorkService implements ILiteraryWorkService{

    private final ILiteraryWorkRepository literaryWorkRepository;

    public LiteraryWorkService(ILiteraryWorkRepository literaryWorkRepository) {
        this.literaryWorkRepository = literaryWorkRepository;
    }

    @Override
    public List<LiteraryWorkDto> findLiteraryWorksByAuthor(String author) {
        List<LiteraryWork> literaryWorks = literaryWorkRepository.findLiteraryWorksByAuthor(author);
        return literaryWorks.stream()
                .map(literaryWork -> ModelMapperUtil.map(literaryWork, LiteraryWorkDto.class))
                .toList();
    }

    @Override
    public List<LiteraryWorkDto> findLiteraryWorksByTitleContaining(String name) {
        List<LiteraryWork> literaryWorks = literaryWorkRepository.findLiteraryWorksByName(name);
        return literaryWorks.stream()
                .map(literaryWork -> ModelMapperUtil.map(literaryWork, LiteraryWorkDto.class))
                .toList();
    }

    @Override
    public List<LiteraryWorkDto> findTopFiveLiteraryWorksByNumberPages() {
        List<LiteraryWork> literaryWorks = literaryWorkRepository.findTop5LiteraryWorksByOrderByNumberOfPagesDesc();
        return literaryWorks.stream()
                .map(literaryWork -> ModelMapperUtil.map(literaryWork, LiteraryWorkDto.class))
                .toList();
    }

    @Override
    public List<LiteraryWorkDto> findLiteraryWorksByYear(String year) {
        List<LiteraryWork> literaryWorks = literaryWorkRepository.findLiteraryWorksByPublicationYearBefore(year);
        return literaryWorks.stream()
                .map(literaryWork -> ModelMapperUtil.map(literaryWork, LiteraryWorkDto.class))
                .toList();
    }

    @Override
    public List<LiteraryWorkDto> findLiteraryWorksByEditorial(String editorial) {
        List<LiteraryWork> literaryWorks = literaryWorkRepository.findLiteraryWorksByEditorial(editorial);
        return literaryWorks.stream()
                .map(literaryWork -> ModelMapperUtil.map(literaryWork, LiteraryWorkDto.class))
                .toList();
    }
}