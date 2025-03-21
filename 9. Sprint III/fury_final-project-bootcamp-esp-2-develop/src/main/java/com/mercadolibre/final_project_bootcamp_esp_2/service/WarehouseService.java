package com.mercadolibre.final_project_bootcamp_esp_2.service;

import com.mercadolibre.final_project_bootcamp_esp_2.dto.BatchInfo;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.BatchSortType;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.ProductBatchListResponse;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.SectionInfo;
import com.mercadolibre.final_project_bootcamp_esp_2.exceptions.ResourceNotFoundException;
import com.mercadolibre.final_project_bootcamp_esp_2.model.Batch;
import com.mercadolibre.final_project_bootcamp_esp_2.model.Product;
import com.mercadolibre.final_project_bootcamp_esp_2.model.Sector;
import com.mercadolibre.final_project_bootcamp_esp_2.model.Warehouse;
import com.mercadolibre.final_project_bootcamp_esp_2.model.util.ProductType;
import com.mercadolibre.final_project_bootcamp_esp_2.repository.BatchRepository;
import com.mercadolibre.final_project_bootcamp_esp_2.repository.WarehouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WarehouseService implements IWarehouseService{

    private final WarehouseRepository warehouseRepository;
    private final BatchRepository batchRepository;

    @Override
    public ProductBatchListResponse getProductBatchesByProductIdSortedBy(Long supervisorId, Long productId, BatchSortType sortType) {
        Warehouse warehouse = getWarehouseBySupervisorId(supervisorId);
        Product product = getProductDetails(productId, warehouse.getId());
        Sector sector = getSectionForProductType(warehouse.getId(), product.getType());
        List<Batch> batches = getBatchesFromSectionAndProduct(sector.getId(), product.getId(), sortType);
        return buildProductBatchListResponse(batches, productId, sector.getId(), warehouse.getId());

    }

    private Warehouse getWarehouseBySupervisorId(Long supervisorId) {
        return warehouseRepository
                .findBySupervisorId(supervisorId)
                .orElseThrow(() -> new ResourceNotFoundException("Warehouse not found for supervisor id " + supervisorId));
    }

    private Sector getSectionForProductType(Long id, ProductType type) {
        return warehouseRepository
                .findWarehouseSectionsForProductType(id, type)
                .orElseThrow(() -> new ResourceNotFoundException("Warehouse section not found for id " + id + " and product type " + type.name()));
    }

    private Product getProductDetails(Long productId, Long warehouseId) {
        return batchRepository
                .fetchProduct(productId, warehouseId)
                .orElseThrow(() -> new ResourceNotFoundException("Product details not found for product id " + productId));
    }

    private List<Batch> getBatchesFromSectionAndProduct(Long sectorId, Long productId, BatchSortType sortType) {
        List<Batch> batches;

        if (sortType != null) {
            batches = switch (sortType) {
                case L -> batchRepository.findBatchBySectorIdSortedByBatchNumber(sectorId, productId);
                case C -> batchRepository.findBatchBySectorIdSortedByCurrentQuantity(sectorId, productId);
                case F -> batchRepository.findBatchBySectorIdSortedByDueDate(sectorId, productId);
            };
        } else {
            batches = batchRepository.findBatchBySectorIdAndProductId(sectorId, productId);
        }

        if (batches.isEmpty()) {
            throw new ResourceNotFoundException("No batch found for section id " + sectorId + " and product id " + productId);
        }

        return batches;

    }

    private ProductBatchListResponse buildProductBatchListResponse(List<Batch> batches, Long productId, Long sectorId, Long warehouseId) {
        return new ProductBatchListResponse(
                new SectionInfo(sectorId, warehouseId),
                productId,
                batches
                        .stream()
                        .map(it -> new BatchInfo(
                                it.getBatchNumber(),
                                it.getCurrentQuantity(),
                                it.getDueDate()))
                        .toList()
        );
    }
}
