package org.example.ej_qatester.service;

import org.example.ej_qatester.dto.TestCaseDto;
import org.example.ej_qatester.model.TestCase;
import org.example.ej_qatester.repository.ITestCaseRepository;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TestCaseImpl implements ITestCaseService {

    private final ITestCaseRepository repository;

    ModelMapper mapper;

    public TestCaseImpl(ITestCaseRepository repository) {
        this.repository = repository;
        this.mapper = new ModelMapper();
    }

    @Override
    public List<TestCaseDto> getAllTestCase(LocalDate lastUpdate) {

        if (lastUpdate == null) {

            return repository.findAll().stream()
                    .map(testCase -> mapper.map(testCase, TestCaseDto.class))
                    .toList();
        } else {
            return repository.findByLastUpdateAfter(lastUpdate)
                    .stream()
                    .map(testCaseDto -> mapper.map(testCaseDto, TestCaseDto.class))
                    .toList();
        }

    }

    @Override
    public TestCaseDto addTestCase(TestCaseDto testCaseDto) {

        TestCase test = mapper.map(testCaseDto, TestCase.class);

        System.out.println("TestCase object: " + test);
        test = repository.save(test);

        return mapper.map(test, TestCaseDto.class);
    }

    @Override
    public TestCaseDto findTestCaseById(Long testCaseId) {
        TestCase testCase = repository.findById(testCaseId).orElseThrow(() -> new IllegalArgumentException("Test case not found"));

        return mapper.map(testCase, TestCaseDto.class);
    }

    @Override
    public TestCaseDto updateTestCase(Long id, TestCaseDto testCaseDto) {
        Optional<TestCase> tcOptional = repository.findById(id);

        if (tcOptional.isEmpty())
            throw new IllegalArgumentException("Test case not found");

        TestCase update = mapper.map(testCaseDto, TestCase.class);
        update.setId(tcOptional.get().getId());

        return mapper.map(repository.save(update), TestCaseDto.class);
    }

    @Override
    public void deleteTest(Long id) {
        repository.deleteById(id);
    }
}
