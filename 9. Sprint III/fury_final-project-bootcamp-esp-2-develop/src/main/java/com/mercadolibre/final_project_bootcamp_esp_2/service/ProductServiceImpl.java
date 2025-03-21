package com.mercadolibre.final_project_bootcamp_esp_2.service;

import com.mercadolibre.final_project_bootcamp_esp_2.dto.ProductStockDTO;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.response.*;
import com.mercadolibre.final_project_bootcamp_esp_2.exceptions.NotFoundException;
import com.mercadolibre.final_project_bootcamp_esp_2.exceptions.BadRequestException;
import com.mercadolibre.final_project_bootcamp_esp_2.model.util.ProductType;
import com.mercadolibre.final_project_bootcamp_esp_2.repository.IProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements IProductService {

    private final IProductRepository productRepository;

    public ProductServiceImpl(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDTO> searchAllProducts() {
        return productRepository.findAll().stream()
                .map(product -> ProductDTO.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .unitaryPrice(product.getUnitaryPrice())
                        .type(product.getType())
                        .build())
                .collect(Collectors.toList());
    }
    @Override
    public List<ProductDTO> getProductsByType(String category) {
        if(category==null){
            return searchAllProducts();
        }
        ProductType productType = switch (category) {
            case "FS" -> ProductType.FRESH;
            case "RF" -> ProductType.REFRIGERATED;
            case "FF" -> ProductType.FROZEN;
            default -> throw new BadRequestException("Invalid category");
        };

        return productRepository.findByType(productType).stream()
                .map(product -> ProductDTO.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .unitaryPrice(product.getUnitaryPrice())
                        .type(product.getType())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductStockDTO> getProductStockByWarehouse(Long warehouseId, Long productId) {
        List<Object[]> results = productRepository.findProductStockByWarehouse(warehouseId, productId);

        return results.stream().map(obj -> new ProductStockDTO(
                ((Number) obj[0]).longValue(),    // id
                (String) obj[1],                  // name
                ((Number) obj[2]).doubleValue(),  // unitaryPrice
                ((Number) obj[3]).intValue(),     // quantity
                ProductType.valueOf((String) obj[4]) // type
        )).toList();
    }

    @Override
    public ProductStockAndSectionDTO getProductStockAndEachSectionByWarehouse(Long warehouseId, Long productId) {
        List<ProductStockDTO> productStockDTOList = getProductStockByWarehouse(warehouseId, productId);

        if (productStockDTOList.isEmpty()) {
            throw new NotFoundException("No se encontró stock para el producto en el almacén");
        }

        ProductStockDTO productStockDTO = productStockDTOList.get(0);

        List<Object[]> sectionResults = productRepository.findSectionsWithProductStock(productId, warehouseId);

        List<SectionStockDTO> sectionStockList = sectionResults.stream()
                .map(obj -> new SectionStockDTO(
                        ((Number) obj[0]).longValue(),  // sectionId
                        ((Number) obj[1]).intValue()   // quantity
                )).toList();

        return ProductStockAndSectionDTO.builder()
                .warehouseId(warehouseId)
                .productId(productId)
                .productType(productStockDTO.getType())
                .sections(sectionStockList)
                .build();
    }

    @Override
    public ProductWarehouseDTO searchProductStockInWarehouses(Long idProduct) {
        List<Object[]> results = productRepository.findProductStockInWarehouses(idProduct);

        List<WarehouseStockDto> warehouses = results.stream()
                .map(result -> new WarehouseStockDto(
                        ((Number) result[0]).intValue(),
                        ((Number) result[2]).intValue()
                ))
                .collect(Collectors.toList());

        return new ProductWarehouseDTO(Math.toIntExact(idProduct), warehouses);
    }


}
