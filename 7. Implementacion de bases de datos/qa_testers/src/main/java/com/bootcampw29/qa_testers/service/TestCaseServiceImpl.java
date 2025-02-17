package com.bootcampw29.qa_testers.service;

import com.bootcampw29.qa_testers.constants.Messages;
import com.bootcampw29.qa_testers.dto.request.TestCaseRequestDTO;
import com.bootcampw29.qa_testers.dto.response.TestCaseCreatedDTO;
import com.bootcampw29.qa_testers.dto.response.TestCaseResponseDTO;
import com.bootcampw29.qa_testers.exception.NotFoundException;
import com.bootcampw29.qa_testers.model.TestCase;
import com.bootcampw29.qa_testers.repository.TestCaseRepository;
import com.bootcampw29.qa_testers.specification.TestCaseSpecification;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.LongAccumulator;

@Service
public class TestCaseServiceImpl implements TestCaseService {

    private final TestCaseRepository testCaseRepository;
    private final ModelMapper modelMapper;

    public TestCaseServiceImpl(TestCaseRepository testCaseRepository) {
        this.testCaseRepository = testCaseRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public TestCaseCreatedDTO createTestCase(TestCaseRequestDTO testCaseRequest) {
        TestCase testCase = modelMapper.map(testCaseRequest, TestCase.class);
        testCase.setLastUpdate(LocalDate.now());
        TestCase savedTestCase = testCaseRepository.save(testCase);
        return new TestCaseCreatedDTO(savedTestCase.getId());
    }

    @Override
    public TestCaseResponseDTO modifyTestCase(Long id, TestCaseRequestDTO testCaseRequest) {
        TestCase testCaseFound = testCaseRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format(Messages.TEST_CASE_NOT_FOUND, id)));
       modelMapper.map(testCaseRequest, testCaseFound);
       testCaseFound.setLastUpdate(LocalDate.now());
       TestCase updatedTestCase = testCaseRepository.save(testCaseFound);
       return modelMapper.map(updatedTestCase, TestCaseResponseDTO.class);
    }

    @Override
    public List<TestCaseResponseDTO> searchAllTestCases(Optional<LocalDate> lastUpdate) {
        Specification<TestCase> specs = Specification.where(TestCaseSpecification.withLastUpdateAfter(lastUpdate));
        List<TestCase> testCases =testCaseRepository.findAll(specs);
        return testCases.stream()
                .map(tc -> modelMapper.map(tc, TestCaseResponseDTO.class))
                .toList();
    }

    @Override
    public TestCaseResponseDTO searchTestCaseById(Long id) {
        TestCase testCaseFound = testCaseRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format(Messages.TEST_CASE_NOT_FOUND, id)));
        return modelMapper.map(testCaseFound, TestCaseResponseDTO.class);
    }

    @Override
    public void deleteTestCase(Long id) {
        TestCase testCaseFound = testCaseRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format(Messages.TEST_CASE_NOT_FOUND, id)));
        testCaseRepository.delete(testCaseFound);
    }
}
