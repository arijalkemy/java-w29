package meli.qatesters.service;

import meli.qatesters.dto.request.TestCaseRequestDTO;
import meli.qatesters.dto.response.TestCaseDTO;
import meli.qatesters.dto.response.TestCaseResponseDTO;
import meli.qatesters.model.TestCase;
import meli.qatesters.repository.ITestCaseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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
        return new TestCaseResponseDTO("Test case created", mapper.map(testCase, TestCaseDTO.class));
    }

    public List<TestCaseDTO> searchListTestCase(){
        return testCaseRepository.findAll()
                .stream()
                .map(testCase -> mapper.map(testCase, TestCaseDTO.class)).toList();
    }

    public TestCaseDTO searchTestCase(Long id){
        TestCase testCase = testCaseRepository.findById(id).orElse(null);
        return mapper.map(testCase, TestCaseDTO.class);
    }

    public TestCaseResponseDTO modifyTestCase(Long id, TestCaseRequestDTO testCaseRequestDTO){
        if(!testCaseRepository.existsById(id)){
            new TestCaseResponseDTO("No exists Testcase",null);
        }
        TestCase testCaseToDTOAEntity = mapper.map(testCaseRequestDTO, TestCase.class);
        testCaseToDTOAEntity.setId(id);
        testCaseRepository.save(testCaseToDTOAEntity);
        TestCaseDTO testCaseDTO = mapper.map(testCaseToDTOAEntity, TestCaseDTO.class);
        return new TestCaseResponseDTO("updated", testCaseDTO);
    }

    public TestCaseResponseDTO deleteTestCase(Long id){
        testCaseRepository.deleteById(id);
        return new TestCaseResponseDTO("Test case deleted", null);
    }

    public List<TestCaseDTO> listLastUpdatedTestCaseByAfterDate(LocalDate last_updated){
        return testCaseRepository.findTestCaseByLastUpdateAfter(last_updated)
                .stream()
                .map(testCase -> mapper.map(testCase, TestCaseDTO.class))
                .toList();
    }
}
