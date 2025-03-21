package com.mercadolibre.final_project_bootcamp_esp_2.unit;

import com.mercadolibre.final_project_bootcamp_esp_2.dto.request.BatchRequestDto;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.response.BatchStockResponseDTO;
import com.mercadolibre.final_project_bootcamp_esp_2.exceptions.BadRequestException;
import com.mercadolibre.final_project_bootcamp_esp_2.exceptions.ConflictException;
import com.mercadolibre.final_project_bootcamp_esp_2.exceptions.NotFoundException;
import com.mercadolibre.final_project_bootcamp_esp_2.model.*;
import com.mercadolibre.final_project_bootcamp_esp_2.model.util.ProductType;
import com.mercadolibre.final_project_bootcamp_esp_2.model.util.UserRole;
import com.mercadolibre.final_project_bootcamp_esp_2.repository.BatchRepository;
import com.mercadolibre.final_project_bootcamp_esp_2.repository.IProductRepository;
import com.mercadolibre.final_project_bootcamp_esp_2.repository.ISectorRepository;
import com.mercadolibre.final_project_bootcamp_esp_2.repository.IWarehouseRepository;
import com.mercadolibre.final_project_bootcamp_esp_2.service.BatchServiceImpl;
import com.mercadolibre.final_project_bootcamp_esp_2.service.auth.AuthenticationService;
import com.mercadolibre.final_project_bootcamp_esp_2.util.BatchUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BatchServiceImplTest {

    @Mock
    IWarehouseRepository warehouseRepository;

    @Mock
    ISectorRepository sectionRepository;

    @Mock
    IProductRepository productRepository;

    @Mock
    BatchRepository batchRepository;

    @Mock
    AuthenticationService authenticationService;

    @InjectMocks
    BatchServiceImpl freshBatchService;

    private LocalDate manufacturingDate;
    private LocalDateTime manufacturingDateTime;
    private LocalDate dueDate;

    @BeforeEach
    void setUp() {
        manufacturingDate = LocalDate.of(2025, 3, 14);
        manufacturingDateTime = LocalDateTime.of(2025, 3, 15, 14, 0, 0);
        dueDate = LocalDate.of(2025, 4, 14);
    }

    @Test
    void createInboundOrderOk() {

        BatchRequestDto batchRequestDto = BatchUtil.createBodyRequest();
        BatchStockResponseDTO expected = new BatchStockResponseDTO(batchRequestDto.getInboundOrder().getBatchStock());

        User user = new User(2L, "userName","Test", "password1", UserRole.SUPERVISOR);
        Warehouse warehouse = new Warehouse(2L, "Warehouse Norte", user, null);
        Sector section = new Sector(2L, "Sección Refrigerados", null, null,null);
        Product product = new Product(2L,null, null, null,null);
        Batch batch = new Batch(null, 324512, product, 5.2, 0.5, 5, 5, manufacturingDate, manufacturingDateTime, dueDate, section);

        when(warehouseRepository.findById(2L)).thenReturn(Optional.of(warehouse));
        when(authenticationService.findLoggedInUser()).thenReturn(user);
        when(sectionRepository.findById(2L)).thenReturn(Optional.of(section));
        when(productRepository.findById(2L)).thenReturn(Optional.of(product));
        when(batchRepository.saveAll(List.of(batch))).thenReturn(List.of(batch));

        BatchStockResponseDTO actual = freshBatchService.createInboundOrder(batchRequestDto);

        assertEquals(expected, actual, "Los valores no coinciden. Expected: " + expected + ", Actual: " + actual);
    }

    @Test
    void createInboundOrderThrowExceptionWarehouse() {

        BatchRequestDto batchRequestDto = BatchUtil.createBodyRequest();

        when(warehouseRepository.findById(2L)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> freshBatchService.createInboundOrder(batchRequestDto));
    }

    @Test
    void createInboundOrderThrowExceptionSector() {

        BatchRequestDto batchRequestDto = BatchUtil.createBodyRequest();

        User user = new User(2L, "userName","Test", "password1", UserRole.SUPERVISOR);
        Warehouse warehouse = new Warehouse(2L, "Warehouse Norte", user, null);

        when(warehouseRepository.findById(2L)).thenReturn(Optional.of(warehouse));
        when(authenticationService.findLoggedInUser()).thenReturn(user);
        when(sectionRepository.findById(2L)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> freshBatchService.createInboundOrder(batchRequestDto));
    }

    @Test
    void createInboundOrderThrowExceptionProduct() {

        BatchRequestDto batchRequestDto = BatchUtil.createBodyRequest();

        User user = new User(2L, "userName","Test", "password1", UserRole.SUPERVISOR);
        Warehouse warehouse = new Warehouse(2L, "Warehouse Norte", user, null);
        Sector section = new Sector(2L, "Sección Refrigerados", null, null,null);

        when(warehouseRepository.findById(2L)).thenReturn(Optional.of(warehouse));
        when(authenticationService.findLoggedInUser()).thenReturn(user);
        when(sectionRepository.findById(2L)).thenReturn(Optional.of(section));
        when(productRepository.findById(2L)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> freshBatchService.createInboundOrder(batchRequestDto));
    }

    @Test
    void createInboundOrderThrowExceptionErrorSector() {

        BatchRequestDto batchRequestDto = BatchUtil.createBodyRequest();

        User user = new User(2L, "userName","Test", "password1", UserRole.SUPERVISOR);
        Warehouse warehouse = new Warehouse(2L, "Warehouse Norte", user, null);
        Sector section = new Sector(2L, "Sección Refrigerados", ProductType.FRESH, null,null);
        Product product = new Product(2L, null, null, ProductType.FROZEN,null);

        when(warehouseRepository.findById(2L)).thenReturn(Optional.of(warehouse));
        when(authenticationService.findLoggedInUser()).thenReturn(user);
        when(sectionRepository.findById(2L)).thenReturn(Optional.of(section));
        when(productRepository.findById(2L)).thenReturn(Optional.of(product));

        assertThrows(BadRequestException.class, () -> freshBatchService.createInboundOrder(batchRequestDto));
    }

    @Test
    void createInboundOrderThrowExceptionBatchExist() {

        BatchRequestDto batchRequestDto = BatchUtil.createBodyRequest();
        Batch batch = new Batch(null, 324512, null, 5.2, 0.5, 5, 5, manufacturingDate, manufacturingDateTime, dueDate, null);

        User user = new User(2L, "userName","Test", "password1", UserRole.SUPERVISOR);
        Warehouse warehouse = new Warehouse(2L, "Warehouse Norte", user, null);
        Sector section = new Sector(2L, "Sección Refrigerados", null, null,null);

        when(warehouseRepository.findById(2L)).thenReturn(Optional.of(warehouse));
        when(authenticationService.findLoggedInUser()).thenReturn(user);
        when(sectionRepository.findById(2L)).thenReturn(Optional.of(section));
        when(batchRepository.findByBatchNumber(324512)).thenReturn(Optional.of(batch));

        assertThrows(ConflictException.class, () -> freshBatchService.createInboundOrder(batchRequestDto));
    }

    @Test
    void updateInboundOrderOk() {
        BatchRequestDto batchRequestDto = BatchUtil.createBodyRequest();
        BatchStockResponseDTO expected = new BatchStockResponseDTO(batchRequestDto.getInboundOrder().getBatchStock());

        User user = new User(2L, "userName","Test", "password1", UserRole.SUPERVISOR);
        Warehouse warehouse = new Warehouse(2L, "Warehouse Norte", user, null);
        Sector section = new Sector(2L, "Sección Refrigerados", null, null, null);
        Product product = new Product(2L, null, null, null, null);
        Batch batch = new Batch(2L, 324512, product, 5.2, 0.5, 5, 5, manufacturingDate, manufacturingDateTime, dueDate, section);

        when(warehouseRepository.findById(2L)).thenReturn(Optional.of(warehouse));
        when(authenticationService.findLoggedInUser()).thenReturn(user);
        when(sectionRepository.findById(2L)).thenReturn(Optional.of(section));
        when(productRepository.findById(2L)).thenReturn(Optional.of(product));
        when(batchRepository.findByBatchNumber(324512)).thenReturn(Optional.of(batch));
        when(batchRepository.saveAll(List.of(batch))).thenReturn(List.of(batch));

        BatchStockResponseDTO actual = freshBatchService.updateInboundOrder(batchRequestDto);

        assertEquals(expected, actual, "Los valores no coinciden. Expected: " + expected + ", Actual: " + actual);
    }

    @Test
    void updateInboundOrderThrowExceptionWarehouse() {

        BatchRequestDto batchRequestDto = BatchUtil.createBodyRequest();

        when(warehouseRepository.findById(2L)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> freshBatchService.updateInboundOrder(batchRequestDto));
    }

    @Test
    void updateInboundOrderThrowExceptionSector() {

        BatchRequestDto batchRequestDto = BatchUtil.createBodyRequest();

        User user = new User(2L, "userName","Test", "password1", UserRole.SUPERVISOR);
        Warehouse warehouse = new Warehouse(2L, "Warehouse Norte", user, null);

        when(warehouseRepository.findById(2L)).thenReturn(Optional.of(warehouse));
        when(authenticationService.findLoggedInUser()).thenReturn(user);
        when(sectionRepository.findById(2L)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> freshBatchService.updateInboundOrder(batchRequestDto));
    }

    @Test
    void updateInboundOrderThrowExceptionProduct() {

        BatchRequestDto batchRequestDto = BatchUtil.createBodyRequest();

        User user = new User(2L, "userName","Test", "password1", UserRole.SUPERVISOR);
        Warehouse warehouse = new Warehouse(2L, "Warehouse Norte", user, null);
        Sector section = new Sector(2L, "Sección Refrigerados", null, null,null);

        when(warehouseRepository.findById(2L)).thenReturn(Optional.of(warehouse));
        when(authenticationService.findLoggedInUser()).thenReturn(user);
        when(sectionRepository.findById(2L)).thenReturn(Optional.of(section));
        when(productRepository.findById(2L)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> freshBatchService.updateInboundOrder(batchRequestDto));
    }

    @Test
    void updateInboundOrderThrowExceptionErrorSector() {

        BatchRequestDto batchRequestDto = BatchUtil.createBodyRequest();

        User user = new User(2L, "userName","Test", "password1", UserRole.SUPERVISOR);
        Warehouse warehouse = new Warehouse(2L, "Warehouse Norte", user, null);
        Sector section = new Sector(2L, "Sección Refrigerados", ProductType.FRESH, null,null);
        Product product = new Product(2L, null, null, ProductType.FROZEN,null);

        when(warehouseRepository.findById(2L)).thenReturn(Optional.of(warehouse));
        when(authenticationService.findLoggedInUser()).thenReturn(user);
        when(sectionRepository.findById(2L)).thenReturn(Optional.of(section));
        when(productRepository.findById(2L)).thenReturn(Optional.of(product));

        assertThrows(BadRequestException.class, () -> freshBatchService.updateInboundOrder(batchRequestDto));
    }

    @Test
    void updateInboundOrderThrowExceptionBatch() {

        BatchRequestDto batchRequestDto = BatchUtil.createBodyRequest();

        User user = new User(2L, "userName","Test", "password1", UserRole.SUPERVISOR);
        Warehouse warehouse = new Warehouse(2L, "Warehouse Norte", user, null);
        Sector section = new Sector(2L, "Sección Refrigerados", ProductType.REFRIGERATED, null,null);
        Product product = new Product(2L, null, null, ProductType.REFRIGERATED,null);

        when(warehouseRepository.findById(2L)).thenReturn(Optional.of(warehouse));
        when(authenticationService.findLoggedInUser()).thenReturn(user);
        when(sectionRepository.findById(2L)).thenReturn(Optional.of(section));
        when(productRepository.findById(2L)).thenReturn(Optional.of(product));
        when(batchRepository.findByBatchNumber(324512)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> freshBatchService.updateInboundOrder(batchRequestDto));
    }

}