package com.mercadolibre.final_project_bootcamp_esp_32.unit.service;

import com.mercadolibre.final_project_bootcamp_esp_32.dtos.request.InboundOrderDto;
import com.mercadolibre.final_project_bootcamp_esp_32.dtos.request.SectionRequestDto;
import com.mercadolibre.final_project_bootcamp_esp_32.dtos.response.ProductBatchDto;
import com.mercadolibre.final_project_bootcamp_esp_32.entities.InboundOrder;
import com.mercadolibre.final_project_bootcamp_esp_32.entities.InternalUser;
import com.mercadolibre.final_project_bootcamp_esp_32.entities.Product;
import com.mercadolibre.final_project_bootcamp_esp_32.entities.Section;
import com.mercadolibre.final_project_bootcamp_esp_32.exceptions.NotFoundException;
import com.mercadolibre.final_project_bootcamp_esp_32.repository.*;
import com.mercadolibre.final_project_bootcamp_esp_32.service.AuthService;
import com.mercadolibre.final_project_bootcamp_esp_32.service.InboundOrderService;
import com.mercadolibre.final_project_bootcamp_esp_32.util.TestUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class InboundOrderServiceTest {
    @Mock
    HttpServletRequest request;

    @Mock
    AuthService authService;

    @Mock
    IInboundOrderRepository inboundOrderRepository;

    @Mock
    ISectionRepository sectionRepository;

    @Mock
    IWarehouseRepository warehouseRepository;

    @Mock
    IProductBatchRepository productBatchRepository;

    @Mock
    IProductRepository productRepository;

    @Mock
    IPurchaseOrderRepository purchaseOrderRepository;

    @Mock
    IProductPurchaseOrderRepository productPurchaseOrderRepository;

    @InjectMocks
    InboundOrderService inboundOrderService;

    @Test
    @DisplayName("Req 1 - Happy Path")
    void saveInboundOrderBatchStock(){
        //arrange
        InternalUser internalUser = TestUtils.getInternalUser();
        InboundOrderDto inboundOrderDto = TestUtils.getInboundOrder();
        Section section = TestUtils.getSection();
        List<ProductBatchDto> expected = TestUtils.getProductBatchDtoList();
        InboundOrder inbOrd = new InboundOrder(
                null,
                inboundOrderDto.getOrderNumber(),
                inboundOrderDto.getOrderDate(),
                section,
                null
        );

        when(authService.validateInternalUser(any())).thenReturn(internalUser);
        when(sectionRepository.existsBySectionCode(anyInt())).thenReturn(true);
        when(warehouseRepository.existsById(anyInt())).thenReturn(true);
        when(sectionRepository.findBySectionCode(anyInt())).thenReturn(section);
        when(inboundOrderRepository.save(any())).thenReturn(inbOrd);

        for (ProductBatchDto batchDto : inboundOrderDto.getBatchStock()) {
            when(productBatchRepository.existsProductBatchByBatchNumber(anyInt())).thenReturn(false);
            when(productRepository.findById(batchDto.getProductId()))
                    .thenReturn(Optional.of(new Product(1,"",0.0,null,null)));
        }

        //act
        List<ProductBatchDto> actual = inboundOrderService.saveInboundOrderBatchStock(inboundOrderDto,request);

        //assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("modifyInboundOrderBatchStock - Section Not Found")
    void modifyInboundOrderBatchStock_SectionNotFound() {
        InboundOrderDto order = new InboundOrderDto();
        SectionRequestDto sectionRequestDto = new SectionRequestDto(101, 200); // Sección 101, Depósito 200
        order.setSection(sectionRequestDto);

        when(sectionRepository.existsBySectionCode(101)).thenReturn(false);

        NotFoundException exception = assertThrows(NotFoundException.class, () -> {
            inboundOrderService.modifyInboundOrderBatchStock(order);
        });

        assertEquals("No existe la seccion", exception.getMessage());

        verify(sectionRepository).existsBySectionCode(101);
        verifyNoInteractions(warehouseRepository, productBatchRepository);
    }
}
