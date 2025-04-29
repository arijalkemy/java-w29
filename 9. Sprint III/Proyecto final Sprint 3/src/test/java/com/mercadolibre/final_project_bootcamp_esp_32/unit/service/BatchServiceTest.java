package com.mercadolibre.final_project_bootcamp_esp_32.unit.service;

import com.mercadolibre.final_project_bootcamp_esp_32.dtos.response.ProductBatchStockDto;
import com.mercadolibre.final_project_bootcamp_esp_32.entities.InternalUser;
import com.mercadolibre.final_project_bootcamp_esp_32.entities.ProductBatch;
import com.mercadolibre.final_project_bootcamp_esp_32.enums.OrderType;
import com.mercadolibre.final_project_bootcamp_esp_32.exceptions.NotFoundException;
import com.mercadolibre.final_project_bootcamp_esp_32.repository.IBatchRepository;
import com.mercadolibre.final_project_bootcamp_esp_32.repository.IProductRepository;
import com.mercadolibre.final_project_bootcamp_esp_32.service.AuthService;
import com.mercadolibre.final_project_bootcamp_esp_32.service.BatchServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static com.mercadolibre.final_project_bootcamp_esp_32.unit.util.TestUtils.createProductBatchStockDto;
import static com.mercadolibre.final_project_bootcamp_esp_32.unit.util.TestUtils.createProductBatches;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BatchServiceTest {

    @Mock
    private IProductRepository productRepository;
    @Mock
    private IBatchRepository batchRepository;
    @Mock
    private AuthService authService;
    @Mock
    private HttpServletRequest httpServletRequest;

    @InjectMocks
    private BatchServiceImpl batchService;


    @BeforeEach
    void setUp(){
        InternalUser internalUser = new InternalUser();
        internalUser.setId(1);
        when(authService.validateInternalUser(any())).thenReturn(internalUser);
    }

    @Test
    void searchFreshProductProductNotFoundTest() {
        Integer productId = 1;
        String order = OrderType.BATCH_NUMBER.getValue();

        when(productRepository.existsById(productId)).thenReturn(false);

        NotFoundException thrown = assertThrows(NotFoundException.class,
                () -> batchService.searchFreshProducts(productId, order, httpServletRequest));
        assertEquals("No existe el producto con id: " + productId, thrown.getMessage());
    }

    @Test
    void searchFreshProductNoBatchesFoundTest() {
        Integer productId = 1;
        String order = OrderType.BATCH_NUMBER.getValue();
        when(productRepository.existsById(productId)).thenReturn(true);

        NotFoundException thrown = assertThrows(NotFoundException.class,
                () -> batchService.searchFreshProducts(productId, order, httpServletRequest));
        assertEquals("No se encontron lotes con el producto id: " + productId, thrown.getMessage());
    }

    @Test
    void searchFreshProductsOkOrderNullTest() {
        Integer productId = 1;
        Integer internalUser = 1;
        LocalDate threeWeeksFromNow = LocalDate.now().plusWeeks(3);
        String order = null;
        List<ProductBatch> batches = createProductBatches();
        ProductBatchStockDto excpected = createProductBatchStockDto();

        when(productRepository.existsById(productId)).thenReturn(true);
        when(batchRepository.findByProduct_IdAndSection_Warehouse_InternalUser_IdAndDueDateGreaterThanEqual(
                productId, internalUser, threeWeeksFromNow))
                .thenReturn(batches);

        ProductBatchStockDto result = batchService.searchFreshProducts(productId, order, httpServletRequest);

        assertEquals(2, result.getBatchStock().size());
        assertEquals(excpected, result);
    }

    @Test
    void searchFreshProductsOkOrderBatchNumberTest() {
        Integer productId = 1;
        Integer internalUser = 1;
        LocalDate threeWeeksFromNow = LocalDate.now().plusWeeks(3);
        String order = OrderType.BATCH_NUMBER.getValue();
        List<ProductBatch> batches = createProductBatches();
        ProductBatchStockDto excpected = createProductBatchStockDto();

        when(productRepository.existsById(productId)).thenReturn(true);
        when(batchRepository.findByProduct_IdAndSection_Warehouse_InternalUser_IdAndDueDateGreaterThanEqualOrderByBatchNumber(
                productId, internalUser, threeWeeksFromNow))
                .thenReturn(batches);

        ProductBatchStockDto result = batchService.searchFreshProducts(productId, order, httpServletRequest);

        assertEquals(2, result.getBatchStock().size());
        assertEquals(excpected, result);
    }

    @Test
    void searchFreshProductsOkOrderCurrentQuantityTest() {
        Integer productId = 1;
        Integer internalUser = 1;
        LocalDate threeWeeksFromNow = LocalDate.now().plusWeeks(3);
        String order = OrderType.CURRENT_QUANTITY.getValue();
        List<ProductBatch> batches = createProductBatches();
        ProductBatchStockDto excpected = createProductBatchStockDto();

        when(productRepository.existsById(productId)).thenReturn(true);
        when(batchRepository.findByProduct_IdAndSection_Warehouse_InternalUser_IdAndDueDateGreaterThanEqualOrderByCurrentQuantity(
                productId, internalUser, threeWeeksFromNow))
                .thenReturn(batches);

        ProductBatchStockDto result = batchService.searchFreshProducts(productId, order, httpServletRequest);

        assertEquals(2, result.getBatchStock().size());
        assertEquals(excpected, result);
    }

    @Test
    void searchFreshProductsOkOrderDueDateTest() {
        Integer productId = 1;
        Integer internalUser = 1;
        LocalDate threeWeeksFromNow = LocalDate.now().plusWeeks(3);
        String order = OrderType.DUE_DATE.getValue();
        List<ProductBatch> batches = createProductBatches();
        ProductBatchStockDto excpected = createProductBatchStockDto();

        when(productRepository.existsById(productId)).thenReturn(true);
        when(batchRepository.findByProduct_IdAndSection_Warehouse_InternalUser_IdAndDueDateGreaterThanEqualOrderByDueDate(
                productId, internalUser, threeWeeksFromNow))
                .thenReturn(batches);

        ProductBatchStockDto result = batchService.searchFreshProducts(productId, order, httpServletRequest);

        assertEquals(2, result.getBatchStock().size());
        assertEquals(excpected, result);
    }

    @Test
    void testGetBatchStockNoWarehouse() {
        // Given
        Integer cantDays = 30;
        String order = "date_asc";
        String category = "ALL";

        InternalUser userWithoutWarehouse = new InternalUser();
        when(authService.validateInternalUser(httpServletRequest)).thenReturn(userWithoutWarehouse);

        // When & Then
        assertThrows(NotFoundException.class, () ->
                batchService.getBatchStock(cantDays, httpServletRequest, order, category));
    }

}