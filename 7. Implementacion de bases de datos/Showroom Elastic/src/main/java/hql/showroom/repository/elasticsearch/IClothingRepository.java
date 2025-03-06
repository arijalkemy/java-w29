package hql.showroom.repository.elasticsearch;

import hql.showroom.model.Clothing;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IClothingRepository extends ElasticsearchRepository<Clothing, String> {
    List<Clothing> findByNameContaining(String name);
    List<Clothing> findByBrand(String brand);
}