package meli.qatesters.service;

import meli.qatesters.dto.request.TestCaseRequestDTO;
import meli.qatesters.dto.response.TestCaseDTO;
import meli.qatesters.dto.response.TestCaseResponseDTO;
import meli.qatesters.model.TestCase;
import meli.qatesters.repository.ITestCaseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.time.LocalDate;
import java.util.List;

@Service
public class TestCaseService {

    ITestCaseRepository testCaseRepository;
    ModelMapper mapper;

    public TestCaseService(ITestCaseRepository testCaseRepository) {
        this.testCaseRepository = testCaseRepository;
        this.mapper = new ModelMapper();
    }

    public TestCaseResponseDTO saveTestCase(TestCaseRequestDTO testCaseRequestDTO){
        TestCase testCase = mapper.map(testCaseRequestDTO, TestCase.class);
        testCaseRepository.save(testCase);
        return new TestCaseResponseDTO("Test case created", testCase);
    }

    public List<TestCaseDTO> getListTestCase(){
        return testCaseRepository.findAll()
                .stream()
                .map(testCase -> mapper.map(testCase, TestCaseDTO.class)).toList();
    }

    public TestCaseDTO getTestCase(Long id){
        TestCase testCase = testCaseRepository.findById(id).orElse(null);
        return mapper.map(testCase, TestCaseDTO.class);
    }

    public TestCaseResponseDTO updateTestCase(Long id, TestCaseRequestDTO testCaseRequestDTO){
        if(!testCaseRepository.existsById(id)){
            return new TestCaseResponseDTO("Testcase does not exist",null);
        }
        TestCase testCase = mapper.map(testCaseRequestDTO, TestCase.class);
        testCase.setId_case(id);
        return new TestCaseResponseDTO("Testcase updated", testCaseRepository.save(testCase));
    }

    public TestCaseResponseDTO deleteTestCase(Long id){
        testCaseRepository.deleteById(id);
        return new TestCaseResponseDTO("Test case deleted", null);
    }

    public List<TestCaseDTO> listLastUpdatedTestCaseByAfterDate(LocalDate last_updated){
        return testCaseRepository.findTestCasesByLastUpdateAfter(last_updated)
                .stream()
                .map(testCase -> mapper.map(testCase, TestCaseDTO.class))
                .toList();
    }
}
