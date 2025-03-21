package com.mercadolibre.final_project_bootcamp_esp_2.integration;

import com.mercadolibre.final_project_bootcamp_esp_2.dto.BatchStockDTO;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.ProductBatchListResponse;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.ProductStockDTO;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.response.ProductStockAndSectionDTO;
import com.mercadolibre.final_project_bootcamp_esp_2.util.IntegrationTestUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FreshProductControllerTest extends ControllerTest {

    @Autowired
    private IntegrationTestUtils integrationTestUtils;

    @Test
    void testGetAllProduct_Success(){
        String url = ("/api/v1/fresh-products/list");

        // Act
        ResponseEntity<List<ProductStockDTO>> responseEntity = this.testRestTemplate.exchange(
                url,
                HttpMethod.GET,
                new HttpEntity<>(integrationTestUtils.generateAuthHeaderForBuyer()),
                new ParameterizedTypeReference<>() {
                }
        );

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
    }

    @Test
    void testGetAllProduct_getFreshProductBatchList_Success() {

        // Act
        ResponseEntity<ProductBatchListResponse> responseEntity = this.testRestTemplate.exchange(
                "/api/v1/fresh-products/1/batch/list",
                HttpMethod.GET,
                new HttpEntity<>(integrationTestUtils.generateAuthHeaderForSupervisor()),
                ProductBatchListResponse.class
        );

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
    }

    @Test
    void testGetProductStockByWarehouse_Success() {
        Long warehouseId = 1L;
        Long productId = 3L;
        String url = String.format("/api/v1/fresh-products/%d/products/%d/stock", warehouseId, productId);
        System.out.println("Testing URL: " + url);

        ResponseEntity<ProductStockAndSectionDTO> responseEntity = this.testRestTemplate.exchange(
                url,
                HttpMethod.GET,
                new HttpEntity<>(integrationTestUtils.generateAuthHeaderForSupervisor()),
                ProductStockAndSectionDTO.class
        );

        System.out.println("Response: " + responseEntity);
        System.out.println("Response Body: " + responseEntity.getBody());

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertEquals(warehouseId, responseEntity.getBody().getWarehouseId());
        assertEquals(productId, responseEntity.getBody().getProductId());
        assertFalse(responseEntity.getBody().getSections().isEmpty());
    }

    @Test
    @DisplayName("Search a batch stock by due date should return 200 OK")
    public void searchBatchStockByDueDateShouldReturnOk() {
        int cantDays = 60;
        String url = String.format("/api/v1/fresh-products/batch/list/due-date/%d", cantDays);
        System.out.println("Testing URL: " + url);

        ResponseEntity<BatchStockDTO> responseEntity = this.testRestTemplate.exchange(
                url,
                HttpMethod.GET,
                new HttpEntity<>(integrationTestUtils.generateAuthHeaderForSupervisor()),
                BatchStockDTO.class
        );

        System.out.println("Response: " + responseEntity);
        System.out.println("Response Body: " + responseEntity.getBody());

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
    }

    @Test
    @DisplayName("Search a batch stock by due date, category and date should return 200 OK")
    public void searchBatchStockByDueDateAndFreshAndOrderAscShouldReturnOk() {
        int cantDays = 60;
        String category = "FS";
        String dateOrder = "date_asc";
        String url = String.format("/api/v1/fresh-products/batch/list/due-date/%d?category=%s&order=%s", cantDays, category, dateOrder);
        System.out.println("Testing URL: " + url);

        ResponseEntity<BatchStockDTO> responseEntity = this.testRestTemplate.exchange(
                url,
                HttpMethod.GET,
                new HttpEntity<>(integrationTestUtils.generateAuthHeaderForSupervisor()),
                BatchStockDTO.class
        );

        System.out.println("Response: " + responseEntity);
        System.out.println("Response Body: " + responseEntity.getBody());

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
    }

    @Test
    @DisplayName("Search a batch stock by due date with invalid category should return 400 Bad Request")
    public void searchBatchStockByDueDateShouldReturnBadRequest() {
        int cantDays = 60;
        String invalidCategory = "HELLO";
        String dateOrder = "date_asc";
        String url = String.format("/api/v1/fresh-products/batch/list/due-date/%d?category=%s&order=%s", cantDays, invalidCategory, dateOrder);
        System.out.println("Testing URL: " + url);

        ResponseEntity<BatchStockDTO> responseEntity = this.testRestTemplate.exchange(
                url,
                HttpMethod.GET,
                new HttpEntity<>(integrationTestUtils.generateAuthHeaderForSupervisor()),
                BatchStockDTO.class
        );

        System.out.println("Response: " + responseEntity);
        System.out.println("Response Body: " + responseEntity.getBody());

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
    }


    @Test
    @DisplayName("Search a batch stock by due date should return 404 Not Found")
    public void searchBatchStockByDueDateShouldReturnNotFound() {
        int cantDays = 0;
        String url = String.format("/api/v1/fresh-products/batch/list/due-date/%d", cantDays);
        System.out.println("Testing URL: " + url);

        ResponseEntity<BatchStockDTO> responseEntity = this.testRestTemplate.exchange(
                url,
                HttpMethod.GET,
                new HttpEntity<>(integrationTestUtils.generateAuthHeaderForSupervisor()),
                BatchStockDTO.class
        );

        System.out.println("Response: " + responseEntity);
        System.out.println("Response Body: " + responseEntity.getBody());

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
    }
}