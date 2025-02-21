package ejercicios_extra_p2.repositories;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import ejercicios_extra_p2.entities.Sale;

public interface ISaleRepository extends ElasticsearchRepository<Sale, String> {
  
}
