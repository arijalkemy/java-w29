package com.meli.qatesters.service;

import com.meli.qatesters.model.TestCase;
import com.meli.qatesters.repository.ITestCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class TestCaseService implements ITestCaseService {

    @Autowired
    ITestCaseRepository testCaseRepository;

    @Override
    public List<TestCase> getTestCases() {
        return testCaseRepository.findAll();
    }

    @Override
    public TestCase findTestCase(Long id) {
        return testCaseRepository.findById(id).orElse(null);
    }

    @Override
    public void saveTestCase(TestCase testCase) {
        testCaseRepository.save(testCase);
    }

    @Override
    public TestCase updateTestCase(TestCase testCase, Long id) {
        Optional<TestCase> testCase1 = testCaseRepository.findById(id);
        if(testCase1.isPresent()) {
            testCase1.get().setDescription(testCase.getDescription());
            testCase1.get().setLast_update(testCase.getLast_update());
            testCase1.get().setTested(testCase.getTested());
            testCase1.get().setPassed(testCase.getPassed());
            testCase1.get().setNumber_of_tries(testCase.getNumber_of_tries());
            return testCaseRepository.save(testCase1.get());
        }
        return null;
    }

    @Override
    public void deleteTestCase(Long id) {
        testCaseRepository.deleteById(id);
    }

    @Override
    public List<TestCase> getTestCasesLastUpdate(String lastUpdateStr){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate last_update = LocalDate.parse(lastUpdateStr, formatter);
        return testCaseRepository.findAll().stream().filter(testCase -> testCase.getLast_update().equals(last_update)).toList();
    }
}
