package com.example.qatester.service;

import com.example.qatester.dto.TestCaseDto;
import com.example.qatester.dto.out.MessageDto;
import com.example.qatester.model.TestCase;
import com.example.qatester.repository.ITestCaseRepository;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.PropertyValueException;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TestCaseService implements ITestCaseService{
    private final ITestCaseRepository iTestCaseRepository;
    private final ModelMapper modelMapper;

    public TestCaseService(ITestCaseRepository testCaseRepository){
        this.iTestCaseRepository = testCaseRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public MessageDto addTestCase(TestCaseDto testCaseDto) {
        try {
            iTestCaseRepository.save(modelMapper.map(testCaseDto, TestCase.class));
            return new MessageDto("Test case guardado con éxito.");
        } catch (PropertyValueException e){
            throw new DataIntegrityViolationException("Test case no guardado");
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar el test case: " + e.getMessage());
        }
    }

    @Override
    public List<TestCaseDto> searchTestCase() {
        return iTestCaseRepository.findAll().stream()
                .map(t -> modelMapper.map(t, TestCaseDto.class))
                .toList();
    }

    @Override
    public TestCaseDto searchTestCaseById(Long id) throws Exception {
        return iTestCaseRepository.findById(id)
                .map(t -> modelMapper.map(t, TestCaseDto.class))
                .orElseThrow(() -> new Exception("No se encontró TestCase con ese Id"));
    }

    @Override
    public TestCaseDto modifyById(Long id, TestCaseDto testCaseDto) throws Exception {
        TestCase testCase = iTestCaseRepository.findById(id)
                .orElseThrow(() -> new Exception("No se encontró TestCase con ese Id"));

        modelMapper.map(testCaseDto, testCase);
        testCase.setId(id);

        testCase = iTestCaseRepository.save(testCase);

        return modelMapper.map(testCase, TestCaseDto.class);
    }

    @Override
    public MessageDto deleteById(Long id) {
        if (!iTestCaseRepository.existsById(id)) {
            throw new EntityNotFoundException("No se encontró el id indicado.");
        }

        iTestCaseRepository.deleteById(id);
        return new MessageDto("Eliminado con éxito");
    }

    @Override
    public List<TestCaseDto> filterByDate(String lastUpdate) {
        return List.of();
    }
}
