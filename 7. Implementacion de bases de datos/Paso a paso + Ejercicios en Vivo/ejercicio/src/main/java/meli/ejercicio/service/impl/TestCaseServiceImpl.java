package meli.ejercicio.service.impl;

import lombok.RequiredArgsConstructor;
import meli.ejercicio.dto.TestCaseDto;
import meli.ejercicio.model.TestCase;
import meli.ejercicio.repository.TestCaseJpaRepository;
import meli.ejercicio.service.TestCaseService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TestCaseServiceImpl implements TestCaseService {
    private final TestCaseJpaRepository testCaseJpaRepository;
    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public TestCaseDto getTestCaseById(Long id) {
        TestCase testCase = testCaseJpaRepository.findById(id).orElse(null);
        if (testCase == null) {
            throw new RuntimeException("Test case not found");
        } else {
            return modelMapper.map(testCase, TestCaseDto.class);
        }
    }

    @Override
    public TestCaseDto createTestCase(TestCaseDto testCaseDto) {
        TestCase testCase = modelMapper.map(testCaseDto, TestCase.class);
        TestCase testCaseSaved = testCaseJpaRepository.save(testCase);
        return modelMapper.map(testCaseSaved, TestCaseDto.class);
    }

    @Override
    public TestCaseDto updateTestCase(TestCaseDto testCaseDto, Long id) {
        TestCase testCase = testCaseJpaRepository.findById(id).orElse(null);
        if (testCase == null) {
            throw new RuntimeException("Test case not found");
        } else {
            testCase.setDescription(testCaseDto.getDescription());
            testCase.setTested(testCaseDto.getTested());
            testCase.setPassed(testCaseDto.getPassed());
            testCase.setNumberOfTries(testCaseDto.getNumberOfTries());
            testCase.setLastUpdate(testCaseDto.getLastUpdate());
            TestCase testCaseSaved = testCaseJpaRepository.save(testCase);
            return modelMapper.map(testCaseSaved, TestCaseDto.class);
        }
    }

    @Override
    public void deleteTestCase(Long id) {
        TestCase testCase = testCaseJpaRepository.findById(id).orElse(null);
        if (testCase == null) {
            throw new RuntimeException("Test case not found");
        } else {
            testCaseJpaRepository.delete(testCase);
        }
    }

    @Override
    public List<TestCaseDto> getAllTestCases() {
        List<TestCase> testCases = testCaseJpaRepository.findAll();

        return testCases.stream().map(testCase -> modelMapper.map
                (testCase, TestCaseDto.class)).toList();
    }

    @Override
    public List<TestCaseDto> getTestCasesByFecha(LocalDate fecha) {
        List<TestCase> testCases = testCaseJpaRepository.findAll();
        return testCases.stream().filter(testCase -> testCase.getLastUpdate().isAfter(fecha)).
                map(testCase -> modelMapper.map(testCase, TestCaseDto.class)).toList();
    }
}
