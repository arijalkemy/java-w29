package ejercicios.meli.repository;

import ejercicios.meli.entity.ObraLitearia;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ObraLiteariaRepository extends ElasticsearchRepository<ObraLitearia, String> {
    List<ObraLitearia> findByAutor(String autor);

    List<ObraLitearia> findByNombre(String nombre);

    List<ObraLitearia> findTop5ByOrderByCantidadPaginasDesc();

    List<ObraLitearia> findByAnioPublicacionBefore(Integer anio);

    List<ObraLitearia> findByEditorial(String editorial);
}
