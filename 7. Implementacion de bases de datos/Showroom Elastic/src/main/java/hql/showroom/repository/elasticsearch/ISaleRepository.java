package hql.showroom.repository.elasticsearch;

import hql.showroom.model.Sale;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ISaleRepository extends ElasticsearchRepository<Sale, String> {
    List<Sale> findByDate(LocalDate date);
    List<Sale> findByPaymentMethod(String paymentMethod);
}