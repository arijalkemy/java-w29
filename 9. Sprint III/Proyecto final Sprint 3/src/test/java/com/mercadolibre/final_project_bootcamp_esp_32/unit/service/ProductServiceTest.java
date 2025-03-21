package com.mercadolibre.final_project_bootcamp_esp_32.unit.service;

import com.mercadolibre.final_project_bootcamp_esp_32.dtos.request.ProductDTO;
import com.mercadolibre.final_project_bootcamp_esp_32.dtos.response.WarehouseStockDto;
import com.mercadolibre.final_project_bootcamp_esp_32.dtos.response.ProductWarehouseResponseDto;
import com.mercadolibre.final_project_bootcamp_esp_32.dtos.response.ResponseProductDTO;
import com.mercadolibre.final_project_bootcamp_esp_32.entities.InternalUser;
import com.mercadolibre.final_project_bootcamp_esp_32.entities.Product;
import com.mercadolibre.final_project_bootcamp_esp_32.entities.Seller;
import com.mercadolibre.final_project_bootcamp_esp_32.enums.ProductType;
import com.mercadolibre.final_project_bootcamp_esp_32.exceptions.ApiException;
import com.mercadolibre.final_project_bootcamp_esp_32.exceptions.NotFoundException;
import com.mercadolibre.final_project_bootcamp_esp_32.projection.ProductProjection;
import com.mercadolibre.final_project_bootcamp_esp_32.projection.WarehouseStock;
import com.mercadolibre.final_project_bootcamp_esp_32.repository.IBatchRepository;
import com.mercadolibre.final_project_bootcamp_esp_32.repository.IProductRepository;
import com.mercadolibre.final_project_bootcamp_esp_32.service.AuthService;
import com.mercadolibre.final_project_bootcamp_esp_32.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    //Mocking Product Repository
    @Mock
    private IProductRepository productRepository;

    @Mock
    private IBatchRepository batchRepository;

    @Mock
    private AuthService authService;

    @Mock
    private HttpServletRequest httpServletRequest;

    //Injecting mocks on ProductService
    @InjectMocks
    private ProductService productService;

    //Creating objects to test
    ResponseProductDTO responseProductDTO;
    List<ProductProjection> productsProjection;
    List<WarehouseStock> warehouseStocks;

    //Setting up the objects
    @BeforeEach
    void setup(){
        List<ProductDTO>  productsDTO= new ArrayList<>();
        productsDTO.add(new ProductDTO(1000,2));
        productsDTO.add(new ProductDTO(1001,3));
        responseProductDTO = new ResponseProductDTO(productsDTO);
        productsProjection = new ArrayList<>();
        ProductProjection product1 = new ProductProjection() {
            @Override
            public Long getIdProduct() {return 1000L;}
            @Override
            public Integer getQuantity() {return 2;}
        };
        ProductProjection product2 = new ProductProjection() {
            @Override
            public Long getIdProduct() {return 1001L;}
            @Override
            public Integer getQuantity() {return 3;}
        };
        productsProjection.add(product1);
        productsProjection.add(product2);

        warehouseStocks = new ArrayList<>();
        WarehouseStock warehouseStock1 = new WarehouseStock() {
            @Override
            public Integer getWarehouseCode() {return 1;}
            @Override
            public Long getTotalQuantity() {return 600L;}
        };
        WarehouseStock warehouseStock2 = new WarehouseStock() {
            @Override
            public Integer getWarehouseCode() {return 2;}
            @Override
            public Long getTotalQuantity() {return 600L;}
        };
        warehouseStocks.add(warehouseStock1);
        warehouseStocks.add(warehouseStock2);
    }

    /**
     * Test to get all products happy path
     */
    @Test
    void testGetAllProducts(){
        // Arrange
        when(productRepository.findAllProducts()).thenReturn(productsProjection);
        // Act
        ResponseProductDTO actualResponse = productService.getAllProducts();
        // Assert
        Assertions.assertEquals(responseProductDTO, actualResponse);
        Assertions.assertEquals(responseProductDTO.getProductDTOList().size(),
                actualResponse.getProductDTOList().size());
    }

    /**
     * Test to get all products error path
     */
    @Test
    void errorTestGetAllProducts(){
        //Arrange
        List<ProductProjection> productsProjectionError = new ArrayList<>();
        when(productRepository.findAllProducts()).thenReturn(productsProjectionError);
        //Act
        ApiException error= Assertions.assertThrows(ApiException.class,()->{
            productService.getAllProducts();
        });
        //Assert
        Assertions.assertEquals("Not Found",error.getCode());
        Assertions.assertEquals("No products found",error.getMessage());
        Assertions.assertEquals(404,error.getStatusCode());
    }

    /**
     * Test to get products by category happy path
     */
    @Test
    void testGetProductsByCategory(){
        //Arrange
        when(productRepository.findProductsByCategory(ProductType.FF)).thenReturn(productsProjection);
        //Act
        ResponseProductDTO responseProductDTO1 = productService.getProductsByCategory("FF");
        //Assert
        Assertions.assertEquals(responseProductDTO,responseProductDTO1);
        Assertions.assertEquals(responseProductDTO.getProductDTOList().size()
                ,responseProductDTO1.getProductDTOList().size());
    }

    /**
     * Test to get products by category error path
     * Invalid category
     */
    @Test
    void firstErrorTestGetProductsByCategory(){
        //Act
        ApiException error= Assertions.assertThrows(ApiException.class,()->{
            productService.getProductsByCategory("F");
        });
        //Assert
        Assertions.assertEquals("Not Found",error.getCode());
        Assertions.assertEquals("Invalid category: F",error.getMessage());
        Assertions.assertEquals(404,error.getStatusCode());
    }

    /**
     * Test to get products by category error path
     * No products found
     */
    @Test
    void secondErrorTestGetProductsByCategory(){
        //Arrange
        List<ProductProjection> productsProjectionError = new ArrayList<>();
        when(productRepository.findProductsByCategory(ProductType.FF)).thenReturn(productsProjectionError);
        //Act
        ApiException error= Assertions.assertThrows(ApiException.class,()->{
            productService.getProductsByCategory("FF");
        });
        //Assert
        Assertions.assertEquals("Not Found",error.getCode());
        Assertions.assertEquals("No products found",error.getMessage());
        Assertions.assertEquals(404,error.getStatusCode());
    }

    /**
     * Test to get All products selecting the method with null category
     */
    @Test
    void testSelectMethodWithNullCategory(){
        // Arrange
        when(productRepository.findAllProducts()).thenReturn(productsProjection);
        // Act
        ResponseProductDTO actualResponse = productService.selectMethod(null);
        // Assert
        Assertions.assertEquals(responseProductDTO, actualResponse);
    }

    /**
     * Test to get products selecting the method with valid category
     */
    @Test
    void testSelectMethodWithValidCategory(){
        // Arrange
        when(productRepository.findProductsByCategory(ProductType.FF)).thenReturn(productsProjection);
        // Act
        ResponseProductDTO actualResponse = productService.selectMethod("FF");
        // Assert
        Assertions.assertEquals(responseProductDTO, actualResponse);
    }

    @Test
    void searchProductsByWarehouseTest(){
        // Arrange
        Integer productId = 1;
        Seller seller = new Seller();
        seller.setId(2);
        InternalUser internalUser = new InternalUser();
        internalUser.setId(1);
        Product product = new Product(2,"Product B",20.75,ProductType.FF,seller);
        List<WarehouseStockDto> warehouseStockDtos = List.of(
                new WarehouseStockDto(1,600L),
                new WarehouseStockDto(2, 600L)
        );
        ProductWarehouseResponseDto expected = new ProductWarehouseResponseDto(productId,warehouseStockDtos);
        when(productRepository.findById(productId)).thenReturn(Optional.of(product));
        when(batchRepository.findProductBatchSumGroupedByWarehouse(productId)).thenReturn(warehouseStocks);
        when(authService.validateInternalUser(any())).thenReturn(internalUser);
        // Act
        ProductWarehouseResponseDto actual = productService.searchProductsByWarehouse(productId, httpServletRequest);
        // Assert
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void searchProductsByWarehouseTestWithoutProduct(){
        // Arrange
        Integer productId = 1;
        InternalUser internalUser = new InternalUser();
        internalUser.setId(1);
        when(authService.validateInternalUser(any())).thenReturn(internalUser);

        // Assert
        Assertions.assertThrows(NotFoundException.class, () -> productService.searchProductsByWarehouse(productId, httpServletRequest));
    }
}
