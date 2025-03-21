package com.mercadolibre.final_project_bootcamp_esp_32.service;

import com.mercadolibre.final_project_bootcamp_esp_32.dtos.response.BatchStockDueDateDTO;
import com.mercadolibre.final_project_bootcamp_esp_32.dtos.response.ProductBatchStockDto;
import com.mercadolibre.final_project_bootcamp_esp_32.entities.InternalUser;
import com.mercadolibre.final_project_bootcamp_esp_32.entities.ProductBatch;
import com.mercadolibre.final_project_bootcamp_esp_32.enums.OrderType;
import com.mercadolibre.final_project_bootcamp_esp_32.enums.ProductType;
import com.mercadolibre.final_project_bootcamp_esp_32.exceptions.NotFoundException;
import com.mercadolibre.final_project_bootcamp_esp_32.repository.IBatchRepository;
import com.mercadolibre.final_project_bootcamp_esp_32.repository.IProductRepository;
import com.mercadolibre.final_project_bootcamp_esp_32.util.MappingUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static com.mercadolibre.final_project_bootcamp_esp_32.util.MappingUtil.toProductBatchStockDto;

@Service
@RequiredArgsConstructor
public class BatchServiceImpl implements  IBatchService{
    private final IBatchRepository batchRepository;
    private final IProductRepository productRepository;
    private final AuthService authService;


    @Override
    public BatchStockDueDateDTO getBatchStock(Integer cantDays, HttpServletRequest httpServletRequest,String order, String category) {

        InternalUser internalUser = authService.validateInternalUser(httpServletRequest);
        if(internalUser.getWarehouse() == null)
            throw new NotFoundException("Representative no pertenece a un Warehouse");

        Integer warehouseCode = internalUser.getWarehouse().getWarehouseCode();
        LocalDate upperBound = LocalDate.now().plusDays(cantDays);
        Collection<ProductType> categories;

        if (Objects.equals(category, "ALL")){
            categories = List.of(ProductType.FF,ProductType.FS,ProductType.RF);
        }else{
            categories = List.of(ProductType.valueOf(category));
        }

        List<ProductBatch> batches = batchRepository.findByDueDateBetweenAndProduct_ProductTypeInAndSection_Warehouse_WarehouseCodeOrderByDueDateAsc(LocalDate.now() ,upperBound, categories,warehouseCode);
        if (Objects.equals(order, "date_desc")){
            Collections.reverse(batches);
        }
        return new BatchStockDueDateDTO(MappingUtil.mapToBatchDueDateDTOs(batches));
    }

    @Override
    public ProductBatchStockDto searchFreshProducts(Integer productId, String order, HttpServletRequest httpServletRequest) {
        OrderType orderType = order == null ? null : OrderType.fromString(order);

        InternalUser internalUser = authService.validateInternalUser(httpServletRequest);

        if(!productRepository.existsById(productId))
            throw new NotFoundException("No existe el producto con id: " + productId);

        LocalDate threeWeeksFromNow = LocalDate.now().plusWeeks(3);
        List<ProductBatch> productBatches = findBatchByProductIdAndInternalUserIdAndDueDateGreaterThan(productId, internalUser.getId(), threeWeeksFromNow, orderType);

        return toProductBatchStockDto(productBatches);
    }

    private List<ProductBatch> findBatchByProductIdAndInternalUserIdAndDueDateGreaterThan(Integer productId, Integer user, LocalDate dueDate, OrderType order){
        List<ProductBatch> foundProductBatches;

        if(order == null){
            foundProductBatches = batchRepository
                    .findByProduct_IdAndSection_Warehouse_InternalUser_IdAndDueDateGreaterThanEqual(productId, user, dueDate);
        } else {
            foundProductBatches = switch (order) {
                case BATCH_NUMBER -> batchRepository
                        .findByProduct_IdAndSection_Warehouse_InternalUser_IdAndDueDateGreaterThanEqualOrderByBatchNumber(productId, user, dueDate);
                case CURRENT_QUANTITY -> batchRepository
                        .findByProduct_IdAndSection_Warehouse_InternalUser_IdAndDueDateGreaterThanEqualOrderByCurrentQuantity(productId, user, dueDate);
                case DUE_DATE -> batchRepository
                        .findByProduct_IdAndSection_Warehouse_InternalUser_IdAndDueDateGreaterThanEqualOrderByDueDate(productId, user, dueDate);
            };
        }

        if(foundProductBatches.isEmpty())
            throw new NotFoundException("No se encontron lotes con el producto id: " + productId);

        return foundProductBatches;
    }

}
