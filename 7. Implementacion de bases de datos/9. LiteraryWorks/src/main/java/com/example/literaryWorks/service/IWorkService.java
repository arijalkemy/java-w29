package com.example.literaryWorks.service;

import com.example.literaryWorks.dto.WorkDTO;

import java.util.List;

public interface IWorkService {
    List<WorkDTO> findAll();
    WorkDTO save(WorkDTO workDTO);
    List<WorkDTO> findWorksByName(String name);
    List<WorkDTO> findWorksByWordInName(String word);
    List<WorkDTO> findWorksByPagesOrderByPagesDesc();
    List<WorkDTO> findWorksByPublishedYear(Integer publishedYear);
    List<WorkDTO> findWorksByPublisher(String publisher);
}
