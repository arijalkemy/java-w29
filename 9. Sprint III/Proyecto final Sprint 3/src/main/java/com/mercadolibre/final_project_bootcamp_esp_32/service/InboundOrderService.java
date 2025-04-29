package com.mercadolibre.final_project_bootcamp_esp_32.service;

import com.mercadolibre.final_project_bootcamp_esp_32.dtos.request.InboundOrderDto;
import com.mercadolibre.final_project_bootcamp_esp_32.dtos.response.ProductBatchDto;
import com.mercadolibre.final_project_bootcamp_esp_32.entities.*;
import com.mercadolibre.final_project_bootcamp_esp_32.exceptions.BadRequestException;
import com.mercadolibre.final_project_bootcamp_esp_32.exceptions.BatchAlreadyExistsException;
import com.mercadolibre.final_project_bootcamp_esp_32.exceptions.NotFoundException;
import com.mercadolibre.final_project_bootcamp_esp_32.repository.*;
import com.mercadolibre.final_project_bootcamp_esp_32.util.MappingUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class InboundOrderService implements IInboundOrderService {

    private final AuthService authService;
    private final IWarehouseRepository warehouseRepository;
    private final IProductRepository productRepository;
    private final IInboundOrderRepository inboundOrderRepository;
    private final ISectionRepository sectionRepository;
    private final IProductBatchRepository productBatchRepository;

    @Override
    @Transactional
    public List<ProductBatchDto> saveInboundOrderBatchStock(InboundOrderDto order, HttpServletRequest request) {

        InternalUser internalUser = authService.validateInternalUser(request);

        if(!internalUser.getWarehouse().getWarehouseCode().equals(order.getSection().getWarehouseCode())) {
            throw new BadRequestException("El warehouse de la orden, no se corresponde con el warehouse asociado al usuario.");
        }

        if (!sectionRepository.existsBySectionCode(order.getSection().getSectionCode())) {
            throw new NotFoundException("No existe la sección");
        }

        if (!warehouseRepository.existsById(order.getSection().getSectionCode())) {
            throw new NotFoundException("No existe el depósito");
        }

        //Busco la seccion
        Section section = sectionRepository.findBySectionCode(order.getSection().getSectionCode());

        //Transformo la ordenDto a orden.
        InboundOrder inboundOrder = MappingUtil.mapInboundOrderDtoToInboundOrder(order);
        inboundOrder.setSection(section);
        inboundOrder.setInternalUser(internalUser);

        //Guardo el inbound order
        inboundOrder = inboundOrderRepository.save(inboundOrder);

        //Creo una lista para guardar los lotes
        List<ProductBatch> productBatches = new ArrayList<>();

        for (ProductBatchDto batchDto : order.getBatchStock()) {

            // Si ya existe el productbatch en la base
            if (productBatchRepository.existsProductBatchByBatchNumber(batchDto.getBatchNumber())) {
                throw new BatchAlreadyExistsException("Ya existe el batch en la base");
            }

            Integer productId = batchDto.getProductId();
            Product product = productRepository.findById(productId)
                    .orElseThrow(() -> new NotFoundException("No existe el producto con ID: " + productId));

            // Creo un nuevo batch y le seteo lo necesario
            ProductBatch batch = new ProductBatch();
            batch.setBatchNumber(batchDto.getBatchNumber());
            batch.setCurrentTemperature(batchDto.getCurrentTemperature());
            batch.setMinimumTemperature(batchDto.getMinimumTemperature());
            batch.setInitialQuantity(batchDto.getInitialQuantity());
            batch.setCurrentQuantity(batchDto.getCurrentQuantity());
            batch.setManufacturingDate(batchDto.getManufacturingDate());
            batch.setDueDate(batchDto.getDueDate());
            batch.setManufacturingTime(batchDto.getManufacturingTime());
            batch.setSection(section);
            batch.setProduct(product);
            batch.setInboundOrder(inboundOrder); // Le cargo el inbound order al batch

            productBatches.add(batch);
        }

        //Guardo todos los ProductBatch en la base de datos
        productBatchRepository.saveAll(productBatches);

        return MappingUtil.mapToProductBatchDtoList(productBatches);
    }


    @Override
    @Transactional
    public List<ProductBatchDto> modifyInboundOrderBatchStock(InboundOrderDto order) {

        if(!sectionRepository.existsBySectionCode(order.getSection().getSectionCode())){
            throw new NotFoundException("No existe la seccion");
        }

        if(!warehouseRepository.existsById(order.getSection().getSectionCode())){
            throw new NotFoundException("No existe el deposito");
        }

        Section section = sectionRepository.findBySectionCode(order.getSection().getSectionCode());

        //Creo una lista para guardar los lotes
        List<ProductBatch> productBatches = new ArrayList<>();

        for (ProductBatchDto batchDto : order.getBatchStock()) {

            // Si no existe el productbatch en la base
            if (!productBatchRepository.existsProductBatchByBatchNumber(batchDto.getBatchNumber())) {
                throw new BatchAlreadyExistsException("No existe el batch en la base");
            }

            Integer productId = batchDto.getProductId();
            Product product = productRepository.findById(productId)
                    .orElseThrow(() -> new NotFoundException("No existe el producto con ID: " + productId));

            // Recupero el productbatch y le seteo
            ProductBatch batch = productBatchRepository.findProductBatchByBatchNumber(batchDto.getBatchNumber());
            batch.setBatchNumber(batchDto.getBatchNumber());
            batch.setCurrentTemperature(batchDto.getCurrentTemperature());
            batch.setMinimumTemperature(batchDto.getMinimumTemperature());
            batch.setInitialQuantity(batchDto.getInitialQuantity());
            batch.setCurrentQuantity(batchDto.getCurrentQuantity());
            batch.setManufacturingDate(batchDto.getManufacturingDate());
            batch.setDueDate(batchDto.getDueDate());
            batch.setManufacturingTime(batchDto.getManufacturingTime());
            batch.setSection(section);
            batch.setProduct(product);

            productBatches.add(batch);
        }

        //Guardo todos los ProductBatch en la base de datos
        productBatchRepository.saveAll(productBatches);

        return MappingUtil.mapToProductBatchDtoList(productBatches);
    }
}
