package com.example.demo.service;

import org.springframework.transaction.annotation.Transactional;
import com.example.demo.repository.ITestCaseRepository;
import com.example.demo.dto.response.TestCaseResDTO;
import com.example.demo.dto.request.TestCaseReqDTO;
import org.springframework.stereotype.Service;
import com.example.demo.utils.TestCaseMapper;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TestCaseService implements ITestCaseService {
    private final ITestCaseRepository repository;
    private final TestCaseMapper mapper;

    @Override
    @Transactional(readOnly = true)
    public void createTestCase(TestCaseReqDTO testCaseReqDTO) {
        repository.save(mapper.reqToEntity(testCaseReqDTO));
    }

    @Override
    @Transactional(readOnly = true)
    public void deleteTestCase(Long id) {
        repository.delete(repository.findById(id).orElseThrow(()
                -> new RuntimeException("Test case not found with id " + id)));
    }

    @Override
    @Transactional(readOnly = true)
    public void updateTestCase(Long id, TestCaseReqDTO testCaseReqDTO) {
        repository.findById(id).orElseThrow(()
                -> new RuntimeException("Test case not found with id " + id));
        repository.save(mapper.reqToEntity(testCaseReqDTO));
    }

    @Override
    @Transactional(readOnly = true)
    public List<TestCaseResDTO> getTestCases(LocalDate lastUpdate) {
        return repository.findAll()
                .stream()
                .map(mapper::resToDTO)
                .filter(testCase -> lastUpdate == null ||
                        !testCase.lastUpdate().isBefore(lastUpdate))
                // Niego el isBefore para que devuelva tanto el mismo día como los días posteriores en lugar de isAfter e isEquals
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public TestCaseResDTO getTestCaseById(Long id) {
        return mapper.resToDTO(repository.findById(id).orElseThrow(()
                -> new RuntimeException("Test case not found with id " + id)));
    }
}
