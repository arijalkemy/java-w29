package com.example.qa_tester.service;

import com.example.qa_tester.dto.RequestTestCaseDto;
import com.example.qa_tester.dto.ResponseTestCaseDto;
import com.example.qa_tester.model.TestCase;
import com.example.qa_tester.repository.ITestCaseRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TestCaseService implements ITestCaseService {

    private final ITestCaseRepository repository;

    @Override
    public List<ResponseTestCaseDto> searchAll() {
        List<TestCase> testCases = repository.findAll();
        ModelMapper mapper = new ModelMapper();

        return testCases.stream()
                .map(tc -> mapper.map(tc, ResponseTestCaseDto.class))
                .toList();
    }

    @Override
    public ResponseTestCaseDto searchById(Long id) {
        Optional<TestCase> testCase = repository.findById(id);
        if(testCase.isEmpty())
            throw new RuntimeException("No se encontró el test case");

        ModelMapper mapper = new ModelMapper();
        return mapper.map(testCase.get(), ResponseTestCaseDto.class);
    }

    @Override
    public void create(RequestTestCaseDto request) {
        ModelMapper mapper = new ModelMapper();
        TestCase requestEntity = mapper.map(request, TestCase.class);
        repository.save(requestEntity);
    }

    @Override
    public void updateById(Long id, RequestTestCaseDto request) {
        ModelMapper mapper = new ModelMapper();
        TestCase requestEntity = mapper.map(request, TestCase.class);
        requestEntity.setIdCase(id);
        repository.save(requestEntity);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
