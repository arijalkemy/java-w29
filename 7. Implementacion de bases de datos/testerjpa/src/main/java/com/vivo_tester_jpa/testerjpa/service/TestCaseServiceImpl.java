package com.vivo_tester_jpa.testerjpa.service;

import com.vivo_tester_jpa.testerjpa.dto.MessageDto;
import com.vivo_tester_jpa.testerjpa.model.TestCase;
import com.vivo_tester_jpa.testerjpa.repository.ITestCaseRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class TestCaseServiceImpl implements ITestCaseService {
    private final ITestCaseRepository testRepo;

    public TestCaseServiceImpl(ITestCaseRepository testRepo) {
        this.testRepo = testRepo;
    }

    @Override
    public MessageDto saveTestCase(TestCase tc) {
        testRepo.save(tc);
        return new MessageDto("Guardado con exito!");

    }

    @Override
    public List<TestCase> getAllTestCase() {
        return testRepo.findAll();
    }

    @Override
    public List<TestCase> getTestCasesByLastUpdateAfter(LocalDate date) {
        return testRepo.findByLastUpdateAfter(date);
    }


    @Override
    public TestCase getTestCaseById(Long id) {
        return testRepo.findById(id).orElse(null);
    }

    @Override
    public MessageDto deleteTestCase(Long id) {
        testRepo.deleteById(id);
        return new MessageDto("Eliminado correctamente!");
    }
}
