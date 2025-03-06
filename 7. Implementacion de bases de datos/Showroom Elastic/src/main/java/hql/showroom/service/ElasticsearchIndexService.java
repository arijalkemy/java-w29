package hql.showroom.service;

import hql.showroom.model.Clothing;
import hql.showroom.model.Sale;
import hql.showroom.repository.elasticsearch.IClothingRepository;
import hql.showroom.repository.elasticsearch.ISaleRepository;
import org.springframework.stereotype.Service;

@Service
public class ElasticsearchIndexService {

    private final IClothingRepository clothingRepository;
    private final ISaleRepository saleRepository;

    public ElasticsearchIndexService(IClothingRepository clothingRepository, ISaleRepository saleRepository) {
        this.clothingRepository = clothingRepository;
        this.saleRepository = saleRepository;
    }

    public void indexClothing(Clothing clothing) {
        clothingRepository.save(clothing);
    }

    public void indexSale(Sale sale) {
        saleRepository.save(sale);
    }
}
