package com.meli.qa.service;

import com.meli.qa.dto.request.AddTestCaseRequestDto;
import com.meli.qa.dto.request.TestCaseDto;
import com.meli.qa.model.TestCase;
import com.meli.qa.repository.ITestCaseRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TestCaseServiceImpl implements ITestCaseService {

    private final ITestCaseRepository testCaseRepository;

    public TestCaseServiceImpl(ITestCaseRepository testCaseRepository) {
        this.testCaseRepository = testCaseRepository;
    }

    @Override
    public TestCaseDto save(AddTestCaseRequestDto testCaseDto) {

        TestCase testCase = TestCase.builder()
                .description(testCaseDto.getDescription())
                .tested(testCaseDto.getTested())
                .passed(testCaseDto.getPassed())
                .numberOfTries(testCaseDto.getNumberOfTries())
                .lastUpdate(LocalDate.now())
                .build();
        System.out.println(testCase);
        TestCase testCaseCreated = this.testCaseRepository.save(testCase);
        System.out.println(testCaseCreated);

        return TestCaseDto.builder()
                .idCase(testCaseCreated.getIdCase())
                .description(testCaseCreated.getDescription())
                .numberOfTries(testCaseCreated.getNumberOfTries())
                .passed(testCaseCreated.getPassed())
                .tested(testCaseCreated.getTested())
                .lastUpdate(testCaseCreated.getLastUpdate())
                .build();
    }

    @Override
    public List<TestCaseDto> findAll() {
        return this.testCaseRepository.findAll().stream().map(
                testCase -> TestCaseDto.builder()
                        .idCase(testCase.getIdCase())
                        .description(testCase.getDescription())
                        .numberOfTries(testCase.getNumberOfTries())
                        .passed(testCase.getPassed())
                        .tested(testCase.getTested())
                        .lastUpdate(testCase.getLastUpdate())
                        .build()
        ).toList();
    }

    @Override
    public TestCaseDto findById(Long id) {
        TestCase testCase = this.testCaseRepository.findById(id).orElse(null);

        return TestCaseDto.builder()
                .idCase(testCase.getIdCase())
                .description(testCase.getDescription())
                .numberOfTries(testCase.getNumberOfTries())
                .passed(testCase.getPassed())
                .tested(testCase.getTested())
                .lastUpdate(testCase.getLastUpdate())
                .build();

    }

    @Override
    public TestCaseDto update(Long id, AddTestCaseRequestDto testCaseDto) {
        TestCase testCase = TestCase.builder()
                .idCase(id)
                .description(testCaseDto.getDescription())
                .tested(testCaseDto.getTested())
                .passed(testCaseDto.getPassed())
                .numberOfTries(testCaseDto.getNumberOfTries())
                .lastUpdate(LocalDate.now())
                .build();

        TestCase testCaseUpdated = this.testCaseRepository.save(testCase);

        return TestCaseDto.builder()
                .idCase(testCaseUpdated.getIdCase())
                .description(testCaseUpdated.getDescription())
                .numberOfTries(testCaseUpdated.getNumberOfTries())
                .passed(testCaseUpdated.getPassed())
                .tested(testCaseUpdated.getTested())
                .lastUpdate(testCaseUpdated.getLastUpdate())
                .build();
    }

    @Override
    public void delete(Long id) {
        this.testCaseRepository.deleteById(id);
    }
}
