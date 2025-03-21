package com.mercadolibre.final_project_bootcamp_esp_32.util;

import com.mercadolibre.final_project_bootcamp_esp_32.dtos.request.ProductDTO;
import com.mercadolibre.final_project_bootcamp_esp_32.dtos.response.WarehouseStockDto;
import com.mercadolibre.final_project_bootcamp_esp_32.dtos.request.InboundOrderDto;
import com.mercadolibre.final_project_bootcamp_esp_32.dtos.response.*;
import com.mercadolibre.final_project_bootcamp_esp_32.entities.InboundOrder;
import com.mercadolibre.final_project_bootcamp_esp_32.entities.ProductBatch;
import com.mercadolibre.final_project_bootcamp_esp_32.entities.ProductPurchaseOrder;
import com.mercadolibre.final_project_bootcamp_esp_32.entities.Section;
import com.mercadolibre.final_project_bootcamp_esp_32.projection.ProductProjection;
import com.mercadolibre.final_project_bootcamp_esp_32.projection.Top5MostSoldProductProjection;
import com.mercadolibre.final_project_bootcamp_esp_32.projection.WarehouseStock;

import java.util.List;

public final class MappingUtil {
    public static List<BatchDueDateDTO> mapToBatchDueDateDTOs(List<ProductBatch> productBatches) {
        return productBatches.stream()
                .map(batch -> {
                    return new BatchDueDateDTO(
                            batch.getBatchNumber(),
                            batch.getProduct().getId(),
                            batch.getProduct().getProductType().ordinal(),
                            batch.getCurrentQuantity(),
                            batch.getDueDate()
                    );
                })
                .toList();
    }

    public static ProductBatchStockDto toProductBatchStockDto(List<ProductBatch> productBatches){
        ProductBatch firstBatch = productBatches.get(0);
        Section section = firstBatch.getSection();

        ProductBatchStockDto dto = new ProductBatchStockDto();
        dto.setProductId(firstBatch.getProduct().getId());
        SectionDto sectionDto = new SectionDto(section.getSectionCode(), section.getWarehouse().getWarehouseCode());
        dto.setSection(sectionDto);
        List<BatchStockDto> batchStockDtos = toBatchStockDtos(productBatches);
        dto.setBatchStock(batchStockDtos);
        return dto;
    }

    public static List<BatchStockDto> toBatchStockDtos(List<ProductBatch> productBatches){
        return productBatches.stream().map(batch -> {
            BatchStockDto batchStockDto = new BatchStockDto();
            batchStockDto.setBatchNumber(batch.getBatchNumber());
            batchStockDto.setCurrentQuantity(batch.getCurrentQuantity());
            batchStockDto.setDueDate(batch.getDueDate());
            return batchStockDto;
        }).toList();
    }

    public static InboundOrder mapInboundOrderDtoToInboundOrder(InboundOrderDto inboundOrderDto){

        //Transformo mi batchStockDto a batch stock
        List<ProductBatch> batchStock = inboundOrderDto.getBatchStock().stream().map(dto ->
                new ProductBatch(
                        null,
                        dto.getBatchNumber(),
                        dto.getCurrentTemperature(),
                        dto.getMinimumTemperature(),
                        dto.getInitialQuantity(),
                        dto.getCurrentQuantity(),
                        dto.getManufacturingDate(),
                        dto.getDueDate(),
                        dto.getManufacturingTime(),
                        null,
                        new Section(inboundOrderDto.getSection().getSectionCode(), null, null),
                        null
                )
        ).toList();

        return new InboundOrder(
                null,
                inboundOrderDto.getOrderNumber(),
                inboundOrderDto.getOrderDate(),
                new Section(inboundOrderDto.getSection().getSectionCode(), null, null),
                null
        );
    }

    public static List<ProductBatchDto> mapToProductBatchDtoList(List<ProductBatch> productBatches){
        return productBatches.stream().map(p -> new ProductBatchDto(
                        p.getBatchNumber(),
                        p.getProduct().getId(),
                        p.getCurrentTemperature(),
                        p.getMinimumTemperature(),
                        p.getInitialQuantity(),
                        p.getCurrentQuantity(),
                        p.getManufacturingDate(),
                        p.getManufacturingTime(),
                        p.getDueDate()
                )
        ).toList();
    }

    public static ProductDTO productProjectionToProductDTO(ProductProjection productProjection) {
        return new ProductDTO(
                productProjection.getIdProduct().intValue(),
                productProjection.getQuantity() == null ? 0 : productProjection.getQuantity()
        );
    }

    public static ProductsPurchaseOrderDto productPurchaseOrderToProductsPurchaseOrderDto(List<ProductPurchaseOrder> productList) {
        List<ProductResponseDto> responseList = productList.stream()
                .map(product -> {
                    return new ProductResponseDto(
                            product.getProduct().getId(),
                            product.getProduct().getName(),
                            product.getQuantity()
                    );
                })
                .toList();
        return new ProductsPurchaseOrderDto(responseList);
    }

    public static WarehouseStockDto warehouseStockToWarehouseStockDto(WarehouseStock warehouseStock) {
        return new WarehouseStockDto(
                warehouseStock.getWarehouseCode().intValue(),
                warehouseStock.getTotalQuantity() == null ? 0 : warehouseStock.getTotalQuantity()
        );
    }

    public static ProductMostOrdererDto top5MostSoldProductProjectionToProductMostOrdererDto(Top5MostSoldProductProjection product) {
        return new ProductMostOrdererDto(
                            product.getProductId(),
                            product.getProductName(),
                            product.getTotalSold()
        );
    }
}
