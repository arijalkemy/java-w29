package ejerciciopractico6.productos.ejercicio_practico_6.productos.service;

import ejerciciopractico6.productos.ejercicio_practico_6.productos.dto.EmpleadosDto;
import ejerciciopractico6.productos.ejercicio_practico_6.productos.dto.MessageDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IEmpleadosService {
    public MessageDto saveEmpleado(EmpleadosDto empleadosDto);
    public MessageDto updateEmpleado(String id,EmpleadosDto empleadosDto);
    public List<EmpleadosDto> findAllEmpleados();
}
