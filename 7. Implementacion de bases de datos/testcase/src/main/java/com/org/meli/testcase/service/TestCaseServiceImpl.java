package com.org.meli.testcase.service;

import com.org.meli.testcase.dto.TestCaseDto;
import com.org.meli.testcase.exception.NotFoundException;
import com.org.meli.testcase.entity.TestCase;
import com.org.meli.testcase.repository.ITestCaseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.List;

@Service
public class TestCaseServiceImpl implements ITestCaseService {
    private final ITestCaseRepository testCaseRepository;
    private final ModelMapper mapper;

    public TestCaseServiceImpl(ITestCaseRepository testCaseRepository) {
        this.testCaseRepository = testCaseRepository;
        this.mapper = new ModelMapper();
    }

    @Override
    public TestCaseDto saveTestCase(TestCaseDto testCaseDto) {
        TestCase testCase = mapper.map(testCaseDto, TestCase.class);
        TestCase savedTestCase = testCaseRepository.save(testCase);
        return mapper.map(savedTestCase, TestCaseDto.class);
    }

    @Override
    public List<TestCaseDto> findAllTestCases() {
        List<TestCase> testCases = testCaseRepository.findAll();
        if (testCases.isEmpty()) {
            throw new NotFoundException("No se encontraron test cases");
        }
        return testCases.stream().map(testCase -> mapper.map(testCase, TestCaseDto.class)).toList();
    }

    @Override
    public TestCaseDto findTestCaseById(Long id) {
        TestCaseDto testCaseDto = testCaseRepository.findById(id)
                .map(testCase -> mapper.map(testCase, TestCaseDto.class))
                .orElseThrow(() -> new NotFoundException("No se encontró el test case con el id: " + id));
        return testCaseDto;
    }

    @Override
    public TestCaseDto updateTestCase(Long id, TestCaseDto testCaseDto) {
        TestCase testCase = testCaseRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No se encontró el test case con el id: " + id));
        testCase.setDescription(testCaseDto.getDescription());
        testCase.setTested(testCaseDto.getTested());
        testCase.setPassed(testCaseDto.getPassed());
        testCase.setNumberOfTries(testCaseDto.getNumberOfTries());
        testCase.setLastUpdate(testCaseDto.getLastUpdate());
        TestCase updatedTestCase = testCaseRepository.save(testCase);
        return mapper.map(updatedTestCase, TestCaseDto.class);
    }

    @Override
    public TestCaseDto deleteTestCase(Long id) {
        TestCase testCase = testCaseRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No se encontró el test case con el id: " + id));
        testCaseRepository.delete(testCase);
        return mapper.map(testCase, TestCaseDto.class);
    }

    @Override
    public List<TestCase> findTestCasesAfterDate(LocalDate date) {
        List<TestCase> testCases = testCaseRepository.findByLastUpdateAfter(date);
        if (testCases.isEmpty()) {
            throw new NotFoundException("No se encontraron test cases después de la fecha: " + date);
        }
        return testCases;
    }
}
