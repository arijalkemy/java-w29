package com.mercadolibre.final_project_bootcamp_esp_2.util;

import com.mercadolibre.final_project_bootcamp_esp_2.dto.BatchDTO;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.request.OrderRequestDTO;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.request.ProductRequestDTO;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.request.PurchaseOrderRequestDTO;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.response.BatchStockListDTO;
import com.mercadolibre.final_project_bootcamp_esp_2.model.Batch;
import com.mercadolibre.final_project_bootcamp_esp_2.model.Product;
import com.mercadolibre.final_project_bootcamp_esp_2.model.User;
import com.mercadolibre.final_project_bootcamp_esp_2.model.util.ProductType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestUtils {

    public static PurchaseOrderRequestDTO createValidPurchaseOrderRequestDTO() {
        ProductRequestDTO productRequestDTO = new ProductRequestDTO();
        productRequestDTO.setProductId(1);
        productRequestDTO.setQuantity(10);

        OrderRequestDTO orderRequestDTO = new OrderRequestDTO();
        orderRequestDTO.setProducts(List.of(productRequestDTO));

        PurchaseOrderRequestDTO purchaseOrderRequestDTO = new PurchaseOrderRequestDTO();
        purchaseOrderRequestDTO.setOrderRequestDTO(orderRequestDTO);

        return purchaseOrderRequestDTO;
    }

    public static PurchaseOrderRequestDTO createExcessQuantityPurchaseOrderRequestDTO() {
        ProductRequestDTO productRequestDTO = new ProductRequestDTO();
        productRequestDTO.setProductId(1);
        productRequestDTO.setQuantity(100);

        OrderRequestDTO orderRequestDTO = new OrderRequestDTO();
        orderRequestDTO.setBuyerId(1);
        orderRequestDTO.setProducts(List.of(productRequestDTO));

        PurchaseOrderRequestDTO purchaseOrderRequestDTO = new PurchaseOrderRequestDTO();
        purchaseOrderRequestDTO.setOrderRequestDTO(orderRequestDTO);

        return purchaseOrderRequestDTO;
    }

    public static User supervisor() {
        User supervisor = new User();
        supervisor.setId(1L);
        return supervisor;
    }

    public static Batch dueDateBatch(LocalDate date) {
        Batch batch = new Batch();
        batch.setDueDate(date);
        return batch;
    }

    public static BatchDTO dueDateBatchDTO(LocalDate date) {
        BatchDTO batchDTO = new BatchDTO();
        batchDTO.setDue_date(date);
        return batchDTO;
    }

    public static BatchStockListDTO expectedBatchStockDTO(LocalDate date) {
        return new BatchStockListDTO(List.of(dueDateBatchDTO(date)));
    }

    public static List<Batch> categoryBatchStockAsc(ProductType category, LocalDate startDate, LocalDate endDate) {
        Product freshProduct = new Product();
        freshProduct.setType(category);

        Batch fstBatch = new Batch();
        fstBatch.setDueDate(endDate);
        fstBatch.setProduct(freshProduct);

        Batch sndBatch = new Batch();
        sndBatch.setDueDate(startDate);
        sndBatch.setProduct(freshProduct);

        return List.of(sndBatch, fstBatch);
    }

    public static List<Batch> categoryBatchStockDesc(ProductType category, LocalDate startDate, LocalDate endDate) {
        List<Batch> descBatches = new ArrayList<>(categoryBatchStockAsc(category, startDate, endDate));
        Collections.reverse(descBatches);
        return descBatches;
    }

    public static BatchStockListDTO categoryBatchStockDTOAsc(ProductType category, LocalDate startDate, LocalDate endDate) {
        BatchDTO fstBatchDTO = new BatchDTO();
        fstBatchDTO.setDue_date(endDate);
        fstBatchDTO.setProduct_type_id(category.ordinal());

        BatchDTO sndBatchDTO = new BatchDTO();
        sndBatchDTO.setDue_date(startDate);
        sndBatchDTO.setProduct_type_id(category.ordinal());

        return new BatchStockListDTO(List.of(sndBatchDTO, fstBatchDTO));
    }

    public static BatchStockListDTO categoryBatchStockDTODesc(ProductType category, LocalDate startDate, LocalDate endDate) {
        BatchDTO fstBatchDTO = new BatchDTO();
        fstBatchDTO.setDue_date(endDate);
        fstBatchDTO.setProduct_type_id(category.ordinal());

        BatchDTO sndBatchDTO = new BatchDTO();
        sndBatchDTO.setDue_date(startDate);
        sndBatchDTO.setProduct_type_id(category.ordinal());

        return new BatchStockListDTO(List.of(fstBatchDTO, sndBatchDTO));
    }

    public static boolean isBatchStockDTOAsc(BatchStockListDTO batchStockDTO) {
        return getBatchDueDate(batchStockDTO, 0).isBefore(
                getBatchDueDate(batchStockDTO, 1)
        );
    }

    public static boolean isBatchStockDTODesc(BatchStockListDTO batchStockDTO) {
        return getBatchDueDate(batchStockDTO, 0).isAfter(
                getBatchDueDate(batchStockDTO, 1)
        );
    }

    private static LocalDate getBatchDueDate(BatchStockListDTO batchStockDTO, int index) {
        return batchStockDTO.getBatch_stock().get(index).getDue_date();
    }

}
