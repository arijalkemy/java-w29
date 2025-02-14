package com.bootcamp.test_cases.service;

import com.bootcamp.test_cases.dto.TestCaseDto;
import com.bootcamp.test_cases.model.TestCase;
import com.bootcamp.test_cases.repository.TestCaseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class TestCaseService implements ITestCaseService{

    private TestCaseRepository repo;
    private ModelMapper mapper = new ModelMapper();

    @Autowired
    public TestCaseService(TestCaseRepository repo) {
        this.repo = repo;
    }

    @Override
    public TestCaseDto createTestCase(TestCaseDto testCaseDto) {
        TestCase testCase = mapper.map(testCaseDto, TestCase.class);
        testCase.setLastUpdate(LocalDate.now());
        repo.save(testCase);
        return testCaseDto;
    }

    @Override
    public List<TestCaseDto> getAllTestCases(String dateString) {
        ModelMapper mapper = new ModelMapper();
        List<TestCase> testCases = repo.findAll();
        if (dateString != null && !dateString.isEmpty()){
            LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            testCases = testCases.stream().filter(t -> t.getLastUpdate().isAfter(date)).toList();
        }
        return testCases.stream().map(t -> mapper.map(t, TestCaseDto.class)).toList();
    }

    @Override
    public TestCaseDto getCaseById(Long id) {
        TestCase testCase = repo.findById(id).orElseThrow(() -> new RuntimeException("Test case not found :("));
        return mapper.map(testCase, TestCaseDto.class);
    }

    @Override
    public TestCaseDto updateTestCase(Long id, TestCaseDto testCaseDto) {
        TestCase testCase = repo.findById(id).orElseThrow(() -> new RuntimeException("Test case not found :("));
        testCase.setDescription(testCaseDto.getDescription());
        testCase.setTested(testCaseDto.getTested());
        testCase.setPassed(testCaseDto.getPassed());
        testCase.setNumberOfTries(testCaseDto.getNumberOfTries());
        repo.save(testCase);
        return testCaseDto;
    }

    @Override
    public void deleteTestCaseById(Long id) {
        TestCase testCase = repo.findById(id).orElseThrow(() -> new RuntimeException("Test case not found :("));
        repo.delete(testCase);
    }
}
