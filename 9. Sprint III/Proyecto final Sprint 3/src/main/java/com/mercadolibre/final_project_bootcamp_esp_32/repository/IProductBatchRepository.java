package com.mercadolibre.final_project_bootcamp_esp_32.repository;

import com.mercadolibre.final_project_bootcamp_esp_32.entities.ProductBatch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductBatchRepository extends JpaRepository<ProductBatch, Integer> {
   boolean existsProductBatchByBatchNumber(Integer batchNumber);

    ProductBatch findProductBatchByBatchNumber(Integer batchNumber);
}
