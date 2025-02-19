package com.bootcamp.crudjpa.service;

import com.bootcamp.crudjpa.dto.TestCaseDto;
import com.bootcamp.crudjpa.exception.NotFoundException;
import com.bootcamp.crudjpa.model.TestCase;
import com.bootcamp.crudjpa.repository.ITestCaseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TestCaseServiceImpl implements ITestCaseService{

    private final ITestCaseRepository repository;
    private final ModelMapper mapper;

    public TestCaseServiceImpl(ITestCaseRepository testCaseRepository) {
        this.repository = testCaseRepository;
        this.mapper = new ModelMapper();
    }

    @Override
    public TestCase createTestCase(TestCaseDto testCaseDto) {
        TestCase testCase = mapper.map(testCaseDto, TestCase.class);
        return repository.save(testCase);
    }

    @Override
    public List<TestCase> readAllTestCases(LocalDate filter) {
        if (filter == null){
            return repository.findAll();
        }
        else{
            return repository.findByLastUpdateAfter(filter);
        }
    }

    @Override
    public TestCase readTestCase(Long id) {
        return repository.findById(id).orElseThrow(()->
                new NotFoundException("Test Case with id " + id + " not found"));
    }

    @Override
    public TestCase updateTestCase(Long id, TestCaseDto testCaseDto) {
        if (repository.existsById(id)){
            TestCase testCase = mapper.map(testCaseDto, TestCase.class);
            testCase.setIdCase(id);
            return repository.save(testCase);
        }
        else{
            throw new NotFoundException("Test Case with id " + id + " not found");
        }
    }

    @Override
    public Boolean deleteTestCase(Long id) {
        if (repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        else{
            throw new NotFoundException("Test Case with id " + id + " not found");
        }
    }
}
