package com.testcase.apitestcase.service;

import com.testcase.apitestcase.model.TestCase;
import com.testcase.apitestcase.repository.TestCaseRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TestCaseImpl implements ITestCaseService{

    private final TestCaseRepository testRepo;

    public TestCaseImpl(TestCaseRepository testRepo){
        this.testRepo = testRepo;
    }

    @Override
    public TestCase saveTestCase(TestCase testCase) {
        testRepo.save(testCase);
        return testCase;
    }

    @Override
    public List<TestCase> getAllTestCase() {
        List<TestCase> testCaseList = testRepo.findAll();
        return testCaseList;
    }

    @Override
    public Optional<TestCase> findTestCase(Long id) {
        Optional<TestCase> test = testRepo.findById(id);
        return test;
    }

    @Override
    public void deleteTestCase(Long id) {
        testRepo.deleteById(id);
    }

    @Override
    public List<TestCase> findTestByDate(LocalDate date) {
        List<TestCase> testCasesList = testRepo.findByLastUpdateAfter(date);
        return testCasesList;
    }
}
