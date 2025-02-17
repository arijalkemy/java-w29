package com.bootcamp.nosqlimpl.service;

import com.bootcamp.nosqlimpl.dto.LiteraryWorkDTO;

import java.util.List;

public interface ILiteraryWorkService {

    List<LiteraryWorkDTO> saveAll(List<LiteraryWorkDTO> literaryWorkDTOList);

    LiteraryWorkDTO save(LiteraryWorkDTO literaryWorkDTO);

    List<LiteraryWorkDTO> searchAllByAutor(String autor);

    List<LiteraryWorkDTO> searchAllByTitleKeyWord(String titleKeyWord);

    List<LiteraryWorkDTO> searchTopFiveByPageCount();

    List<LiteraryWorkDTO> searchAllByPublicationYear(Integer publicationYear);

    List<LiteraryWorkDTO> searchAllByPublisher(String publisher);

}
