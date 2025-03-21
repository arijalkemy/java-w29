package com.mercadolibre.final_project_bootcamp_esp_32.util;

import com.mercadolibre.final_project_bootcamp_esp_32.dtos.request.InboundOrderDto;
import com.mercadolibre.final_project_bootcamp_esp_32.dtos.request.SectionRequestDto;
import com.mercadolibre.final_project_bootcamp_esp_32.dtos.response.ProductBatchDto;
import com.mercadolibre.final_project_bootcamp_esp_32.entities.InboundOrder;
import com.mercadolibre.final_project_bootcamp_esp_32.entities.InternalUser;
import com.mercadolibre.final_project_bootcamp_esp_32.entities.Section;
import com.mercadolibre.final_project_bootcamp_esp_32.entities.Warehouse;
import com.mercadolibre.final_project_bootcamp_esp_32.enums.ProductType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestUtils {

    private static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    public static InboundOrderDto getInboundOrder(){
        Integer orderNumber = 10;
        LocalDate date = LocalDate.parse("05-04-2025", dateFormatter);
        SectionRequestDto section = new SectionRequestDto(2, 1);
        List<ProductBatchDto> productBatchDto = getProductBatchDtoList();
        return new InboundOrderDto(orderNumber,date,section,productBatchDto);
    }

    public static List<ProductBatchDto> getProductBatchDtoList(){
        LocalDate date = LocalDate.parse("05-04-2025", dateFormatter);
        LocalDateTime dateTime = LocalDateTime.parse("05-04-2025 14:30:45", dateTimeFormatter);

        List<ProductBatchDto> productBatchList = new ArrayList<ProductBatchDto>();
        ProductBatchDto productBatchDto = new ProductBatchDto(1,1,25.0,
                24.0,1,1,date,dateTime,date);
        productBatchList.add(productBatchDto);

        return productBatchList;
    }

    public static Section getSection(){
        Set<InboundOrder> inboundOrders = new HashSet<InboundOrder>();
        Warehouse warehouse = new Warehouse();
        ProductType productType = ProductType.FF;
        return new Section(1, warehouse,productType);
    }

    public static InternalUser getInternalUser(){
        Warehouse warehouse = new Warehouse();
        warehouse.setWarehouseCode(1);
        InternalUser internalUser = new InternalUser();
        internalUser.setId(1);
        internalUser.setWarehouse(warehouse);
        return internalUser;
    }
}

