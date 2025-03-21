package com.mercadolibre.final_project_bootcamp_esp_2.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.final_project_bootcamp_esp_2.Application;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.ProductStockDTO;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.request.ProductRequestDTO;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.request.PurchaseOrderRequestDTO;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.response.ProductWarehouseDTO;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.response.WarehouseStockDto;
import com.mercadolibre.final_project_bootcamp_esp_2.exceptions.ConflictException;
import com.mercadolibre.final_project_bootcamp_esp_2.exceptions.NotFoundException;
import com.mercadolibre.final_project_bootcamp_esp_2.model.Order;
import com.mercadolibre.final_project_bootcamp_esp_2.model.util.ProductType;
import com.mercadolibre.final_project_bootcamp_esp_2.repository.IOrderRepository;
import com.mercadolibre.final_project_bootcamp_esp_2.repository.IProductRepository;
import com.mercadolibre.final_project_bootcamp_esp_2.service.OrderServiceImpl;
import com.mercadolibre.final_project_bootcamp_esp_2.service.ProductServiceImpl;
import com.mercadolibre.final_project_bootcamp_esp_2.util.TestUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = {"SCOPE_SUFFIX = integration_test"})
@AutoConfigureMockMvc
public class FreshProductTest {

    @MockBean
    IOrderRepository orderRepository;

    @MockBean
    IProductRepository productRepository;

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private OrderServiceImpl orderService;

    @MockBean
    private ProductServiceImpl freshProductService;

    @Autowired
    private ObjectMapper objectMapper;

    private final String BUYER_ROLE = "BUYER";
    private final String SUPERVISOR_ROLE = "SUPERVISOR";


