package ejerciciopractico3.QATesters.ejercicio_practico_3.QATesters.service;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ejerciciopractico3.QATesters.ejercicio_practico_3.QATesters.dto.MessageDto;
import ejerciciopractico3.QATesters.ejercicio_practico_3.QATesters.dto.TestCaseDto;
import ejerciciopractico3.QATesters.ejercicio_practico_3.QATesters.model.TestCase;
import ejerciciopractico3.QATesters.ejercicio_practico_3.QATesters.repository.ITestCaseRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestCaseService implements ITestCaseService {

    private final ITestCaseRepository repository;

    ObjectMapper mapper;

    public TestCaseService(ITestCaseRepository repository) {
        this.repository = repository;
        this.mapper = new ObjectMapper();
    }

    @Override
    public MessageDto saveTestCase(TestCaseDto testCaseDto) {
        TestCase testCase = mapper.convertValue(testCaseDto, TestCase.class);
        testCase.setIdCase(null);
        TestCase testSaved = repository.save(testCase);
        return new MessageDto("TestCase saved successfully , with id: "  + testSaved.getIdCase());
    }

    @Override
    public List<TestCaseDto> findAllTestCases() {
        List<TestCase> testCases = repository.findAll();
        return testCases.stream()
                .map(testCase -> mapper.convertValue(testCase, TestCaseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public TestCaseDto findTestCaseById(Long id) {
        TestCase testCase = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("el test con id : " +id + " no fue encontrado"));
        return mapper.convertValue(testCase, TestCaseDto.class) ;
    }

    @Override
    public List<TestCaseDto> findAllTestCasesByUpdateDate(String dateString) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse(dateString);
        List<TestCase> testCases = repository.findTestCasesByLastUpdateAfter(date);
        return testCases.stream()
                .map(test -> mapper.convertValue(test,TestCaseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public MessageDto updateTestCase(Long id, TestCaseDto testCaseDto) throws JsonMappingException {
        TestCase testforUpdate = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("el test con id : " +id + " no fue encontrado"));
        mapper.updateValue(testforUpdate,testCaseDto);
        TestCase testUpdated =repository.save(testforUpdate);
        return new MessageDto("TestCase updated successfully , with id: " + testUpdated.getIdCase());
    }

    @Override
    public MessageDto deleteTestCase(Long id) {
        TestCase testCase = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("el test con id : " +id + " no fue encontrado"));
        repository.delete(testCase);
        return new MessageDto("TestCase deleted successfully , with id: " + id);
    }

}
