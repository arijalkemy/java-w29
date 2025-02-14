package jpa.qa_testers.service;

import jpa.qa_testers.entity.TestCase;
import jpa.qa_testers.entity.response.AllTestsCasesDTO;
import jpa.qa_testers.entity.response.ResponseWrapperDTO;
import jpa.qa_testers.entity.resquest.TestCaseRequestDTO;
import jpa.qa_testers.repository.ITestCaseRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class TestCaseServiceImpl implements ITestCaseService {

    @Autowired
    private ITestCaseRepository testCaseRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public ResponseWrapperDTO createTestCase(TestCaseRequestDTO testCaseRequestDTO) {
        TestCase testCase = modelMapper.map(testCaseRequestDTO, TestCase.class);
        testCaseRepository.save(testCase);

        return ResponseWrapperDTO.builder().message("Created").build();
    }

    @Override
    public ResponseWrapperDTO updateTestCase(Long caseId, TestCaseRequestDTO testCaseRequestDTO) {
        TestCase testCase = testCaseRepository.findById(caseId).orElse(null);
        if (testCase == null) {
            return ResponseWrapperDTO.builder().message("Not found").build();
        }
        Long id = testCase.getIdCase();
        testCase = modelMapper.map(testCaseRequestDTO, TestCase.class);
        testCase.setIdCase(id);
        testCaseRepository.save(testCase);

        return ResponseWrapperDTO.builder().message("Updated").build();
    }

    @Override
    public ResponseWrapperDTO deleteTestCase(Long caseId) {
        TestCase testCase = testCaseRepository.findById(caseId).orElse(null);
        if (testCase == null) {
            return ResponseWrapperDTO.builder().message("Not found").build();
        }
        testCaseRepository.delete(testCase);

        return ResponseWrapperDTO.builder().message("Deleted").build();
    }

    @Override
    public TestCaseRequestDTO getTestCase(Long caseId) {
        TestCase testCase = testCaseRepository.findById(caseId).orElse(null);
        if (testCase == null) {
            return null;
        }

        return modelMapper.map(testCase, TestCaseRequestDTO.class);
    }

    @Override
    public AllTestsCasesDTO getAllTestCases() {
        List<TestCase> testCases = testCaseRepository.findAll();
        List<TestCaseRequestDTO> testCaseRequestDTOs = testCases.stream()
                .map(testCase -> modelMapper.map(testCase, TestCaseRequestDTO.class))
                .collect(Collectors.toList());

        return AllTestsCasesDTO.builder().testCases(testCaseRequestDTOs).build();
    }

    @Override
    public AllTestsCasesDTO filterByDate(String date) {
        LocalDate formatedDate = LocalDate.parse(date);
        Optional<List<TestCase>> testCases = testCaseRepository.findTestCasesByLastUpdateIs(formatedDate);
        if (testCases.isEmpty()) {
            return null;
        }
        List<TestCaseRequestDTO> testCaseRequestDTOs = testCases.get().stream()
                .map(testCase -> modelMapper.map(testCase, TestCaseRequestDTO.class))
                .collect(Collectors.toList());

        return AllTestsCasesDTO.builder().testCases(testCaseRequestDTOs).build();
    }

    @Override
    public AllTestsCasesDTO filterIsTested() {
        Optional<List<TestCase>> testCases = testCaseRepository.findTestCasesByTestedIsTrue();
        if (testCases.isEmpty()) {
            return null;
        }
        List<TestCaseRequestDTO> testCaseRequestDTOs = testCases.get().stream()
                .map(testCase -> modelMapper.map(testCase, TestCaseRequestDTO.class))
                .collect(Collectors.toList());

        return AllTestsCasesDTO.builder().testCases(testCaseRequestDTOs).build();
    }
}