package org.melibootcamp.qatester.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.melibootcamp.qatester.Exception.TestNotFoundException;
import org.melibootcamp.qatester.dto.MessajeDto;
import org.melibootcamp.qatester.dto.TestDto;
import org.melibootcamp.qatester.model.TestCase;
import org.melibootcamp.qatester.repository.ITestRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TestService implements ITestService {

    @Autowired
    private ITestRepository repository;

    @Override
    public MessajeDto createTestCase(TestDto testCaseDTO) {

        ModelMapper modelMapper = new ModelMapper();
        TestCase test = modelMapper.map(testCaseDTO, TestCase.class);
        repository.save(test);
        return new MessajeDto("Test case created successfully");
    }

    @Override
    @Transactional
    public MessajeDto updateTestCase(TestDto testCaseDTO) {
        TestDto testDto = getTestCase(testCaseDTO.getId());
        ModelMapper modelMapper = new ModelMapper();
        TestCase testCase = modelMapper.map(testCaseDTO, TestCase.class);
        repository.save(testCase);
        return new MessajeDto("Test case updated successfully");
    }

    @Override
    @Transactional
    public MessajeDto deleteTestCase(Long id) {
        TestDto test = getTestCase(id);
        if (test != null) {
            repository.deleteById(id);
            return new MessajeDto("Test case deleted successfully");
        }

        return null;
    }

    @Override
    @Transactional
    public TestDto getTestCase(Long id) {
        Optional<TestCase> test = repository.findById(id);
        if(test.isPresent()){
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(test.get(), TestDto.class);
        }

        throw new TestNotFoundException("Test case not found");
    }

    @Override
    @Transactional
    public List<TestDto> getAllTestCases() {
        List<TestCase> test = repository.findAll();
        if(!test.isEmpty()){
            ModelMapper modelMapper = new ModelMapper();
            return test.stream().map(testCase -> modelMapper.map(testCase, TestDto.class)).toList();
        }
        throw new TestNotFoundException("Test case not found");
    }

    @Override
    @Transactional
    public List<TestDto> getNotPassedTest() {
        List<TestCase> test = repository.findTestCaseByPassedFalse();
        if (!test.isEmpty()) {
            ModelMapper modelMapper = new ModelMapper();
            return test.stream().map(testCase -> modelMapper.map(testCase, TestDto.class)).toList();
        }
        throw new TestNotFoundException("Test case not found");
    }


    private Boolean existTestCase(Long id){
       return repository.existsById(id);
    }
}
