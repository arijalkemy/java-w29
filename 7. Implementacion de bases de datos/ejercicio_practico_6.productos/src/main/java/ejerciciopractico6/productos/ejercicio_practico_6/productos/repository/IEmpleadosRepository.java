package ejerciciopractico6.productos.ejercicio_practico_6.productos.repository;

import ejerciciopractico6.productos.ejercicio_practico_6.productos.model.Empleados;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmpleadosRepository extends ElasticsearchRepository<Empleados, String> {
}
