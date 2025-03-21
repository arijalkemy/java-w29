package com.mercadolibre.final_project_bootcamp_esp_32.service;

import com.mercadolibre.final_project_bootcamp_esp_32.dtos.request.ProductDTO;
import com.mercadolibre.final_project_bootcamp_esp_32.dtos.response.WarehouseStockDto;
import com.mercadolibre.final_project_bootcamp_esp_32.dtos.response.ProductWarehouseResponseDto;
import com.mercadolibre.final_project_bootcamp_esp_32.dtos.response.ResponseProductDTO;
import com.mercadolibre.final_project_bootcamp_esp_32.entities.Product;
import com.mercadolibre.final_project_bootcamp_esp_32.enums.ProductType;
import com.mercadolibre.final_project_bootcamp_esp_32.exceptions.ApiException;
import com.mercadolibre.final_project_bootcamp_esp_32.exceptions.NotFoundException;
import com.mercadolibre.final_project_bootcamp_esp_32.repository.IBatchRepository;
import com.mercadolibre.final_project_bootcamp_esp_32.repository.IProductRepository;
import com.mercadolibre.final_project_bootcamp_esp_32.util.MappingUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService{

    private final IProductRepository productRepository;
    private final IBatchRepository batchRepository;
    private final AuthService authService;

    @Override
    public ResponseProductDTO selectMethod(String category) {
        if(category==null) {

            return getAllProducts();
        }

        return getProductsByCategory(category);
    }

    @Override
    public ProductWarehouseResponseDto searchProductsByWarehouse(Integer idProduct, HttpServletRequest httpServletRequest) {
        authService.validateInternalUser(httpServletRequest);

        Optional<Product> product = productRepository.findById(idProduct);
        if(product.isEmpty())
            throw new NotFoundException("No existe el producto");

        List<WarehouseStockDto> warehouseStockDtos = batchRepository.findProductBatchSumGroupedByWarehouse(idProduct).stream()
                .map(MappingUtil::warehouseStockToWarehouseStockDto)
                .toList();
        return new ProductWarehouseResponseDto(idProduct,warehouseStockDtos);
    }

    public ResponseProductDTO getAllProducts() {
        List<ProductDTO> productsDTO = productRepository.findAllProducts().stream()
                .map(MappingUtil::productProjectionToProductDTO)
                .toList();

        if (productsDTO.isEmpty()) {
            throw new ApiException("Not Found", "No products found", HttpStatus.NOT_FOUND.value());
        }

        return ResponseProductDTO.builder().productDTOList(productsDTO).build();
    }

    public ResponseProductDTO getProductsByCategory(String category) {
        ProductType categoryEnum = getProductType(category);

        List<ProductDTO> productsDTO = productRepository.findProductsByCategory(categoryEnum).stream()
                .map(MappingUtil::productProjectionToProductDTO)
                .toList();

        return ResponseProductDTO.builder()
                .productDTOList(Optional.ofNullable(productsDTO)
                        .filter(list -> !list.isEmpty())
                        .orElseThrow(() -> new ApiException("Not Found", "No products found", HttpStatus.NOT_FOUND.value())))
                .build();
    }

    private ProductType getProductType(String category) {
        return Arrays.stream(ProductType.values())
                .filter(c -> c.name().equalsIgnoreCase(category))
                .findFirst()
                .orElseThrow(() -> new ApiException("Not Found", "Invalid category: " + category, HttpStatus.NOT_FOUND.value()));
    }
}
