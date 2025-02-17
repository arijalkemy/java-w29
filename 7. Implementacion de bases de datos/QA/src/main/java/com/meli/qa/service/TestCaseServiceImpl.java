package com.meli.qa.service;

import com.meli.qa.dto.request.AddTestCaseRequestDto;
import com.meli.qa.dto.request.TestCaseDto;
import com.meli.qa.model.TestCase;
import com.meli.qa.model.User;
import com.meli.qa.repository.ITestCaseRepository;
import com.meli.qa.repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
public class TestCaseServiceImpl implements ITestCaseService {

    private final ITestCaseRepository testCaseRepository;
    private final IUserRepository userRepository;

    public TestCaseServiceImpl(
            ITestCaseRepository testCaseRepository,
            IUserRepository userRepository
    ) {
        this.testCaseRepository = testCaseRepository;
        this.userRepository = userRepository;
    }

    @Override
    public TestCaseDto save(AddTestCaseRequestDto testCaseDto) {
        User pepito = userRepository.save(new User("Pepito"));

        TestCase testCase = TestCase.builder()
                .description(testCaseDto.getDescription())
                .tested(testCaseDto.getTested())
                .passed(testCaseDto.getPassed())
                .numberOfTries(testCaseDto.getNumberOfTries())
                .lastUpdate(LocalDate.now())
                .testDoneBy(Set.of(pepito))
                .build();

        TestCase testCaseCreated = this.testCaseRepository.save(testCase);

        return this.getTestCaseDto(testCaseCreated);
    }

    @Override
    public List<TestCaseDto> findAll() {
        return this.testCaseRepository.findAll().stream().map(
                testCase -> {
                    System.out.println(testCase);
                    return this.getTestCaseDto(testCase);
                }
        ).toList();
    }

    @Override
    public TestCaseDto findById(Long id) {
        TestCase testCase = this.testCaseRepository.findById(id).orElse(null);

        return this.getTestCaseDto(testCase);
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

        return this.getTestCaseDto(testCaseUpdated);
    }

    @Override
    public void delete(Long id) {
        this.testCaseRepository.deleteById(id);
    }

    private TestCaseDto getTestCaseDto(TestCase testCase) {
        return TestCaseDto.builder()
                .idCase(testCase.getIdCase())
                .description(testCase.getDescription())
                .numberOfTries(testCase.getNumberOfTries())
                .passed(testCase.getPassed())
                .tested(testCase.getTested())
                .lastUpdate(testCase.getLastUpdate())
                .build();
    }
}
