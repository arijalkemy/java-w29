package com.mercadolibre.final_project_bootcamp_esp_2.service;

import com.mercadolibre.final_project_bootcamp_esp_2.dto.BatchSortType;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.ProductBatchListResponse;
import com.mercadolibre.final_project_bootcamp_esp_2.model.User;
import com.mercadolibre.final_project_bootcamp_esp_2.repository.BatchRepository;
import com.mercadolibre.final_project_bootcamp_esp_2.service.auth.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FreshProductService implements IFreshProductService {

    private final WarehouseService warehouseService;
    private final AuthenticationService authenticationService;
    private final BatchRepository batchRepository;

    /**
     * Searches the section and batches of a given product in the warehouse supervised by the authenticated user
     * @param productId The ID of the product
     * @param sortType The type of sorting for the batch list
     * @return The details of the section and batches that contains the given product
     */
    @Override
    public ProductBatchListResponse findProductBatchList(Long productId, BatchSortType sortType) {
        User supervisor = authenticationService.findLoggedInUser();
        return warehouseService.getProductBatchesByProductIdSortedBy(supervisor.getId(), productId, sortType);
    }
}
