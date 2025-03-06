package hql.showroom.controller;

import hql.showroom.model.Clothing;
import hql.showroom.model.Sale;
import hql.showroom.repository.elasticsearch.IClothingRepository;
import hql.showroom.repository.elasticsearch.ISaleRepository;
import hql.showroom.service.ElasticsearchIndexService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/elastic")
public class ElasticsearchController {

    private final ElasticsearchIndexService elasticsearchService;
    private final IClothingRepository clothingRepository;
    private final ISaleRepository saleRepository;

    public ElasticsearchController(ElasticsearchIndexService elasticsearchService, IClothingRepository clothingRepository, ISaleRepository saleRepository) {
        this.elasticsearchService = elasticsearchService;
        this.clothingRepository = clothingRepository;
        this.saleRepository = saleRepository;
    }

    @PostMapping("/clothing")
    public ResponseEntity<String> indexClothing(@RequestBody Clothing clothing) {
        elasticsearchService.indexClothing(clothing);
        return ResponseEntity.ok("Clothing indexed successfully.");
    }

    @PostMapping("/sales")
    public ResponseEntity<String> indexSale(@RequestBody Sale sale) {
        elasticsearchService.indexSale(sale);
        return ResponseEntity.ok("Sale indexed successfully.");
    }

    @GetMapping("/clothing/search")
    public ResponseEntity<List<Clothing>> searchClothingByName(@RequestParam String name) {
        return ResponseEntity.ok(clothingRepository.findByNameContaining(name));
    }

    @GetMapping("/sales/search")
    public ResponseEntity<List<Sale>> searchSalesByDate(@RequestParam String date) {
        return ResponseEntity.ok(saleRepository.findByDate(LocalDate.parse(date)));
    }
}
