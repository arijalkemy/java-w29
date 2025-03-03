package org.meli.qatesters.service;

import org.meli.qatesters.dto.request.TestCaseDTO;
import org.meli.qatesters.entity.TestCase;
import org.meli.qatesters.exception.InvalidDateFormatException;
import org.meli.qatesters.exception.TestCaseNotFoundException;
import org.meli.qatesters.exception.TestCasesNotFoundException;
import org.meli.qatesters.repository.ITestCaseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;

@Service
public class ITestCaseServiceImpl implements ITestCaseService {
    private final ITestCaseRepository testCaseRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ITestCaseServiceImpl(ITestCaseRepository testCaseRepository) {
        this.testCaseRepository = testCaseRepository;
        modelMapper = new ModelMapper();
    }

    @Override
    public TestCase createTestCase(TestCaseDTO testCaseDto) {
        TestCase testToSave = modelMapper.map(testCaseDto, TestCase.class);
        return testCaseRepository.save(testToSave);
    }

    @Override
    public TestCase getTestCaseById(Long id) {
        Optional<TestCase> testCaseOptional = testCaseRepository.findById(id);
        if (testCaseOptional.isEmpty()) {
            throw new TestCaseNotFoundException(id);
        }
        return testCaseOptional.get();
    }

    @Override
    public List<TestCase> getAllTestCases() {
        List<TestCase> testCases = testCaseRepository.findAll();
        if (testCases.isEmpty()) {
            throw new TestCasesNotFoundException();
        }
        return testCases;
    }

    @Override
    public TestCase updateTestCase(Long id, TestCaseDTO testCaseDto) {
        Optional<TestCase> testCaseOptional = testCaseRepository.findById(id);
        if (testCaseOptional.isEmpty()) {
            throw new TestCaseNotFoundException(id);
        }
        TestCase testCase = testCaseOptional.get();
        modelMapper.map(testCaseDto, testCase);
        return testCaseRepository.save(testCase);
    }

    @Override
    public void deleteTestCase(Long id) {
        Optional<TestCase> testCaseOptional = testCaseRepository.findById(id);
        if (testCaseOptional.isEmpty()) {
            throw new TestCaseNotFoundException(id);
        }
        testCaseRepository.delete(testCaseOptional.get());
    }

    @Override
    public List<TestCase> getTestCasesByDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate parsedDate;
        try {
            parsedDate = LocalDate.parse(date, formatter);
        } catch (DateTimeParseException e) {
            throw new InvalidDateFormatException();
        }
        List<TestCase> testCases = testCaseRepository.findAllByDate(parsedDate);
        if (testCases.isEmpty()) {
            throw new TestCasesNotFoundException();
        }
        return testCases;
    }
}
