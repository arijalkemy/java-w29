package com.mercadolibre.final_project_bootcamp_esp_32.unit.util;

import com.mercadolibre.final_project_bootcamp_esp_32.dtos.response.BatchStockDto;
import com.mercadolibre.final_project_bootcamp_esp_32.dtos.response.ProductBatchStockDto;
import com.mercadolibre.final_project_bootcamp_esp_32.dtos.response.SectionDto;
import com.mercadolibre.final_project_bootcamp_esp_32.entities.Product;
import com.mercadolibre.final_project_bootcamp_esp_32.entities.ProductBatch;
import com.mercadolibre.final_project_bootcamp_esp_32.entities.Section;
import com.mercadolibre.final_project_bootcamp_esp_32.entities.Warehouse;
import com.mercadolibre.final_project_bootcamp_esp_32.enums.ProductType;

import java.time.LocalDate;
import java.util.List;

public class TestUtils {

    public static ProductBatchStockDto createProductBatchStockDto() {
        ProductBatchStockDto dto = new ProductBatchStockDto();
        dto.setProductId(1);
        dto.setSection(new SectionDto(1, 1));
        dto.setBatchStock(List.of(
                new BatchStockDto(100, 10, LocalDate.now().plusWeeks(5)),
                new BatchStockDto(101, 15, LocalDate.now().plusWeeks(5))
        ));
        return dto;
    }

    public static List<ProductBatch> createProductBatches() {
        Product product = new Product();
        product.setId(1);
        product.setProductType(ProductType.FF);
        Warehouse warehouse = new Warehouse();
        warehouse.setWarehouseCode(1);
        Section section = new Section(1, warehouse, ProductType.FF);
        return List.of(
                new ProductBatch(1, 100, null, null, null, 10, null, LocalDate.now().plusWeeks(5), null, product, section, null),
                new ProductBatch(1, 101, null, null, null, 15, null, LocalDate.now().plusWeeks(5), null, product, section, null)
        );
    }
}
