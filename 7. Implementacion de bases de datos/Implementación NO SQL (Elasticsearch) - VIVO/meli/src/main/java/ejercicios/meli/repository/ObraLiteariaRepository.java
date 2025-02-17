package ejercicios.meli.repository;

import ejercicios.meli.entity.ObraLitearia;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ObraLiteariaRepository extends ElasticsearchRepository<ObraLitearia, String> {
}
