package exercise.es_obras_literarias.repository;

import exercise.es_obras_literarias.domain.Obra;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ObraRepository extends ElasticsearchRepository<Obra, Long> {
    List<Obra> findByAutor(String author);
    List<Obra> findTop5ByOrderByCantidadPaginasDesc();
    List<Obra> findByAnioPublicacionBefore(Integer anioPublicacionBefore);
    List<Obra> findByEditorial(String editorial);
    List<Obra> findByNombreContaining(String nombre);
}
