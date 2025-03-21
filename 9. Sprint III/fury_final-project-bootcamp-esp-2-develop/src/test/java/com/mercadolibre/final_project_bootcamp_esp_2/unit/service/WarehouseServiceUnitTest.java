package com.mercadolibre.final_project_bootcamp_esp_2.unit.service;

import com.mercadolibre.final_project_bootcamp_esp_2.dto.BatchSortType;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.ProductBatchListResponse;
import com.mercadolibre.final_project_bootcamp_esp_2.exceptions.ResourceNotFoundException;
import com.mercadolibre.final_project_bootcamp_esp_2.model.*;
import com.mercadolibre.final_project_bootcamp_esp_2.model.util.ProductType;
import com.mercadolibre.final_project_bootcamp_esp_2.repository.BatchRepository;
import com.mercadolibre.final_project_bootcamp_esp_2.repository.WarehouseRepository;
import com.mercadolibre.final_project_bootcamp_esp_2.service.WarehouseService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WarehouseServiceUnitTest {
    @Mock
    private WarehouseRepository warehouseRepository;
    @Mock
    private BatchRepository batchRepository;
    @InjectMocks
    private WarehouseService warehouseService;

    @Test
    void getProductBatchesByProductIdTest() {
        // Arrange

        Long productId = 1L;
        Long supervisorId = 1L;
        Long sectionId = 1L;
        Long warehouseId = 1L;

        Warehouse warehouse = new Warehouse();
        warehouse.setId(warehouseId);
        when(warehouseRepository.findBySupervisorId(anyLong())).thenReturn(Optional.of(warehouse));

        Product product = new Product();
        product.setId(productId);
        product.setType(ProductType.FRESH);
        when(batchRepository.fetchProduct(anyLong(), anyLong())).thenReturn(Optional.of(product));

        Sector sector = new Sector();
        sector.setId(sectionId);
        when(warehouseRepository.findWarehouseSectionsForProductType(anyLong(), any(ProductType.class))).thenReturn(Optional.of(sector));

        Batch batch = new Batch();
        batch.setBatchNumber(1);
        batch.setCurrentQuantity(1);
        batch.setDueDate(LocalDate.now().plusDays(7));

        when(batchRepository.findBatchBySectorIdAndProductId(sector.getId(), product.getId())).thenReturn(List.of(batch));

        // Act
        ProductBatchListResponse response = warehouseService.getProductBatchesByProductIdSortedBy(supervisorId, productId, null);

        // Assert
        assertEquals(productId, response.productId());
        assertEquals(sectionId, response.section().sectionCode());
        assertEquals(warehouseId, response.section().warehouseCode());
        assertEquals(1, response.batchStock().size());
        assertEquals(1, response.batchStock().get(0).batchNumber());
        assertEquals(1, response.batchStock().get(0).currentQuantity());
        assertEquals(LocalDate.now().plusDays(7), response.batchStock().get(0).date());

    }

    @Test
    void warehouseNotFoundExceptionTest() {
        // Arrange
        when(warehouseRepository.findBySupervisorId(anyLong())).thenReturn(Optional.empty());

        // Act and Assert
        ResourceNotFoundException exception = assertThrows(
                ResourceNotFoundException.class,
                () -> warehouseService.getProductBatchesByProductIdSortedBy(1L, 1L, null));

        assertEquals("Warehouse not found for supervisor id 1", exception.getMessage());
    }

    @Test
    void productNotFoundExceptionTest() {
        // Arrange
        Long productId = 1L;
        Long supervisorId = 1L;
        Long warehouseId = 1L;

        Warehouse warehouse = new Warehouse();
        warehouse.setId(warehouseId);
        when(warehouseRepository.findBySupervisorId(anyLong())).thenReturn(Optional.of(warehouse));

        when(batchRepository.fetchProduct(anyLong(), anyLong())).thenReturn(Optional.empty());

        // Act
        RuntimeException exception = assertThrows(
                ResourceNotFoundException.class,
                () -> warehouseService.getProductBatchesByProductIdSortedBy(supervisorId, productId, null)
        );

        // Assert
        assertEquals("Product details not found for product id " + supervisorId, exception.getMessage());

    }

    @Test
    void sectionForProductTypeNotFoundExceptionTest() {
        // Arrange
        Long productId = 1L;
        Long supervisorId = 1L;
        Long warehouseId = 1L;

        Warehouse warehouse = new Warehouse();
        warehouse.setId(warehouseId);
        when(warehouseRepository.findBySupervisorId(anyLong())).thenReturn(Optional.of(warehouse));

        Product product = new Product();
        product.setId(productId);
        product.setType(ProductType.FRESH);
        when(batchRepository.fetchProduct(anyLong(), anyLong())).thenReturn(Optional.of(product));

        when(warehouseRepository.findWarehouseSectionsForProductType(anyLong(), any(ProductType.class))).thenReturn(Optional.empty());

        // Act
        RuntimeException exception = assertThrows(
                ResourceNotFoundException.class,
                () -> warehouseService.getProductBatchesByProductIdSortedBy(supervisorId, productId, null)
        );

        // Assert
        assertEquals("Warehouse section not found for id " + warehouseId + " and product type " + ProductType.FRESH.name(), exception.getMessage());
    }

    @Test
    void getProductBatchesByProductIdSortedByBatchNumberTest() {
        // Arrange

        Long productId = 1L;
        Long supervisorId = 1L;
        Long sectionId = 1L;
        Long warehouseId = 1L;

        Warehouse warehouse = new Warehouse();
        warehouse.setId(warehouseId);
        when(warehouseRepository.findBySupervisorId(anyLong())).thenReturn(Optional.of(warehouse));

        Product product = new Product();
        product.setId(productId);
        product.setType(ProductType.FRESH);
        when(batchRepository.fetchProduct(anyLong(), anyLong())).thenReturn(Optional.of(product));

        Sector sector = new Sector();
        sector.setId(sectionId);
        when(warehouseRepository.findWarehouseSectionsForProductType(anyLong(), any(ProductType.class))).thenReturn(Optional.of(sector));

        Batch batchLow = new Batch();
        batchLow.setBatchNumber(1);
        batchLow.setCurrentQuantity(1);
        batchLow.setDueDate(LocalDate.now().plusDays(7));

        Batch batchHigh = new Batch();
        batchHigh.setBatchNumber(2);
        batchHigh.setCurrentQuantity(2);
        batchHigh.setDueDate(LocalDate.now().plusDays(7));

        when(batchRepository.findBatchBySectorIdSortedByBatchNumber(sectionId, warehouseId)).thenReturn(List.of(batchLow, batchHigh));

        // Act
        ProductBatchListResponse response = warehouseService.getProductBatchesByProductIdSortedBy(supervisorId, productId, BatchSortType.L);

        // Assert
        assertEquals(productId, response.productId());
        assertEquals(batchLow.getBatchNumber(), response.batchStock().get(0).batchNumber());
        assertEquals(batchHigh.getBatchNumber(), response.batchStock().get(1).batchNumber());
    }

    @Test
    void getProductBatchesByProductIdSortedByCurrentQuantityTest() {
        // Arrange

        Long productId = 1L;
        Long supervisorId = 1L;
        Long sectionId = 1L;
        Long warehouseId = 1L;

        Warehouse warehouse = new Warehouse();
        warehouse.setId(warehouseId);
        when(warehouseRepository.findBySupervisorId(anyLong())).thenReturn(Optional.of(warehouse));

        Product product = new Product();
        product.setId(productId);
        product.setType(ProductType.FRESH);
        when(batchRepository.fetchProduct(anyLong(), anyLong())).thenReturn(Optional.of(product));

        Sector sector = new Sector();
        sector.setId(sectionId);
        when(warehouseRepository.findWarehouseSectionsForProductType(anyLong(), any(ProductType.class))).thenReturn(Optional.of(sector));

        Batch batchLow = new Batch();
        batchLow.setBatchNumber(1);
        batchLow.setCurrentQuantity(1);
        batchLow.setDueDate(LocalDate.now().plusDays(7));

        Batch batchHigh = new Batch();
        batchHigh.setBatchNumber(2);
        batchHigh.setCurrentQuantity(2);
        batchHigh.setDueDate(LocalDate.now().plusDays(7));

        when(batchRepository.findBatchBySectorIdSortedByCurrentQuantity(sectionId, warehouseId)).thenReturn(List.of(batchLow, batchHigh));

        // Act
        ProductBatchListResponse response = warehouseService.getProductBatchesByProductIdSortedBy(supervisorId, productId, BatchSortType.C);

        // Assert
        assertEquals(productId, response.productId());
        assertEquals(batchLow.getBatchNumber(), response.batchStock().get(0).batchNumber());
        assertEquals(batchHigh.getBatchNumber(), response.batchStock().get(1).batchNumber());
    }

    @Test
    void getProductBatchesByProductIdSortedByDueDateTest() {
        // Arrange

        Long productId = 1L;
        Long supervisorId = 1L;
        Long sectionId = 1L;
        Long warehouseId = 1L;

        Warehouse warehouse = new Warehouse();
        warehouse.setId(warehouseId);
        when(warehouseRepository.findBySupervisorId(anyLong())).thenReturn(Optional.of(warehouse));

        Product product = new Product();
        product.setId(productId);
        product.setType(ProductType.FRESH);
        when(batchRepository.fetchProduct(anyLong(), anyLong())).thenReturn(Optional.of(product));

        Sector sector = new Sector();
        sector.setId(sectionId);
        when(warehouseRepository.findWarehouseSectionsForProductType(anyLong(), any(ProductType.class))).thenReturn(Optional.of(sector));

        Batch batchLow = new Batch();
        batchLow.setBatchNumber(1);
        batchLow.setCurrentQuantity(1);
        batchLow.setDueDate(LocalDate.now().plusDays(7));

        Batch batchHigh = new Batch();
        batchHigh.setBatchNumber(2);
        batchHigh.setCurrentQuantity(2);
        batchHigh.setDueDate(LocalDate.now().plusDays(7));

        when(batchRepository.findBatchBySectorIdSortedByDueDate(sectionId, warehouseId)).thenReturn(List.of(batchLow, batchHigh));

        // Act
        ProductBatchListResponse response = warehouseService.getProductBatchesByProductIdSortedBy(supervisorId, productId, BatchSortType.F);

        // Assert
        assertEquals(productId, response.productId());
        assertEquals(batchLow.getBatchNumber(), response.batchStock().get(0).batchNumber());
        assertEquals(batchHigh.getBatchNumber(), response.batchStock().get(1).batchNumber());
    }

    @Test
    void batchNotFoundExceptionTest() {
        // Arrange

        Long productId = 1L;
        Long supervisorId = 1L;
        Long sectionId = 1L;
        Long warehouseId = 1L;

        Warehouse warehouse = new Warehouse();
        warehouse.setId(warehouseId);
        when(warehouseRepository.findBySupervisorId(anyLong())).thenReturn(Optional.of(warehouse));

        Product product = new Product();
        product.setId(productId);
        product.setType(ProductType.FRESH);
        when(batchRepository.fetchProduct(anyLong(), anyLong())).thenReturn(Optional.of(product));

        Sector sector = new Sector();
        sector.setId(sectionId);
        when(warehouseRepository.findWarehouseSectionsForProductType(anyLong(), any(ProductType.class))).thenReturn(Optional.of(sector));

        Batch batch = new Batch();
        batch.setBatchNumber(1);
        batch.setCurrentQuantity(1);
        batch.setDueDate(LocalDate.now().plusDays(7));

        when(batchRepository.findBatchBySectorIdAndProductId(sector.getId(), product.getId())).thenReturn(List.of());

        // Act
        RuntimeException exception = assertThrows(
                ResourceNotFoundException.class,
                () -> warehouseService.getProductBatchesByProductIdSortedBy(supervisorId, productId, null)
        );

        // Assert
        assertEquals("No batch found for section id " + sectionId + " and product id " + productId, exception.getMessage());
    }



}
