package com.mercadolibre.bootcamp.qatesters.service;

import com.mercadolibre.bootcamp.qatesters.dto.TestCaseDto;
import com.mercadolibre.bootcamp.qatesters.model.TestCase;
import com.mercadolibre.bootcamp.qatesters.repository.TestCaseRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TestCaseServiceImpl implements ITestCaseService {

    private final ModelMapper modelMapper;

    private final TestCaseRepository tcRepository;

    public TestCaseServiceImpl(TestCaseRepository tcRepository) {
        this.tcRepository = tcRepository;
        modelMapper = new ModelMapper();
    }

    @Override
    @Transactional
    public List<TestCaseDto> findAll() {
        return tcRepository.findAll()
                .stream()
                .map(TestCaseDto::from)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<TestCaseDto> findAllFiltered(LocalDate lastUpdate) {
        return tcRepository.findByLastUpdateAfter(lastUpdate)
                .stream()
                .map(TestCaseDto::from)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public TestCaseDto save(TestCaseDto testCaseDto) {
        TestCase testCase = TestCaseDto.to(testCaseDto);
        TestCase saved = tcRepository.save(testCase);
        return TestCaseDto.from(saved);
    }

    @Override
    @Transactional
    public TestCaseDto findById(Long id) {
        TestCase tc = tcRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Test case not found"));
        return TestCaseDto.from(tc);
    }

    @Override
    @Transactional
    public void update(Long id, TestCaseDto testCaseDto) {
        Optional<TestCase> tcOptional = tcRepository.findById(id);

        if (tcOptional.isEmpty())
            throw new IllegalArgumentException("Test case not found");

        TestCase updated = tcOptional.get();
        updated.setTested(testCaseDto.getTested());
        updated.setLastUpdate(testCaseDto.getLastUpdate());
        updated.setDescription(testCaseDto.getDescription());
        updated.setPassed(testCaseDto.getPassed());
        updated.setNumberOfTries(testCaseDto.getNumberOfTries());

        tcRepository.save(updated);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        tcRepository.deleteById(id);
    }
}
