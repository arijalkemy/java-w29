package ejerciciopractico3.QATesters.ejercicio_practico_3.QATesters.service;

import com.fasterxml.jackson.databind.JsonMappingException;
import ejerciciopractico3.QATesters.ejercicio_practico_3.QATesters.dto.MessageDto;
import ejerciciopractico3.QATesters.ejercicio_practico_3.QATesters.dto.TestCaseDto;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ITestCaseService {
    //crear
    public MessageDto saveTestCase(TestCaseDto testCaseDto);

    //obtener todos
    public List<TestCaseDto> findAllTestCases();

    //obtener por id
    public TestCaseDto findTestCaseById(Long id);

    //obtener por fecha de actualizacion
    public List<TestCaseDto> findAllTestCasesByUpdateDate(String date) throws ParseException;

    //actualizar un test casa
    public MessageDto updateTestCase(Long id, TestCaseDto testCaseDto) throws JsonMappingException;

    //eliminar un test case
    public MessageDto deleteTestCase(Long id);
}
