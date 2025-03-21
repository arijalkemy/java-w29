package com.mercadolibre.final_project_bootcamp_esp_2.unit.service;

import com.mercadolibre.final_project_bootcamp_esp_2.dto.ProductStockDTO;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.request.OrderRequestDTO;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.request.ProductRequestDTO;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.request.PurchaseOrderRequestDTO;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.response.AddToCartResponseDTO;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.response.ProductDTO;
import com.mercadolibre.final_project_bootcamp_esp_2.exceptions.BadRequestException;
import com.mercadolibre.final_project_bootcamp_esp_2.exceptions.NotFoundException;
import com.mercadolibre.final_project_bootcamp_esp_2.model.*;
import com.mercadolibre.final_project_bootcamp_esp_2.model.util.ProductType;
import com.mercadolibre.final_project_bootcamp_esp_2.model.util.UserRole;
import com.mercadolibre.final_project_bootcamp_esp_2.repository.IOrderRepository;
import com.mercadolibre.final_project_bootcamp_esp_2.repository.IProductRepository;
import com.mercadolibre.final_project_bootcamp_esp_2.repository.IUserRepository;
import com.mercadolibre.final_project_bootcamp_esp_2.service.OrderServiceImpl;
import com.mercadolibre.final_project_bootcamp_esp_2.util.TestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OrderServiceImplTest {

    @Mock
    private IOrderRepository orderRepository;

    @Mock
    private IProductRepository productRepository;

    @Mock
    private IUserRepository userRepository;

    @InjectMocks
    private OrderServiceImpl orderService;

    private User buyer;
    private Product product;
    private Order order;
    private ProductRequestDTO productRequestDTO;
    private PurchaseOrderRequestDTO purchaseOrderRequestDTO;

    @BeforeEach
    void setUp() {
        // Crear datos de prueba
        buyer = new User(1L, "buyer_john", "John Doe", "password", UserRole.BUYER);
        product = new Product(1L, "Leche", 100.0, null, null);
        productRequestDTO = new ProductRequestDTO(1, 2); // Producto ID 1, Cantidad 2

        OrderRequestDTO orderRequestDTO = new OrderRequestDTO();
        orderRequestDTO.setBuyerId(1);
        orderRequestDTO.setDate(Date.from(Instant.now()));
        orderRequestDTO.setProducts(List.of(productRequestDTO));

        purchaseOrderRequestDTO = new PurchaseOrderRequestDTO(orderRequestDTO);

        order = new Order();
        order.setId(1L);
        order.setBuyer(buyer);
        order.setDate(LocalDate.now());
    }

    @Test
    void testSearchProductsInOrder_Success() {
        // Arrange
        Long orderId = 1L;

        Product product1 = new Product(1L, "Producto 1", 100.0, null, null);
        Product product2 = new Product(2L, "Producto 2", 200.0, null, null);

        OrderProduct orderProduct1 = new OrderProduct(1L, order, product1, 2);
        OrderProduct orderProduct2 = new OrderProduct(2L, order, product2, 5);

        order.setOrderProducts(List.of(orderProduct1, orderProduct2));

        when(orderRepository.findById(orderId)).thenReturn(Optional.of(order));

        List<ProductDTO> result = orderService.searchProductsInOrder(orderId);

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(1L, result.get(0).getId());
        assertEquals(2, result.get(0).getQuantity());
        assertEquals(2L, result.get(1).getId());
        assertEquals(5, result.get(1).getQuantity());

        verify(orderRepository, times(1)).findById(orderId);
    }

    @Test
    void testSearchProductsInOrder_OrderNotFound() {
        // Arrange
        Long orderId = 999L;
        when(orderRepository.findById(orderId)).thenReturn(Optional.empty());

        // Act & Assert
        NotFoundException exception = assertThrows(NotFoundException.class, () -> {
            orderService.searchProductsInOrder(orderId);
        });

        assertEquals("Order 999 not found", exception.getMessage());

        verify(orderRepository, times(1)).findById(orderId);
    }

    @Test
    void testSaveOrder_Success() {
        // Arrange: Configurar simulaciones de repositorios
        when(orderRepository.findByBuyerId(1L)).thenReturn(Optional.empty());
        when(userRepository.findById(1L)).thenReturn(Optional.of(buyer));
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        when(productRepository.findBatchesByProductAndDueDateGreaterThan(anyLong(), any())).thenReturn(
                List.of(new Batch(1L, 1, product, 5.0, 1.0, 10, 10, LocalDate.now(), LocalDateTime.now(), LocalDate.now(), null))
        );
        when(orderRepository.save(any())).thenReturn(order);

        // Act
        AddToCartResponseDTO response = orderService.saveOrder(purchaseOrderRequestDTO);

        // Assert
        assertNotNull(response);
        assertEquals(200.0, response.getTotalPrice()); // 2 productos * 100.0 cada uno
        verify(orderRepository, times(1)).save(any(Order.class));
    }

    @Test
    void testSaveOrder_BuyerNotFound() {
        // Arrange
        when(orderRepository.findByBuyerId(1L)).thenReturn(Optional.empty());
        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        // Act & Assert
        NotFoundException exception = assertThrows(NotFoundException.class, () -> orderService.saveOrder(purchaseOrderRequestDTO));

        assertEquals("Buyer not found with id: 1", exception.getMessage());
    }

    @Test
    void testSaveOrder_InsufficientStock() {
        // Arrange
        when(orderRepository.findByBuyerId(1L)).thenReturn(Optional.empty());
        when(userRepository.findById(1L)).thenReturn(Optional.of(buyer));
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        when(productRepository.findBatchesByProductAndDueDateGreaterThan(anyLong(), any())).thenReturn(
                List.of(new Batch(1L, 1, product, 5.0, 1.0, 1, 1, LocalDate.now(), LocalDateTime.now(), LocalDate.now(), null)) // Solo 1 en stock
        );

        // Act & Assert
        BadRequestException exception = assertThrows(BadRequestException.class, () -> orderService.saveOrder(purchaseOrderRequestDTO));

        assertEquals("Insufficient stock of the product: Leche", exception.getMessage());
        assertTrue(exception.getMessage().contains("Insufficient stock of the product: Leche"));
    }

    @Test
    void testUpdateOrderById_Success() {
        Long orderId = 1L;
        PurchaseOrderRequestDTO requestDTO = TestUtils.createValidPurchaseOrderRequestDTO();

        Order mockOrder = new Order();
        mockOrder.setOrderProducts(new ArrayList<>());

        when(orderRepository.findById(orderId)).thenReturn(Optional.of(mockOrder));
        when(productRepository.findById(anyLong())).thenReturn(Optional.of(new Product()));

        PurchaseOrderRequestDTO result = orderService.updateOrderById(orderId, requestDTO);

        assertNotNull(result);
        assertEquals(requestDTO, result);
        verify(orderRepository).save(mockOrder);
    }

    @Test
    void testUpdateOrderById_OrderNotFound() {
        Long orderId = 1L;
        PurchaseOrderRequestDTO requestDTO = TestUtils.createValidPurchaseOrderRequestDTO();

        when(orderRepository.findById(orderId)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> orderService.updateOrderById(orderId, requestDTO));
    }

    @Test
    void testUpdateOrderById_ProductNotFound() {
        Long orderId = 1L;
        PurchaseOrderRequestDTO requestDTO = TestUtils.createValidPurchaseOrderRequestDTO();
        Order mockOrder = new Order();

        when(orderRepository.findById(orderId)).thenReturn(Optional.of(mockOrder));
        when(productRepository.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> orderService.updateOrderById(orderId, requestDTO));
    }

    @Test
    void testGetProductsByWarehouse_Success() {
        Long warehouseId = 1L;
        Long productId = 2L;

        List<Product> mockProducts = List.of(
                Product.builder().id(2L).name("Leche").unitaryPrice(800.50).type(ProductType.REFRIGERATED).build(),
                Product.builder().id(3L).name("Harina").unitaryPrice(450.00).type(ProductType.FRESH).build()
        );

        when(productRepository.findProductsInWarehouse(warehouseId, productId)).thenReturn(mockProducts);

        List<Product> result = orderService.getProductsByWarehouse(warehouseId, productId);

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Leche", result.get(0).getName());
        assertEquals(ProductType.REFRIGERATED, result.get(0).getType());

        verify(productRepository, times(1)).findProductsInWarehouse(warehouseId, productId);
    }

    @Test
    void testGetProductStockByWarehouse_NoResults() {
        Long warehouseId = 1L;
        Long productId = 2L;

        when(productRepository.findProductStockByWarehouse(warehouseId, productId)).thenReturn(List.of());

        List<ProductStockDTO> result = orderService.getProductStockByWarehouse(warehouseId, productId);

        assertNotNull(result);
        assertTrue(result.isEmpty());

        verify(productRepository, times(1)).findProductStockByWarehouse(warehouseId, productId);
    }

    @Test
    void testGetProductStockByWarehouse_Success() {
        Long warehouseId = 1L;
        Long productId = 2L;

        Object[] mockQueryResult = {2L, "Leche", 800.50, 5, "REFRIGERATED"};
        List<Object[]> mockQueryResults = Collections.singletonList(mockQueryResult);

        when(productRepository.findProductStockByWarehouse(warehouseId, productId)).thenReturn(mockQueryResults);

        List<ProductStockDTO> result = orderService.getProductStockByWarehouse(warehouseId, productId);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(2L, result.get(0).getId());
        assertEquals("Leche", result.get(0).getName());
        assertEquals(800.50, result.get(0).getUnitaryPrice());
        assertEquals(5, result.get(0).getQuantity());
        assertEquals(ProductType.REFRIGERATED, result.get(0).getType());

        verify(productRepository, times(1)).findProductStockByWarehouse(warehouseId, productId);
    }

    @Test
    void testSaveOrder_DuplicateOrder() {
        lenient().when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        lenient().when(productRepository.findBatchesByProductAndDueDateGreaterThan(anyLong(), any())).thenReturn(Collections.emptyList());
        assertThrows(NotFoundException.class, () -> orderService.saveOrder(purchaseOrderRequestDTO));
    }

    @Test
    void testUpdateOrderById_AddNewAndExistingProducts() {
        Long orderId = 1L;
        PurchaseOrderRequestDTO requestDTO = TestUtils.createValidPurchaseOrderRequestDTO();

        Order existingOrder = new Order();
        existingOrder.setOrderProducts(new ArrayList<>());
        when(orderRepository.findById(orderId)).thenReturn(Optional.of(existingOrder));
        when(productRepository.findById(anyLong())).thenReturn(Optional.of(product));

        PurchaseOrderRequestDTO result = orderService.updateOrderById(orderId, requestDTO);

        assertNotNull(result);
        assertEquals(requestDTO, result);
        verify(orderRepository).save(existingOrder);
    }

    @Test
    void testSaveOrder_ProductNotFoundInAddProductsToOrder() {
        when(orderRepository.findByBuyerId(1L)).thenReturn(Optional.empty());
        when(userRepository.findById(1L)).thenReturn(Optional.of(buyer));
        when(productRepository.findById(anyLong())).thenReturn(Optional.empty());
        BadRequestException exception = assertThrows(BadRequestException.class, () -> orderService.saveOrder(purchaseOrderRequestDTO));
        assertEquals("Product 1 not found", exception.getMessage());
    }

    @Test
    void testSaveOrder_NotEnoughStockAfterProcessingBatches() {
        when(orderRepository.findByBuyerId(1L)).thenReturn(Optional.empty());
        when(userRepository.findById(1L)).thenReturn(Optional.of(buyer));
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        when(productRepository.findBatchesByProductAndDueDateGreaterThan(anyLong(), any())).thenReturn(
                List.of(new Batch(1L, 1, product, 5.0, 1.0, 1, 1, LocalDate.now(), LocalDateTime.now(), LocalDate.now(), null))
        );
        BadRequestException exception = assertThrows(BadRequestException.class, () -> orderService.saveOrder(purchaseOrderRequestDTO));
        assertEquals("Insufficient stock of the product: Leche", exception.getMessage());
    }


    @Test
    void testUpdateOrderById_ProductsIsNull() {
        Long orderId = 1L;

        Order existingOrder = new Order();
        existingOrder.setOrderProducts(new ArrayList<>());

        OrderRequestDTO orderRequestDTO = new OrderRequestDTO();
        orderRequestDTO.setBuyerId(1);
        orderRequestDTO.setDate(Date.from(Instant.now()));
        orderRequestDTO.setProducts(null);

        PurchaseOrderRequestDTO requestDTO = new PurchaseOrderRequestDTO(orderRequestDTO);

        when(orderRepository.findById(orderId)).thenReturn(Optional.of(existingOrder));

        PurchaseOrderRequestDTO result = orderService.updateOrderById(orderId, requestDTO);

        assertNotNull(result);
        assertEquals(requestDTO, result);

        verify(orderRepository).save(existingOrder);
    }

    @Test
    void testSaveOrder_OrderDateInTheFuture() {
        //Arrange
        LocalDate futureDate = LocalDate.now().plusDays(1);

        OrderRequestDTO orderRequestDTO = new OrderRequestDTO();
        orderRequestDTO.setBuyerId(1);
        orderRequestDTO.setDate(Date.from(futureDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        orderRequestDTO.setProducts(List.of(productRequestDTO));

        PurchaseOrderRequestDTO purchaseOrderRequestDTO = new PurchaseOrderRequestDTO(orderRequestDTO);

        when(orderRepository.findByBuyerId(1L)).thenReturn(Optional.empty());
        when(userRepository.findById(1L)).thenReturn(Optional.of(buyer));

        //Act - Assert
        BadRequestException exception = assertThrows(BadRequestException.class, () -> {
            orderService.saveOrder(purchaseOrderRequestDTO);
        });

        assertEquals("The order date cannot be in the future.", exception.getMessage());

        verify(orderRepository, times(0)).save(any(Order.class));

    }

}
