package com.mercadolibre.final_project_bootcamp_esp_2.unit.service;

import com.mercadolibre.final_project_bootcamp_esp_2.dto.ProductStockDTO;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.response.ProductDTO;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.response.ProductStockAndSectionDTO;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.response.ProductWarehouseDTO;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.response.WarehouseStockDto;
import com.mercadolibre.final_project_bootcamp_esp_2.exceptions.NotFoundException;
import com.mercadolibre.final_project_bootcamp_esp_2.exceptions.BadRequestException;
import com.mercadolibre.final_project_bootcamp_esp_2.model.Product;
import com.mercadolibre.final_project_bootcamp_esp_2.model.util.ProductType;
import com.mercadolibre.final_project_bootcamp_esp_2.repository.IProductRepository;
import com.mercadolibre.final_project_bootcamp_esp_2.service.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceImplTest {

    @Mock
    private IProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetFreshProducts() {
        // Arrange
        List<Product> mockProducts = Arrays.asList(
                new Product(1L, "Manzana", 500.0, ProductType.FRESH, null),
                new Product(2L, "Pera", 450.0, ProductType.FRESH, null)
        );

        when(productRepository.findByType(ProductType.FRESH)).thenReturn(mockProducts);

        // Act
        List<ProductDTO> freshProducts = productService.getProductsByType("FS");

        // Assert
        assertEquals(2, freshProducts.size());
        assertEquals("Manzana", freshProducts.get(0).getName());
        assertEquals("Pera", freshProducts.get(1).getName());

        verify(productRepository, times(1)).findByType(ProductType.FRESH);
    }
    @Test
    void testGetRegrigeratedProducts() {
        // Arrange
        List<Product> mockProducts = Arrays.asList(
                new Product(1L, "ice", 500.0, ProductType.REFRIGERATED, null),
                new Product(2L, "ice", 450.0, ProductType.REFRIGERATED, null)
        );

        when(productRepository.findByType(ProductType.REFRIGERATED)).thenReturn(mockProducts);

        // Act
        List<ProductDTO> freshProducts = productService.getProductsByType("RF");

        // Assert
        assertEquals(2, freshProducts.size());
        assertEquals("ice", freshProducts.get(0).getName());
        assertEquals("ice", freshProducts.get(1).getName());

        verify(productRepository, times(1)).findByType(ProductType.REFRIGERATED);
    }
    @Test
    void testGetFrozenProducts() {
        // Arrange
        List<Product> mockProducts = Arrays.asList(
                new Product(1L, "ice", 500.0, ProductType.FROZEN, null),
                new Product(2L, "ice", 450.0, ProductType.FROZEN, null)
        );

        when(productRepository.findByType(ProductType.FROZEN)).thenReturn(mockProducts);

        // Act
        List<ProductDTO> freshProducts = productService.getProductsByType("FF");

        // Assert
        assertEquals(2, freshProducts.size());
        assertEquals("ice", freshProducts.get(0).getName());
        assertEquals("ice", freshProducts.get(1).getName());

        verify(productRepository, times(1)).findByType(ProductType.FROZEN);
    }

    @Test
    void testGetFreshProducts_productTypeInvalid() {
        // Assert
        assertThrows(BadRequestException.class, () -> productService.getProductsByType("INVALID"));
        verify(productRepository, times(0)).findByType(ProductType.FRESH);
    }
    @Test
    void testSearchAllProducts() {
        List<Product> mockProducts = Arrays.asList(
                new Product(1L, "Manzana", 500.0, ProductType.FRESH, null),
                new Product(2L, "Pera", 450.0, ProductType.FRESH, null),
                new Product(3L, "Leche", 800.50, ProductType.REFRIGERATED, null)
        );

        when(productRepository.findAll()).thenReturn(mockProducts);

        List<ProductDTO> allProducts = productService.searchAllProducts();

        assertEquals(3, allProducts.size());
        assertEquals("Manzana", allProducts.get(0).getName());
        assertEquals(500.0, allProducts.get(0).getUnitaryPrice());
        assertEquals(ProductType.FRESH, allProducts.get(0).getType());

        assertEquals("Pera", allProducts.get(1).getName());
        assertEquals(450.0, allProducts.get(1).getUnitaryPrice());
        assertEquals(ProductType.FRESH, allProducts.get(1).getType());

        assertEquals("Leche", allProducts.get(2).getName());
        assertEquals(800.50, allProducts.get(2).getUnitaryPrice());
        assertEquals(ProductType.REFRIGERATED, allProducts.get(2).getType());

        // Verificar que se llamó a `findAll()` una única vez
        verify(productRepository, times(1)).findAll();
    }

    @Test
    void testSearchProductStockInWarehouses_Success() {
        Long idProduct = 1L;
        List<Object[]> o = new ArrayList<>();
        o.add(new Object[] {1L, 1L, 50});
        when(productRepository.findProductStockInWarehouses(idProduct)).thenReturn(o);
        ProductWarehouseDTO productWarehouseDTO = productService.searchProductStockInWarehouses(idProduct);
        assertNotNull(productWarehouseDTO);
        assertEquals(idProduct.intValue(), productWarehouseDTO.getProduct_id());
        assertFalse(productWarehouseDTO.getWarehouses().isEmpty());
        assertEquals(1, productWarehouseDTO.getWarehouses().size());
        WarehouseStockDto warehouseStock = productWarehouseDTO.getWarehouses().get(0);
        assertEquals(1, warehouseStock.getWarehouse_code());
        assertEquals(50, warehouseStock.getTotal_quantity());
        verify(productRepository, times(1)).findProductStockInWarehouses(idProduct);
    }

    @Test
    void testSearchProductStockInWarehouses_NoStock() {
        Long idProduct = 2L;
        when(productRepository.findProductStockInWarehouses(idProduct)).thenReturn(new ArrayList<>());
        ProductWarehouseDTO productWarehouseDTO = productService.searchProductStockInWarehouses(idProduct);
        assertNotNull(productWarehouseDTO);
        assertEquals(idProduct.intValue(), productWarehouseDTO.getProduct_id());
        assertTrue(productWarehouseDTO.getWarehouses().isEmpty());
        verify(productRepository, times(1)).findProductStockInWarehouses(idProduct);
    }

    @Test
    void testSearchProductStockInWarehouses_NullIdProduct() {
        Throwable exception = assertThrows(NullPointerException.class, () -> {
            productService.searchProductStockInWarehouses(null);
        });
        assertEquals("java.lang.NullPointerException", exception.getClass().getName());
        verify(productRepository, times(0)).findProductStockInWarehouses(anyLong());
    }

    @Test
    void testGetProductStockByWarehouse_Success() {
        Long warehouseId = 1L;
        Long productId = 2L;

        when(productRepository.findProductStockByWarehouse(warehouseId, productId))
                .thenReturn(List.of(new Object[][]{{2L, "Leche", 800.50, 5, "REFRIGERATED"}}));

        List<ProductStockDTO> result = productService.getProductStockByWarehouse(warehouseId, productId);

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
    void testGetProductStockAndEachSectionByWarehouse_Success() {
        Long warehouseId = 1L;
        Long productId = 2L;

        when(productRepository.findProductStockByWarehouse(warehouseId, productId))
                .thenReturn(List.of(new Object[][]{{2L, "Leche", 800.50, 5, "REFRIGERATED"}}));

        when(productRepository.findSectionsWithProductStock(productId, warehouseId))
                .thenReturn(List.of(
                        new Object[]{1L, 3},
                        new Object[]{2L, 2}
                ));

        ProductStockAndSectionDTO result = productService.getProductStockAndEachSectionByWarehouse(warehouseId, productId);

        assertNotNull(result);
        assertEquals(warehouseId, result.getWarehouseId());
        assertEquals(productId, result.getProductId());
        assertEquals(ProductType.REFRIGERATED, result.getProductType());
        assertEquals(2, result.getSections().size());
        assertEquals(1L, result.getSections().get(0).getSectionId());
        assertEquals(3, result.getSections().get(0).getQuantity());
        assertEquals(2L, result.getSections().get(1).getSectionId());
        assertEquals(2, result.getSections().get(1).getQuantity());

        verify(productRepository, times(1)).findProductStockByWarehouse(warehouseId, productId);
        verify(productRepository, times(1)).findSectionsWithProductStock(productId, warehouseId);
    }

    @Test
    void testGetProductStockAndEachSectionByWarehouse_NoStock() {
        Long warehouseId = 1L;
        Long productId = 2L;

        when(productRepository.findProductStockByWarehouse(warehouseId, productId))
                .thenReturn(List.of());

        NotFoundException exception = assertThrows(NotFoundException.class,
                () -> productService.getProductStockAndEachSectionByWarehouse(warehouseId, productId));

        assertEquals("No se encontró stock para el producto en el almacén", exception.getMessage());

        verify(productRepository, times(1)).findProductStockByWarehouse(warehouseId, productId);
        verify(productRepository, times(0)).findSectionsWithProductStock(productId, warehouseId);
    }

    @Test
    void testGetProductStockAndEachSectionByWarehouse_NoSections() {
        Long warehouseId = 1L;
        Long productId = 2L;

        when(productRepository.findProductStockByWarehouse(warehouseId, productId))
                .thenReturn(List.of(new Object[][]{{2L, "Leche", 800.50, 5, "REFRIGERATED"}}));

        when(productRepository.findSectionsWithProductStock(productId, warehouseId))
                .thenReturn(List.of());

        ProductStockAndSectionDTO result = productService.getProductStockAndEachSectionByWarehouse(warehouseId, productId);

        assertNotNull(result);
        assertEquals(warehouseId, result.getWarehouseId());
        assertEquals(productId, result.getProductId());
        assertEquals(ProductType.REFRIGERATED, result.getProductType());
        assertTrue(result.getSections().isEmpty());

        verify(productRepository, times(1)).findProductStockByWarehouse(warehouseId, productId);
        verify(productRepository, times(1)).findSectionsWithProductStock(productId, warehouseId);
    }

}
