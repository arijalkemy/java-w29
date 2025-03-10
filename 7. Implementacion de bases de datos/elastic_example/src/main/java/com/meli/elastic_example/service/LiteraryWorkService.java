package com.meli.elastic_example.service;

import com.meli.elastic_example.dto.LiteraryWorkDTO;
import com.meli.elastic_example.entity.LiteraryWork;
import com.meli.elastic_example.repository.ILiteraryWorkRepository;
import com.meli.elastic_example.util.ModelMapperUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LiteraryWorkService implements ILiteraryWorkService{

    private final ILiteraryWorkRepository literaryWorkRepository;

    public LiteraryWorkService(ILiteraryWorkRepository literaryWorkRepository) {
        this.literaryWorkRepository = literaryWorkRepository;
    }

    @Override
    public List<LiteraryWorkDTO> findLiteraryWorksByAuthor(String author) {
        List<LiteraryWork> literaryWorks = literaryWorkRepository.findLiteraryWorksByAuthor(author);
        return literaryWorks.stream()
                .map(literaryWork -> ModelMapperUtil.map(literaryWork, LiteraryWorkDTO.class))
                .toList();
    }

    @Override
    public List<LiteraryWorkDTO> findLiteraryWorksByTitleContaining(String name) {
                List<LiteraryWork> literaryWorks = literaryWorkRepository.findLiteraryWorksByName(name);
        return literaryWorks.stream()
                .map(literaryWork -> ModelMapperUtil.map(literaryWork, LiteraryWorkDTO.class))
                .toList();
    }

    @Override
    public List<LiteraryWorkDTO> findTopFiveLiteraryWorksByNumberPages() {
                List<LiteraryWork> literaryWorks = literaryWorkRepository.findTop5LiteraryWorksByOrderByNumberOfPagesDesc();
        return literaryWorks.stream()
                .map(literaryWork -> ModelMapperUtil.map(literaryWork, LiteraryWorkDTO.class))
                .toList();
    }

    @Override
    public List<LiteraryWorkDTO> findLiteraryWorksByYear(String year) {
                List<LiteraryWork> literaryWorks = literaryWorkRepository.findLiteraryWorksByPublicationYearBefore(year);
        return literaryWorks.stream()
                .map(literaryWork -> ModelMapperUtil.map(literaryWork, LiteraryWorkDTO.class))
                .toList();
    }

    @Override
    public List<LiteraryWorkDTO> findLiteraryWorksByEditorial(String editorial) {
                List<LiteraryWork> literaryWorks = literaryWorkRepository.findLiteraryWorksByEditorial(editorial);
        return literaryWorks.stream()
                .map(literaryWork -> ModelMapperUtil.map(literaryWork, LiteraryWorkDTO.class))
                .toList();
    }
}