    @Test
    @WithMockUser(username = "buyer_user", authorities = {BUYER_ROLE})
    public void testUpdateOrder_Success() throws Exception {
        Long orderId = 1L;

        PurchaseOrderRequestDTO requestDTO = TestUtils.createValidPurchaseOrderRequestDTO();

        when(orderService.updateOrderById(orderId, requestDTO)).thenReturn(requestDTO);

        mockMvc.perform(put("/api/v1/fresh-products/orders/{orderId}", orderId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDTO)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "buyer_user", authorities = {BUYER_ROLE})
    public void testUpdateOrder_OrderNotFound() throws Exception {
        Long orderId = 2L;

        PurchaseOrderRequestDTO requestDTO = TestUtils.createValidPurchaseOrderRequestDTO();

        when(orderService.updateOrderById(orderId, requestDTO))
                .thenThrow(new NotFoundException("Order not found with id: " + orderId));

        mockMvc.perform(put("/api/v1/fresh-products/orders/{orderId}", orderId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDTO)))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    @WithMockUser(username = "buyer_user", authorities = {BUYER_ROLE})
    public void testUpdateOrder_ProductNotFound() throws Exception {
        Long orderId = 1L;

        PurchaseOrderRequestDTO requestDTO = TestUtils.createValidPurchaseOrderRequestDTO();

        when(orderService.updateOrderById(orderId, requestDTO))
                .thenThrow(new NotFoundException("Product not found with id: " + requestDTO.getOrderRequestDTO().getProducts().get(0).getProductId()));

        mockMvc.perform(put("/api/v1/fresh-products/orders/{orderId}", orderId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDTO)))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    @WithMockUser(username = "buyer_user", authorities = {SUPERVISOR_ROLE})
    void testGetProductStockInWarehouses_Success() throws Exception {
        Long idProduct = 1L;

        WarehouseStockDto warehouseStockDto = new WarehouseStockDto(1, 50);
        ProductWarehouseDTO productWarehouseDTO = new ProductWarehouseDTO(idProduct.intValue(), List.of(warehouseStockDto));

        when(freshProductService.searchProductStockInWarehouses(idProduct)).thenReturn(productWarehouseDTO);

        mockMvc.perform(get("/api/v1/fresh-products/{idProduct}/warehouse/list", idProduct)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.product_id").value(idProduct.intValue()))
                .andExpect(jsonPath("$.warehouses[0].warehouse_code").value(1))
                .andExpect(jsonPath("$.warehouses[0].total_quantity").value(50));
    }

    @Test
    @WithMockUser(username = "buyer_user", authorities = {SUPERVISOR_ROLE})
    void testGetProductStockInWarehouses_ProductNotFound() throws Exception {
        Long idProduct = 1L;

        when(freshProductService.searchProductStockInWarehouses(idProduct))
                .thenThrow(new NotFoundException("Product not found with id: " + idProduct));

        mockMvc.perform(get("/api/v1/fresh-products/{idProduct}/warehouse/list", idProduct)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    @WithMockUser(username = "buyer_user", authorities = {SUPERVISOR_ROLE})
    void testGetProductStockInWarehouses_NoStock() throws Exception {
        Long idProduct = 2L;

        ProductWarehouseDTO productWarehouseDTO = new ProductWarehouseDTO(idProduct.intValue(), List.of());

        when(freshProductService.searchProductStockInWarehouses(idProduct)).thenReturn(productWarehouseDTO);

        mockMvc.perform(get("/api/v1/fresh-products/{idProduct}/warehouse/list", idProduct)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.product_id").value(idProduct.intValue()))
                .andExpect(jsonPath("$.warehouses").isEmpty());
    }

    @Test
    @WithMockUser(username = "buyer_user", authorities = {BUYER_ROLE})
    public void testSaveOrder_DuplicateOrder() throws Exception {
        PurchaseOrderRequestDTO requestDTO = TestUtils.createValidPurchaseOrderRequestDTO();

        requestDTO.getOrderRequestDTO().setBuyerId(9);

        when(orderRepository.findByBuyerId(anyLong())).thenReturn(Optional.of(new Order()));

        when(orderService.saveOrder(Mockito.any(PurchaseOrderRequestDTO.class)))
                .thenThrow(new ConflictException(
                        "Ya existe una orden para el comprador con ID: " + requestDTO.getOrderRequestDTO().getBuyerId()));

        mockMvc.perform(post("/api/v1/fresh-products/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDTO)))
                .andDo(print())
                .andExpect(status().isConflict())
                .andExpect(jsonPath("$.message").value("Ya existe una orden para el comprador con ID: 9"));
    }

    @Test
    @WithMockUser(username = "buyer_user", authorities = {BUYER_ROLE})
    public void testSaveOrder_ProductNotFound() throws Exception {
        PurchaseOrderRequestDTO requestDTO = TestUtils.createValidPurchaseOrderRequestDTO();

        ProductRequestDTO productRequestDTO = requestDTO.getOrderRequestDTO().getProducts().get(0);
        when(productRepository.findById(anyLong())).thenReturn(Optional.empty());

        when(orderService.saveOrder(Mockito.any(PurchaseOrderRequestDTO.class)))
                .thenThrow(new NotFoundException(
                        "Producto con ID " + requestDTO.getOrderRequestDTO().getProducts().get(0).getProductId() + " no encontrado"));

        mockMvc.perform(post("/api/v1/fresh-products/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDTO)))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("Producto con ID " + productRequestDTO.getProductId() + " no encontrado"));

    }

    @Test
    @WithMockUser(username = "buyer_user", authorities = {BUYER_ROLE})
    void testGetProductStock_Success() throws Exception {
        Long warehouseId = 1L;
        Long productId = 2L;

        ProductStockDTO productStockDTO = new ProductStockDTO();
        productStockDTO.setId(productId);
        productStockDTO.setName("Harina");
        productStockDTO.setUnitaryPrice(10.5);
        productStockDTO.setQuantity(100);
        productStockDTO.setType(ProductType.FRESH);
        List<ProductStockDTO> productStockList = List.of(productStockDTO);

        when(orderService.getProductStockByWarehouse(warehouseId, productId)).thenReturn(productStockList);

        mockMvc.perform(get("/api/v1/fresh-products/stock")
                        .param("warehouseId", warehouseId.toString())
                        .param("productId", productId.toString())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(productId))
                .andExpect(jsonPath("$[0].quantity").value(100));
    }


}