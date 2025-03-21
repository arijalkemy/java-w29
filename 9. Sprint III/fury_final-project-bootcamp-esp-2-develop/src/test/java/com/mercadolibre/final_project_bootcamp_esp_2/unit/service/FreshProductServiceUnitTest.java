package com.mercadolibre.final_project_bootcamp_esp_2.unit.service;

import com.mercadolibre.final_project_bootcamp_esp_2.dto.ProductBatchListResponse;
import com.mercadolibre.final_project_bootcamp_esp_2.model.*;
import com.mercadolibre.final_project_bootcamp_esp_2.model.util.ProductType;
import com.mercadolibre.final_project_bootcamp_esp_2.model.util.UserRole;
import com.mercadolibre.final_project_bootcamp_esp_2.service.FreshProductService;
import com.mercadolibre.final_project_bootcamp_esp_2.service.WarehouseService;
import com.mercadolibre.final_project_bootcamp_esp_2.service.auth.AuthenticationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FreshProductServiceUnitTest {
    @Mock
    private WarehouseService warehouseService;
    @Mock
    private AuthenticationService authenticationService;
    @InjectMocks
    private FreshProductService freshProductService;

    @Test
    void shouldGetProductSectionDetailsTest() {

    }
}
