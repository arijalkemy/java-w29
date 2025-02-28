package com.example.vehicles.service;

import com.example.vehicles.dto.AccidentDTO;
import com.example.vehicles.repository.IAccidentRepository;
import com.example.vehicles.utils.AccidentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccidentServiceImpl implements IAccidentService {

    private final IAccidentRepository accidentRepository;

    @Override
    public List<AccidentDTO> getAllAccidents() {
        return accidentRepository.findAll()
                .stream()
                .map(AccidentMapper.INSTANCE::accidentToAccidentDTO)
                .toList();
    }
}
