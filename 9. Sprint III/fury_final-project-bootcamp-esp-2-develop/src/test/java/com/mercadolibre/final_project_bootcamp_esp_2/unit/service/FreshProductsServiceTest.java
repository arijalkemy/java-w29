package com.mercadolibre.final_project_bootcamp_esp_2.unit.service;

import com.mercadolibre.final_project_bootcamp_esp_2.dto.response.BatchStockListDTO;
import com.mercadolibre.final_project_bootcamp_esp_2.exceptions.BadRequestException;
import com.mercadolibre.final_project_bootcamp_esp_2.exceptions.ResourceNotFoundException;
import com.mercadolibre.final_project_bootcamp_esp_2.model.util.DateOrder;
import com.mercadolibre.final_project_bootcamp_esp_2.model.util.ProductType;
import com.mercadolibre.final_project_bootcamp_esp_2.repository.BatchRepository;
import com.mercadolibre.final_project_bootcamp_esp_2.service.BatchServiceImpl;
import com.mercadolibre.final_project_bootcamp_esp_2.service.auth.AuthenticationService;
import com.mercadolibre.final_project_bootcamp_esp_2.util.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FreshProductsServiceTest {
    @Mock
    private BatchRepository batchRepository;

    @Mock
    private AuthenticationService authenticationService;

    @InjectMocks
    private BatchServiceImpl batchService;

    @Test
    @DisplayName("Should search batch stock by due date")
    public void searchBatchStockByDueDate() {
        // Arrange
        Long supervisorId = 1L;
        int cantDays = 2;
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = LocalDate.now().plusDays(cantDays);

        BatchStockListDTO expectedBatchStock = TestUtils.expectedBatchStockDTO(endDate);

        Mockito.when(authenticationService.findLoggedInUser()).thenReturn(TestUtils.supervisor());
        Mockito
            .when(batchRepository.findBySupervisorAndDueDateRange(supervisorId, startDate, endDate))
            .thenReturn(List.of(TestUtils.dueDateBatch(endDate)));

        // Act
        BatchStockListDTO actualBatchStock = batchService.searchBatchStockByDueDate(cantDays, null, null);

        // Assert
        Assertions.assertEquals(expectedBatchStock, actualBatchStock);
    }

    @Test
    @DisplayName("Should search batch stock by due date, fresh product type and ordered by date asc")
    public void searchBatchStockByDueDateAndFreshAndOrderedByDateAsc() {
        // Arrange
        Long supervisorId = 1L;
        int cantDays = 2;
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = LocalDate.now().plusDays(cantDays);
        String category = "FS";
        String dateOrder = "date_asc";
        ProductType fresh = ProductType.FRESH;

        BatchStockListDTO expectedBatchStock = TestUtils.categoryBatchStockDTOAsc(fresh, startDate, endDate);

        Mockito.when(authenticationService.findLoggedInUser()).thenReturn(TestUtils.supervisor());
        Mockito
            .when(batchRepository.findBySupervisorAndDueDateRangeAndProductTypeAndSortedByDate(supervisorId, startDate, endDate, fresh, DateOrder.DATE_ASC.toString()))
            .thenReturn(TestUtils.categoryBatchStockAsc(fresh, startDate, endDate));

        // Act
        BatchStockListDTO actualBatchStock = batchService.searchBatchStockByDueDate(cantDays, category, dateOrder);

        // Assert
        Assertions.assertEquals(expectedBatchStock, actualBatchStock);
        Assertions.assertTrue(TestUtils.isBatchStockDTOAsc(actualBatchStock));
    }

    @Test
    @DisplayName("Should search batch stock by due date, refrigerated product type and ordered by date desc")
    public void searchBatchStockByDueDateAndRefrigeratedAndOrderedByDateDesc() {
        // Arrange
        Long supervisorId = 1L;
        int cantDays = 2;
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = LocalDate.now().plusDays(cantDays);
        String category = "RF";
        String dateOrder = "date_desc";
        ProductType refrigerated = ProductType.REFRIGERATED;

        BatchStockListDTO expectedBatchStock = TestUtils.categoryBatchStockDTODesc(refrigerated, startDate, endDate);

        Mockito.when(authenticationService.findLoggedInUser()).thenReturn(TestUtils.supervisor());
        Mockito
            .when(batchRepository.findBySupervisorAndDueDateRangeAndProductTypeAndSortedByDate(supervisorId, startDate, endDate, refrigerated, DateOrder.DATE_DESC.toString()))
            .thenReturn(TestUtils.categoryBatchStockDesc(refrigerated, startDate, endDate));

        // Act
        BatchStockListDTO actualBatchStock = batchService.searchBatchStockByDueDate(cantDays, category, dateOrder);

        // Assert
        Assertions.assertEquals(expectedBatchStock, actualBatchStock);
        Assertions.assertTrue(TestUtils.isBatchStockDTODesc(actualBatchStock));
    }

    @Test
    @DisplayName("Should search batch stock by due date and frozen product type")
    public void searchBatchStockByDueDateAndFrozen() {
        // Arrange
        Long supervisorId = 1L;
        int cantDays = 2;
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = LocalDate.now().plusDays(cantDays);
        String category = "FF";
        String dateOrder = "date_desc";
        ProductType frozen = ProductType.FROZEN;

        BatchStockListDTO expectedBatchStock = TestUtils.categoryBatchStockDTODesc(frozen, startDate, endDate);

        Mockito.when(authenticationService.findLoggedInUser()).thenReturn(TestUtils.supervisor());
        Mockito
            .when(batchRepository.findBySupervisorAndDueDateRangeAndProductTypeAndSortedByDate(supervisorId, startDate, endDate, frozen, DateOrder.DATE_DESC.toString()))
            .thenReturn(TestUtils.categoryBatchStockDesc(frozen, startDate, endDate));

        // Act
        BatchStockListDTO actualBatchStock = batchService.searchBatchStockByDueDate(cantDays, category, dateOrder);

        // Assert
        Assertions.assertEquals(expectedBatchStock, actualBatchStock);
    }

    @Test
    @DisplayName("Should throw a Bad Request exception on invalid product category")
    public void searchBatchStockByDueDateAndInvalidCategoryThrowsBadRequestException() {
        // Arrange
        int cantDays = 2;
        String invalidCategory = "HELLO";
        String dateOrder = "date_desc";

        // Act & Assert
        Assertions.assertThrows(
            BadRequestException.class,
            () -> batchService.searchBatchStockByDueDate(cantDays, invalidCategory, dateOrder)
        );
    }

    @Test
    @DisplayName("Should throw a Bad Request exception on invalid date order")
    public void searchBatchStockByDueDateAndCategoryAndInvalidDateThrowsBadRequestException() {
        // Arrange
        int cantDays = 2;
        String category = "FF";
        String invalidDateOrder = "BYE";

        // Act & Assert
        Assertions.assertThrows(
            BadRequestException.class,
            () -> batchService.searchBatchStockByDueDate(cantDays, category, invalidDateOrder)
        );
    }

    @Test
    @DisplayName("Should throw a Not Found exception on inexistent batches")
    public void searchBatchStockByDueDateThrowsNotFoundException() {
        // Arrange
        int cantDays = 2;
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = LocalDate.now().plusDays(cantDays);

        Mockito.when(authenticationService.findLoggedInUser()).thenReturn(TestUtils.supervisor());
        Mockito.when(batchRepository.findBySupervisorAndDueDateRange(TestUtils.supervisor().getId(), startDate, endDate)).thenReturn(List.of());

        // Act & Assert
        Assertions.assertThrows(
                ResourceNotFoundException.class,
                () -> batchService.searchBatchStockByDueDate(cantDays, null, null)
        );
    }
}
