package com.testers.apitester.service;

import com.testers.apitester.model.TestCase;
import com.testers.apitester.repository.TestCaseRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TestCaseImpl implements ITestCaseService{

    private final TestCaseRepository testRepo;

    public TestCaseImpl(TestCaseRepository testRepo){
        this.testRepo = testRepo;
    }

    @Override
    @Transactional
    public void saveTestCase(TestCase testCase) {
        testRepo.save(testCase);
    }

    @Override
    @Transactional (readOnly = true)
    public List<TestCase> getTestCase() {
        List<TestCase> listTest = testRepo.findAll();
        return listTest;
    }

    @Override
    @Transactional
    public TestCase findTestById(Long id){
        TestCase test = testRepo.findById(id).orElse(null);
        return test;
    }

    @Override
    @Transactional
    public void deleteTest(Long id) {
        testRepo.deleteById(id);
    }
}
