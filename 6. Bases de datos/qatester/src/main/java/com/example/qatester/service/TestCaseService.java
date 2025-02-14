package com.example.qatester.service;

import com.example.qatester.dto.TestCaseDto;
import com.example.qatester.dto.response.ApiResponseDto;
import com.example.qatester.entity.TestCase;
import com.example.qatester.repository.TestCaseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestCaseService implements ITestCaseService{

    private ModelMapper modelMapper;
    private final TestCaseRepository testCaseRepository;

    public TestCaseService(TestCaseRepository testCaseRepository) {
        this.testCaseRepository = testCaseRepository;
        modelMapper = new ModelMapper();
    }

    @Override
    public ApiResponseDto createTestCase(TestCaseDto testCaseDto) {
        TestCase testCase = modelMapper.map(testCaseDto,TestCase.class);
        testCaseRepository.save(testCase);

        return new ApiResponseDto("Se creo correctamente el Caso de Test");
    }

    @Override
    public TestCaseDto getTestCaseById(Long id) {
        Optional<TestCase> testCase = testCaseRepository.findById(id);
        if(testCase.isPresent()){
            return modelMapper.map(testCase,TestCaseDto.class);
        }
        return null;
    }

    @Override
    public List<TestCaseDto> getAllTestCase() {
         List<TestCase> listTestCase = testCaseRepository.findAll();
         return listTestCase.stream().map(testCase -> modelMapper.map(testCase,TestCaseDto.class)).toList();
    }

    @Override
    public ApiResponseDto updateTestCase(Long id_modificar, TestCaseDto testCase_modif) {
        TestCase testCase = testCaseRepository.findById(id_modificar).orElseThrow(() -> new RuntimeException("No se encontro el id"));

        testCase.setDescription(testCase_modif.getDescription());
        testCase.setNumberOfTries(testCase_modif.getNumberOfTries());
        testCase.setLastUpdate(testCase_modif.getLastUpdate());
        testCase.setPassed(testCase.isPassed());
        testCase.setTested(testCase.isTested());

        testCaseRepository.save(testCase);

        return new ApiResponseDto("Se actualizaron los datos correctamente");
    }

    @Override
    public ApiResponseDto deleteTestCaseById(Long id) {
        if(testCaseRepository.existsById(id)){
            testCaseRepository.deleteById(id);
            return new ApiResponseDto("Se borro correctamente el Caso de Test");
        }
        throw new RuntimeException("No se encontro el id");
    }

    //Admitir métodos de búsqueda personalizados según determinados filtros.
}
