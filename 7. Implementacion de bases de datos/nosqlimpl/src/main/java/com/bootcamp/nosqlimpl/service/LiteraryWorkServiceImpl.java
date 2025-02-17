package com.bootcamp.nosqlimpl.service;

import com.bootcamp.nosqlimpl.dto.LiteraryWorkDTO;
import com.bootcamp.nosqlimpl.entity.LiteraryWork;
import com.bootcamp.nosqlimpl.repository.LiteraryWorkRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LiteraryWorkServiceImpl implements ILiteraryWorkService {

    private final ModelMapper mapper;
    private final LiteraryWorkRepository literaryWorkRepository;

    public LiteraryWorkServiceImpl(LiteraryWorkRepository literaryWorkRepository) {
        this.mapper = new ModelMapper();
        this.literaryWorkRepository = literaryWorkRepository;
    }

    @Override
    public List<LiteraryWorkDTO> saveAll(List<LiteraryWorkDTO> literaryWorkDTOList) {
        List<LiteraryWork> savedLiteraryWorksList = (List<LiteraryWork>) literaryWorkRepository.saveAll(literaryWorkDTOList
                .stream()
                .map(lwDTO -> mapper.map(lwDTO, LiteraryWork.class))
                .toList());

        return savedLiteraryWorksList.stream().map(lw -> mapper.map(lw, LiteraryWorkDTO.class)).toList();
    }

    @Override
    public LiteraryWorkDTO save(LiteraryWorkDTO literaryWorkDTO) {
        LiteraryWork literaryWorkSaved = literaryWorkRepository.save(mapper.map(literaryWorkDTO, LiteraryWork.class));
        return mapper.map(literaryWorkSaved, LiteraryWorkDTO.class);
    }

    @Override
    public List<LiteraryWorkDTO> searchAllByAutor(String autor) {
        return literaryWorkRepository.findByAuthorContaining(autor)
                .stream()
                .map(literaryWork -> mapper.map(literaryWork, LiteraryWorkDTO.class))
                .toList();
    }

    @Override
    public List<LiteraryWorkDTO> searchAllByTitleKeyWord(String name) {
        return literaryWorkRepository.findByNameContaining(name)
                .stream()
                .map(literaryWork -> mapper.map(literaryWork, LiteraryWorkDTO.class))
                .toList();
    }

    @Override
    public List<LiteraryWorkDTO> searchTopFiveByPageCount() {
        return literaryWorkRepository.findTop5ByOrderByPageCountDesc()
                .stream()
                .map(literaryWork -> mapper.map(literaryWork, LiteraryWorkDTO.class))
                .toList();
    }

    @Override
    public List<LiteraryWorkDTO> searchAllByPublicationYear(Integer publicationYear) {
        return literaryWorkRepository.findByPublicationYearBefore(publicationYear)
                .stream()
                .map(literaryWork -> mapper.map(literaryWork, LiteraryWorkDTO.class))
                .toList();
    }

    @Override
    public List<LiteraryWorkDTO> searchAllByPublisher(String publisher) {
        return literaryWorkRepository.findByPublisher(publisher)
                .stream()
                .map(literaryWork -> mapper.map(literaryWork, LiteraryWorkDTO.class))
                .toList();
    }
}
