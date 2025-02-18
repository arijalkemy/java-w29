package ejerciciopractico6.productos.ejercicio_practico_6.productos.service;
import ejerciciopractico6.productos.ejercicio_practico_6.productos.dto.EmpleadosDto;
import ejerciciopractico6.productos.ejercicio_practico_6.productos.dto.MessageDto;
import ejerciciopractico6.productos.ejercicio_practico_6.productos.model.Empleados;
import ejerciciopractico6.productos.ejercicio_practico_6.productos.repository.IEmpleadosRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpleadosServices implements IEmpleadosService {

    private final IEmpleadosRepository repository;
    private ModelMapper modelMapper;

    public EmpleadosServices(IEmpleadosRepository repository) {
        this.repository = repository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public MessageDto saveEmpleado(EmpleadosDto empleadosDto) {
        Empleados empleado = modelMapper.map(empleadosDto, Empleados.class);
        empleado.setId(null);
        repository.save(empleado);
        return new MessageDto("Empleado guardado correctamente");
    }

    @Override
    public MessageDto updateEmpleado(String id,EmpleadosDto empleadosDto) {
        Empleados empleado = repository.findById(id).orElse(null);
        modelMapper.map(empleadosDto, empleado);
        repository.save(empleado);
        return new MessageDto("Empleado actualizado correctamente");
    }

    @Override
    public List<EmpleadosDto> findAllEmpleados() {
        Page<Empleados> empleadosPage = repository.findAll(Pageable.unpaged()); // Obtener todas las obras sin paginación
        List<Empleados> empleados = empleadosPage.getContent();
        return empleados.stream().map(empleado -> modelMapper.map(empleado, EmpleadosDto.class)).collect(Collectors.toList());
    }
}
