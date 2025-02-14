package com.example.testers.service;

import com.example.testers.exceptions.NotFoundException;
import com.example.testers.model.TestCase;
import com.example.testers.repository.TestCaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TestCaseServiceImpl implements TestCaseService {

    private final TestCaseRepository repository;

    @Override
    public List<TestCase> getTestCases(LocalDate lastUpdate) {
        List<TestCase> tests = repository.findAll();
        if (lastUpdate != null) {
            tests.removeIf(test -> test.getLastUpdate().isBefore(lastUpdate));
        }
        return tests;
    }

    @Override
    public void saveTestCase(TestCase testCase) {
        repository.save(testCase);
    }

    @Override
    public TestCase findTestCase(Long id) {
        return getTestCaseIfExists(id);
    }

    @Override
    public void updateTestCase(Long id, TestCase testCase) {
        getTestCaseIfExists(id);
        testCase.setId(id);
        repository.save(testCase);
    }

    @Override
    public void deleteTestCase(Long id) {
        getTestCaseIfExists(id);
        repository.deleteById(id);
    }

    private TestCase getTestCaseIfExists(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Test case not found"));
    }
}
