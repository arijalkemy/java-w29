package com.mercadolibre.bootcamp.qatesters.service;

import com.mercadolibre.bootcamp.qatesters.dto.TestCaseDto;
import com.mercadolibre.bootcamp.qatesters.dto.response.MessageDto;
import com.mercadolibre.bootcamp.qatesters.model.TestCase;
import com.mercadolibre.bootcamp.qatesters.repository.TestCaseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TestCaseServiceImpl implements ITestCaseService {

    private final TestCaseRepository tcRepository;

    public TestCaseServiceImpl(TestCaseRepository tcRepository) {
        this.tcRepository = tcRepository;
    }

    @Override
    public List<TestCaseDto> findAll(LocalDate lastUpdate) {
        ModelMapper modelMapper = new ModelMapper();
        if (lastUpdate == null)
            return tcRepository.findAll()
                    .stream()
                    .map(testCase -> modelMapper.map(testCase, TestCaseDto.class))
                    .collect(Collectors.toList());
        return tcRepository.findByLastUpdateAfter(lastUpdate)
                .stream()
                .map(testCase -> modelMapper.map(testCase, TestCaseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public TestCaseDto save(TestCaseDto testCaseDto) {
        ModelMapper modelMapper = new ModelMapper();
        TestCase testCase = modelMapper.map(testCaseDto, TestCase.class);
        TestCase saved = tcRepository.save(testCase);
        return modelMapper.map(saved, TestCaseDto.class);
    }

    @Override
    public TestCaseDto findById(Long id) {
        ModelMapper modelMapper = new ModelMapper();
        TestCase tc = tcRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Test case not found"));
        return modelMapper.map(tc, TestCaseDto.class);
    }

    @Override
    public MessageDto update(Long id, TestCaseDto testCaseDto) {
        ModelMapper modelMapper = new ModelMapper();
        Optional<TestCase> tcOptional = tcRepository.findById(id);

        if (tcOptional.isEmpty()) {
            throw new IllegalArgumentException("Test case not found");
        }

        TestCase updated = modelMapper.map(testCaseDto, TestCase.class);
        updated.setIdCase(tcOptional.get().getIdCase());

        tcRepository.save(updated);

        return new MessageDto("Updated successfully");
    }

    @Override
    public MessageDto delete(Long id) {
        Optional<TestCase> tcOptional = tcRepository.findById(id);

        if (tcOptional.isEmpty()) {
            throw new IllegalArgumentException("Test case not found");
        }

        tcRepository.deleteById(id);

        return new MessageDto("Deleted successfully");
    }
}
