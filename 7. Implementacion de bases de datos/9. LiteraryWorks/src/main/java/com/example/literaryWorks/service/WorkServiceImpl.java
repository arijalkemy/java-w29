package com.example.literaryWorks.service;

import com.example.literaryWorks.dto.WorkDTO;
import com.example.literaryWorks.model.Work;
import com.example.literaryWorks.repository.IWorkRepository;
import com.example.literaryWorks.utils.WorkMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WorkServiceImpl implements IWorkService {

    private final IWorkRepository workRepository;

    @Override
    public List<WorkDTO> findAll() {
        List<WorkDTO> workDTOList = new ArrayList<>();
        workRepository.findAll().forEach(w -> workDTOList.add(WorkMapper.INSTANCE.toDTO(w)));

        return workDTOList;
    }

    @Override
    public WorkDTO save(WorkDTO workDTO) {
        Work work = WorkMapper.INSTANCE.toEntity(workDTO);
        return WorkMapper.INSTANCE.toDTO(workRepository.save(work));
    }

    @Override
    public List<WorkDTO> findWorksByName(String name) {
        return parseList(workRepository.findWorksByName(name));
    }

    @Override
    public List<WorkDTO> findWorksByWordInName(String word) {
        return parseList(workRepository.findWorksByWordInName(word));
    }

    @Override
    public List<WorkDTO> findWorksByPagesOrderByPagesDesc() {
        return parseList(workRepository.findWorksByPagesOrderByPagesDesc());
    }

    @Override
    public List<WorkDTO> findWorksByPublishedYear(Integer publishedYear) {
        return parseList(workRepository.findWorksByPublishedYear(publishedYear));
    }

    @Override
    public List<WorkDTO> findWorksByPublisher(String publisher) {
        return parseList(workRepository.findWorksByPublisher(publisher));
    }

    private List<WorkDTO> parseList(List<Work> workList) {
        return workList.stream()
                .map(WorkMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }
}
