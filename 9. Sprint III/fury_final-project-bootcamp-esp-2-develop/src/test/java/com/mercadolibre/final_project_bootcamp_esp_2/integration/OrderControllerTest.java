package com.mercadolibre.final_project_bootcamp_esp_2.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.final_project_bootcamp_esp_2.Application;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.request.OrderRequestDTO;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.request.ProductRequestDTO;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.request.PurchaseOrderRequestDTO;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.response.AddToCartResponseDTO;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.response.ProductDTO;
import com.mercadolibre.final_project_bootcamp_esp_2.service.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = {"SCOPE_SUFFIX = integration_test"})
@AutoConfigureMockMvc
public class OrderControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private OrderServiceImpl orderService;

    @Autowired
    private ObjectMapper objectMapper;

    private final String BUYER_ROLE = "BUYER";

    @Test
    @WithMockUser(username = "buyer_user", authorities = {BUYER_ROLE})
    void testGetProductsInOrder() throws Exception {

        Long orderId = 1L;
        List<ProductDTO> mockProductList;

        ProductDTO product1 = new ProductDTO(1L, 10);
        ProductDTO product2 = new ProductDTO(2L, 20);
        mockProductList = Arrays.asList(product1, product2);

        when(orderService.searchProductsInOrder(orderId)).thenReturn(mockProductList);

        mockMvc.perform(get("/api/v1/fresh-products/orders/{idOrder}", orderId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].quantity").value(10))
                .andExpect(jsonPath("$[1].id").value(2L))
                .andExpect(jsonPath("$[1].quantity").value(20));
    }

    @Test
    @WithMockUser(username = "buyer_user", authorities = {BUYER_ROLE})
    void testSaveOrder() throws Exception {

        ProductRequestDTO product1 = new ProductRequestDTO(1, 1);

        PurchaseOrderRequestDTO purchaseOrderRequestDTO = new PurchaseOrderRequestDTO();
        purchaseOrderRequestDTO.setOrderRequestDTO(new OrderRequestDTO(1L, List.of(product1), "2025-03-18"));

        AddToCartResponseDTO mockResponse = new AddToCartResponseDTO();
        mockResponse.setTotalPrice(1200.0);

        when(orderService.saveOrder(purchaseOrderRequestDTO)).thenReturn(mockResponse);

        mockMvc.perform(post("/api/v1/fresh-products/orders")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(purchaseOrderRequestDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.total_price").value(1200.00));
    }
}
