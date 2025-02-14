package com.mercadolibre.bootcamp.qatesters.service;

import com.mercadolibre.bootcamp.qatesters.dto.TestCaseDto;
import com.mercadolibre.bootcamp.qatesters.model.TestCase;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    /*
    Por otro lado, la API debe ser capaz de:
        Crear, recuperar, actualizar y eliminar casos de prueba.
        Admitir métodos de búsqueda personalizados según determinados filtros.
    */

    List<TestCaseDto> findAll();
    TestCaseDto save(TestCaseDto testCase);
    TestCaseDto findById(Long id);
    void update(Long id, TestCaseDto testCase);
    void delete(Long id);
    List<TestCaseDto> findAllFiltered(LocalDate lastUpdate);

}
