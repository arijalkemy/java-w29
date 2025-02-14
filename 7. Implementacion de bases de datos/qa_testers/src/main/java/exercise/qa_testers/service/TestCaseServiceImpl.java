package exercise.qa_testers.service;

import exercise.qa_testers.dto.request.TestCaseRequestDto;
import exercise.qa_testers.model.TestCase;
import exercise.qa_testers.repository.TestCaseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TestCaseServiceImpl implements ITestCaseService{

    private TestCaseRepository testCaseRepository;

    public TestCaseServiceImpl(TestCaseRepository testCaseRepository){
        this.testCaseRepository = testCaseRepository;
    }

    @Override
    public List<TestCase> getAll(LocalDate lastUpdate) {
        return testCaseRepository.findByLastUpdateAfter(lastUpdate);
    }

    @Override
    public TestCase getById(Long id) {
        return testCaseRepository.findById(id).orElse(null);
    }

    @Override
    public TestCase update(TestCaseRequestDto testCaseDto, Long id) {
        ModelMapper mapper = new ModelMapper();
        TestCase testCase = mapper.map(testCaseDto, TestCase.class);
        testCase.setId_case(id);

        return this.testCaseRepository.save(testCase);
    }

    @Override
    public void delete(Long id) {
        this.testCaseRepository.deleteById(id);
    }

    @Override
    public void save(TestCaseRequestDto testCaseDto) {
        ModelMapper mapper = new ModelMapper();
        TestCase testCase = mapper.map(testCaseDto, TestCase.class);

        this.testCaseRepository.save(testCase);
    }
}
