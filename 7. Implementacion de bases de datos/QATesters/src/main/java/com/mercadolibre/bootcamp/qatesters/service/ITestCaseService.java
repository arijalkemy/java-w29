package com.mercadolibre.bootcamp.qatesters.service;

import com.mercadolibre.bootcamp.qatesters.dto.TestCaseDto;
import com.mercadolibre.bootcamp.qatesters.dto.response.MessageDto;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    /*
    Por otro lado, la API debe ser capaz de:
        Crear, recuperar, actualizar y eliminar casos de prueba.
        Admitir métodos de búsqueda personalizados según determinados filtros.
    */

    List<TestCaseDto> findAll(LocalDate lastUpdate);
    TestCaseDto save(TestCaseDto testCase);
    TestCaseDto findById(Long id);
    MessageDto update(Long id, TestCaseDto testCaseDto);
    MessageDto delete(Long id);

}
