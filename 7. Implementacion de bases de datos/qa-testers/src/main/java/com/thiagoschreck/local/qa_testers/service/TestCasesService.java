package com.thiagoschreck.local.qa_testers.service;

import com.thiagoschreck.local.qa_testers.dto.request.CreateTestCaseRequestDTO;
import com.thiagoschreck.local.qa_testers.dto.request.UpdateTestCaseRequestDTO;
import com.thiagoschreck.local.qa_testers.dto.response.TestCaseResponseDTO;
import com.thiagoschreck.local.qa_testers.entity.TestCase;
import com.thiagoschreck.local.qa_testers.repository.ITestCasesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class TestCasesService {
    private final ITestCasesRepository repository;

    @Autowired
    public TestCasesService(ITestCasesRepository repository) {
        this.repository = repository;
    }

    public TestCaseResponseDTO crearTestCase(CreateTestCaseRequestDTO dto) {
        TestCase newTestCase = new TestCase(dto.description(), dto.tested(), dto.passed(), dto.numberOfTries(),
                dto.lastUpdate());
        TestCase testCase = repository.save(newTestCase);
        return map(testCase);
    }

    public TestCaseResponseDTO getTestCaseById(Long id) {
        return repository.findById(id)
                .map(this::map)
                .orElse(null);
    }

    public List<TestCaseResponseDTO> getAllTestCases(String date) {
        if (date == null) {
            return repository.findAll().stream()
                    .map(this::map)
                    .toList();
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate parsedDate = LocalDate.parse(date, formatter);
        return repository.findByLastUpdateAfter(parsedDate).stream()
                .map(this::map)
                .toList();
    }

    public TestCaseResponseDTO updateTestCaseById(Long id, UpdateTestCaseRequestDTO dto) {
        repository.deleteById(id);
        TestCase testCase = repository.save(map(dto));
        return map(testCase);
    }

    private TestCaseResponseDTO map(TestCase testCase) {
        return new TestCaseResponseDTO(
                testCase.getCaseId(),
                testCase.getDescription(),
                testCase.getTested(),
                testCase.getPassed(),
                testCase.getNumberOfTries(),
                testCase.getLastUpdate()
        );
    }

    private TestCase map(UpdateTestCaseRequestDTO testCase) {
        return new TestCase(
                testCase.caseId(),
                testCase.description(),
                testCase.tested(),
                testCase.passed(),
                testCase.numberOfTries(),
                testCase.lastUpdate()
        );
    }

    public TestCaseResponseDTO deleteTestCaseById(Long id) {
        Optional<TestCase> testCase = repository.findById(id);
        if (testCase.isEmpty()) {
            return null;
        }
        repository.deleteById(id);
        return map(testCase.get());
    }
}
