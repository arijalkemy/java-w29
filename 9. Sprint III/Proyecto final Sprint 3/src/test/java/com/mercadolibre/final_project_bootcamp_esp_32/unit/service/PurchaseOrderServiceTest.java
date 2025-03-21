package com.mercadolibre.final_project_bootcamp_esp_32.unit.service;

import com.mercadolibre.final_project_bootcamp_esp_32.dtos.request.ProductPurchaseOrderDTO;
import com.mercadolibre.final_project_bootcamp_esp_32.dtos.request.PurchaseOrderRequestDto;
import com.mercadolibre.final_project_bootcamp_esp_32.dtos.response.*;
import com.mercadolibre.final_project_bootcamp_esp_32.entities.*;
import com.mercadolibre.final_project_bootcamp_esp_32.enums.ProductType;
import com.mercadolibre.final_project_bootcamp_esp_32.enums.StatusOrder;
import com.mercadolibre.final_project_bootcamp_esp_32.exceptions.ApiException;
import com.mercadolibre.final_project_bootcamp_esp_32.projection.Top5MostSoldProductProjection;
import com.mercadolibre.final_project_bootcamp_esp_32.repository.*;
import com.mercadolibre.final_project_bootcamp_esp_32.service.AuthService;
import com.mercadolibre.final_project_bootcamp_esp_32.service.InboundOrderService;
import com.mercadolibre.final_project_bootcamp_esp_32.service.PurchaseOrderServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PurchaseOrderServiceTest {

    @Mock
    IInboundOrderRepository inboundOrderRepository;

    @Mock
    ISectionRepository sectionRepository;

    @Mock
    IWarehouseRepository warehouseRepository;

    @Mock
    IProductBatchRepository productBatchRepository;

    @Mock
    IBatchRepository batchRepository;

    @Mock
    IBuyerRepository buyerRepository;

    @Mock
    IProductRepository productRepository;

    @Mock
    IPurchaseOrderRepository purchaseOrderRepository;

    @Mock
    IProductPurchaseOrderRepository productPurchaseOrderRepository;

    @Mock
    AuthService authService;

    @Mock
    HttpServletRequest httpServletRequest;

    @InjectMocks
    PurchaseOrderServiceImpl purchaseOrderService;

    @InjectMocks
    InboundOrderService inboundOrderService;

    @Test
    @DisplayName("Create purchase order- success")
    void createPurchaseOrder() {
        // Arrange
        Buyer buyer = new Buyer();
        buyer.setId(1);

        Seller seller = new Seller();
        seller.setId(2);

        List<ProductPurchaseOrderDTO> products = Arrays.asList(
                new ProductPurchaseOrderDTO(2,25)
        );

        Warehouse warehouse = new Warehouse();
        warehouse.setWarehouseCode(2);

        Section section = new Section(2,warehouse,ProductType.FF);

        Product product = new Product(2,"Product B",20.75,ProductType.FF,seller);

        LocalDate threeMonthsFromNow = LocalDate.now().plusMonths(3);
        String dateTimeString = "2025-02-20 14:30:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime manufacturingTime = LocalDateTime.parse(dateTimeString, formatter);
        LocalDate manufacturingDate = LocalDate.parse("2026-07-10");
        LocalDate dueDate = LocalDate.parse("2025-02-20");

        ProductBatch batch = new ProductBatch(1,103,22.0,18.5,300,600,dueDate,manufacturingDate,manufacturingTime,product,section,null);
        List<ProductBatch> productBatchList = List.of(batch);

        PurchaseOrderRequestDto order = new PurchaseOrderRequestDto(LocalDate.now(),1, StatusOrder.CART,products);

        PurchaseOrderResponseDto expected = new PurchaseOrderResponseDto();

        expected.setOrderId(1);

        expected.setTotalPrice(518.75);

        expected.setProductErrors(new ArrayList<>());

        PurchaseOrder orderSave = new PurchaseOrder(null,buyer,LocalDate.now(),StatusOrder.CART);

        PurchaseOrder orderSaved = new PurchaseOrder(1,buyer,LocalDate.now(),StatusOrder.CART);

        List<ProductPurchaseOrder> productPurchaseOrderListSave =  List.of(
                new ProductPurchaseOrder(null,orderSaved,product,25)
        );
        List<ProductPurchaseOrder> productPurchaseOrderList =  List.of(
                new ProductPurchaseOrder(1,orderSaved,product,25)
        );
        expected.setTotalPrice(518.75);
        expected.setProductErrors(new ArrayList<>());

        when(buyerRepository.findById(1)).thenReturn(Optional.of(buyer));
        when(productRepository.findById(2)).thenReturn(Optional.of(product));
        when(batchRepository.sumCurrentQuantity(product.getId(),threeMonthsFromNow)).thenReturn(600);
        when(purchaseOrderRepository.save(orderSave)).thenReturn(orderSaved);
        when(productPurchaseOrderRepository.saveAll(productPurchaseOrderListSave)).thenReturn(productPurchaseOrderList);

        // Act
        PurchaseOrderResponseDto actual = purchaseOrderService.createPurchaseOrder(order);

        //Assert
        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Create purchase order - bad request")
    void notCreatePurchaseOrder() {
        // Arrange
        Buyer buyer = new Buyer();
        buyer.setId(1);
        Seller seller = new Seller();
        seller.setId(2);
        List<ProductPurchaseOrderDTO> products = Arrays.asList(
                new ProductPurchaseOrderDTO(2,25000)
        );
        Warehouse warehouse = new Warehouse();
        warehouse.setWarehouseCode(2);
        Section section = new Section(2,warehouse,ProductType.FF);
        Product product = new Product(2,"Product B",20.75,ProductType.FF,seller);
        String dateTimeString = "2025-02-20 14:30:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime manufacturingTime = LocalDateTime.parse(dateTimeString, formatter);
        LocalDate manufacturingDate = LocalDate.parse("2026-07-10");
        LocalDate dueDate = LocalDate.parse("2025-02-20");
        ProductBatch batch = new ProductBatch(1,103,22.0,18.5,300,600,dueDate,manufacturingDate,manufacturingTime,product,section,null);
        List<ProductBatch> productBatchList = List.of(batch);
        PurchaseOrderRequestDto order = new PurchaseOrderRequestDto(LocalDate.now(),1, StatusOrder.CART,products);
        PurchaseOrder orderSaved = new PurchaseOrder(1,buyer,LocalDate.now(),StatusOrder.CART);
        List<ProductPurchaseOrder> productPurchaseOrderListSave =  List.of(
                new ProductPurchaseOrder(null,orderSaved,product,25)
        );

        when(buyerRepository.findById(1)).thenReturn(Optional.of(buyer));
        when(productRepository.findById(2)).thenReturn(Optional.of(product));
        // Act
        PurchaseOrderResponseDto actual = purchaseOrderService.createPurchaseOrder(order);

        //Assert
        assertEquals(0.0,actual.getTotalPrice());
    }

    @Test
    @DisplayName("Create purchase order- Not found")
    void createPurchaseOrderWithoutBuyer() {
        // Arrange
        List<ProductPurchaseOrderDTO> products = Arrays.asList(
                new ProductPurchaseOrderDTO(2,25000)
        );
        PurchaseOrderRequestDto order = new PurchaseOrderRequestDto(LocalDate.now(),1, StatusOrder.CART,products);
        when(buyerRepository.findById(1)).thenReturn(Optional.empty());

        //Assert
        assertThrows(ApiException.class, () -> purchaseOrderService.createPurchaseOrder(order));
    }

    @Test
    @DisplayName("listProductsByPurchaseOrder- success")
    void listProductsByPurchaseOrder() {
        // Arrange
        Integer idOrder = 1;
        Buyer buyer = new Buyer();
        buyer.setId(1);
        Seller seller = new Seller();
        seller.setId(2);
        PurchaseOrder orderSaved = new PurchaseOrder(1,buyer,LocalDate.now(),StatusOrder.CART);
        Product product = new Product(2,"Product B",20.75,ProductType.FF,seller);
        List<ProductPurchaseOrder> productPurchaseOrderList =  List.of(
                new ProductPurchaseOrder(1,orderSaved,product,25)
        );
        List<ProductResponseDto> respList = List.of(
                new ProductResponseDto(2,"Product B",25)
        );
        ProductsPurchaseOrderDto expected = new ProductsPurchaseOrderDto(respList);
        when(purchaseOrderRepository.findById(idOrder)).thenReturn(Optional.of(orderSaved));
        when(productPurchaseOrderRepository.findByPurchaseOrder_Id(idOrder)).thenReturn(productPurchaseOrderList);

        // Act
        ProductsPurchaseOrderDto actual = purchaseOrderService.listProductsByPurchaseOrder(idOrder);

        //Assert
        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("listProductsByPurchaseOrder- Not found")
    void listProductsByPurchaseOrderNotFound() {
        // Arrange
        Integer idOrder = 1;
        when(purchaseOrderRepository.findById(idOrder)).thenReturn(Optional.empty());

        //Assert
        assertThrows(ApiException.class, () -> purchaseOrderService.listProductsByPurchaseOrder(idOrder));
    }

    @Test
    @DisplayName("Update purchase order- success")
    void updatePurchaseOrder_Success_Simple() {
        Buyer buyer = new Buyer();
        buyer.setId(1);

        PurchaseOrder existingOrder = new PurchaseOrder();
        existingOrder.setId(3);
        existingOrder.setBuyer(buyer);
        existingOrder.setStatus(StatusOrder.CART);

        Product product = new Product(2, "Product B", 20.75, ProductType.FF, new Seller());

        ProductBatch batch = new ProductBatch();
        batch.setId(102);
        batch.setCurrentQuantity(600);
        batch.setDueDate(LocalDate.now().plusMonths(6));

        List<ProductPurchaseOrderDTO> productsDTO = List.of(
                new ProductPurchaseOrderDTO(2, 5)
        );

        PurchaseOrderRequestDto updateRequest = new PurchaseOrderRequestDto(LocalDate.now(), 1, StatusOrder.CART, productsDTO);

        lenient().when(purchaseOrderRepository.findById(3)).thenReturn(Optional.of(existingOrder));
        lenient().when(buyerRepository.findById(1)).thenReturn(Optional.of(buyer));
        lenient().when(productRepository.findById(2)).thenReturn(Optional.of(product));
        lenient().when(batchRepository.findByProduct_Id(2)).thenReturn(List.of(batch));

        when(batchRepository.sumCurrentQuantity(eq(2), any())).thenReturn(600);

        doNothing().when(productPurchaseOrderRepository).deleteByOrderId(3);

        when(productPurchaseOrderRepository.saveAll(anyList()))
                .thenAnswer(invocation -> invocation.getArgument(0));

        PurchaseOrderResponseDto response = purchaseOrderService.updatePurchaseOrder(3, updateRequest);

        assertEquals(103.75, response.getTotalPrice(), 0.01);
        assertEquals(0, response.getProductErrors().size());

        verify(productPurchaseOrderRepository, times(1)).deleteByOrderId(3);
        verify(productPurchaseOrderRepository, times(1)).saveAll(anyList());
    }

    @Test
    @DisplayName("Update purchase order - buyer not found")
    void updatePurchaseOrder_BuyerNotFound() {
        Buyer existingBuyer = new Buyer();
        existingBuyer.setId(1);

        PurchaseOrder existingOrder = new PurchaseOrder();
        existingOrder.setId(3);
        existingOrder.setBuyer(existingBuyer);
        existingOrder.setStatus(StatusOrder.CART);

        PurchaseOrderRequestDto updateRequest = new PurchaseOrderRequestDto(LocalDate.now(), 99, StatusOrder.CART, List.of());

        when(purchaseOrderRepository.findById(3)).thenReturn(Optional.of(existingOrder));
        when(buyerRepository.findById(99)).thenReturn(Optional.empty()); // Simula Buyer no encontrado

        ApiException exception = assertThrows(ApiException.class, () -> {
            purchaseOrderService.updatePurchaseOrder(3, updateRequest);
        });

        assertEquals("Buyer not found", exception.getMessage());

        verify(purchaseOrderRepository).findById(3);
        verify(buyerRepository, times(1)).findById(99);
    }

    @Test
    @DisplayName("Update purchase order - product not found")
    void updatePurchaseOrder_ProductNotFound() {
        Buyer buyer = new Buyer();
        buyer.setId(1);

        PurchaseOrder existingOrder = new PurchaseOrder();
        existingOrder.setId(3);
        existingOrder.setBuyer(buyer);
        existingOrder.setStatus(StatusOrder.CART);

        List<ProductPurchaseOrderDTO> productsDTO = List.of(new ProductPurchaseOrderDTO(999, 5));

        PurchaseOrderRequestDto updateRequest = new PurchaseOrderRequestDto(LocalDate.now(), 1, StatusOrder.CART, productsDTO);

        when(purchaseOrderRepository.findById(3)).thenReturn(Optional.of(existingOrder));
        when(productRepository.findById(999)).thenReturn(Optional.empty());

        ApiException exception = assertThrows(ApiException.class, () -> {
            purchaseOrderService.updatePurchaseOrder(3, updateRequest);
        });

        assertEquals("Producto no encontrado", exception.getMessage());

        verify(purchaseOrderRepository).findById(3);
        verify(productRepository).findById(999);
    }

    @Test
    @DisplayName("Update purchase order - invalid product quantity")
    void updatePurchaseOrder_InvalidQuantity() {
        Buyer buyer = new Buyer();
        buyer.setId(1);

        PurchaseOrder existingOrder = new PurchaseOrder();
        existingOrder.setId(3);
        existingOrder.setBuyer(buyer);
        existingOrder.setStatus(StatusOrder.CART);

        Product product = new Product(2, "Product B", 20.75, ProductType.FF, new Seller());

        List<ProductPurchaseOrderDTO> productsDTO = List.of(new ProductPurchaseOrderDTO(2, -5)); // Cantidad negativa

        PurchaseOrderRequestDto updateRequest = new PurchaseOrderRequestDto(LocalDate.now(), 1, StatusOrder.CART, productsDTO);

        lenient().when(purchaseOrderRepository.findById(3)).thenReturn(Optional.of(existingOrder));
        lenient().when(productRepository.findById(2)).thenReturn(Optional.of(product));

        ApiException exception = assertThrows(ApiException.class, () -> {
            purchaseOrderService.updatePurchaseOrder(3, updateRequest);
        });

        assertEquals("400", exception.getCode());
        assertEquals("La cantidad del producto debe ser mayor a 0", exception.getMessage());

        verify(purchaseOrderRepository).findById(3);
        verify(productRepository, never()).findById(anyInt());
    }

    @Test
    @DisplayName("Update purchase order - product out of stock")
    void updatePurchaseOrder_ProductOutOfStock() {
        Buyer buyer = new Buyer();
        buyer.setId(1);

        PurchaseOrder existingOrder = new PurchaseOrder();
        existingOrder.setId(3);
        existingOrder.setBuyer(buyer);
        existingOrder.setStatus(StatusOrder.CART);

        List<ProductPurchaseOrderDTO> productsDTO = List.of(new ProductPurchaseOrderDTO(999, 5));

        PurchaseOrderRequestDto updateRequest = new PurchaseOrderRequestDto(LocalDate.now(), 1, StatusOrder.CART, productsDTO);

        when(purchaseOrderRepository.findById(3)).thenReturn(Optional.of(existingOrder));
        when(buyerRepository.findById(1)).thenReturn(Optional.of(buyer));

        Product product = new Product();
        product.setId(999);
        product.setName("Producto sin stock");

        when(productRepository.findById(999)).thenReturn(Optional.of(product), Optional.of(product));
        when(batchRepository.sumCurrentQuantity(999, LocalDate.now().plusMonths(3))).thenReturn(0);

        PurchaseOrderResponseDto response = purchaseOrderService.updatePurchaseOrder(3, updateRequest);

        assertEquals(1, response.getProductErrors().size());
        assertEquals("No hay suficiente stock disponible", response.getProductErrors().get(0).getErrorMessage());

        verify(purchaseOrderRepository).findById(3);
        verify(productRepository, times(2)).findById(999); // Se llama 2 veces
        verify(batchRepository).sumCurrentQuantity(999, LocalDate.now().plusMonths(3));
    }

    @Test
    void testSearchPurchasedProductsByDateRange() {
        //Arrange
        LocalDate thirtyDaysAgo = LocalDate.now().minusDays(30);
        Long totalProducts = 100L;
        List<ProductMostOrdererDto> topFiveProducts = Arrays.asList(
                new ProductMostOrdererDto(1, "Product 1", 60L),
                new ProductMostOrdererDto(2, "Product 2", 25L),
                new ProductMostOrdererDto(3, "Product 3", 15L)
        );
        List<Top5MostSoldProductProjection> top5MostSoldProductProjection;
        top5MostSoldProductProjection = new ArrayList<>();
        Top5MostSoldProductProjection top5MostSoldProductProjection1 = new Top5MostSoldProductProjection() {
            @Override
            public Integer getProductId() {return 1;}
            @Override
            public String getProductName() {return "Product 1";}
            @Override
            public Long getTotalSold() {return 60L;}
        };
        Top5MostSoldProductProjection top5MostSoldProductProjection2 = new Top5MostSoldProductProjection() {
            @Override
            public Integer getProductId() {return 2;}
            @Override
            public String getProductName() {return "Product 2";}
            @Override
            public Long getTotalSold() {return 25L;}
        };
        Top5MostSoldProductProjection top5MostSoldProductProjection3 = new Top5MostSoldProductProjection() {
            @Override
            public Integer getProductId() {return 3;}
            @Override
            public String getProductName() {return "Product 3";}
            @Override
            public Long getTotalSold() {return 15L;}
        };
        top5MostSoldProductProjection.add(top5MostSoldProductProjection1);
        top5MostSoldProductProjection.add(top5MostSoldProductProjection2);
        top5MostSoldProductProjection.add(top5MostSoldProductProjection3);
        InternalUser internalUser = new InternalUser();
        internalUser.setId(1);

        when(authService.validateInternalUser(any())).thenReturn(internalUser);
        when(purchaseOrderRepository.getTotalOrderedProductsInLast30Days(thirtyDaysAgo)).thenReturn(totalProducts);
        when(purchaseOrderRepository.findTop5MostSoldProductsInLast30Days(thirtyDaysAgo)).thenReturn(top5MostSoldProductProjection);

        //Act
        PurchasedProductsByDateRangeDto result = purchaseOrderService.searchPurchasedProductsByDateRange(httpServletRequest);

        // Assert
        assertNotNull(result);
        assertEquals(totalProducts, result.getProductsOrdered());
        assertEquals(3, result.getTop_products().size());
        verify(purchaseOrderRepository).getTotalOrderedProductsInLast30Days(thirtyDaysAgo);
        verify(purchaseOrderRepository).findTop5MostSoldProductsInLast30Days(thirtyDaysAgo);
    }

}
