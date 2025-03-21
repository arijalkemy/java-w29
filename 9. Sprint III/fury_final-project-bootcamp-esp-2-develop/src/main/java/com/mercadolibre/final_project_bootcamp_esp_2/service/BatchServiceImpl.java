package com.mercadolibre.final_project_bootcamp_esp_2.service;

import com.mercadolibre.final_project_bootcamp_esp_2.dto.BatchDTO;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.BatchStockDTO;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.SectorDTO;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.request.BatchRequestDto;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.response.BatchStockListDTO;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.response.BatchStockResponseDTO;
import com.mercadolibre.final_project_bootcamp_esp_2.exceptions.BadRequestException;
import com.mercadolibre.final_project_bootcamp_esp_2.exceptions.ConflictException;
import com.mercadolibre.final_project_bootcamp_esp_2.exceptions.NotFoundException;
import com.mercadolibre.final_project_bootcamp_esp_2.exceptions.ResourceNotFoundException;
import com.mercadolibre.final_project_bootcamp_esp_2.model.*;
import com.mercadolibre.final_project_bootcamp_esp_2.model.util.DateOrder;
import com.mercadolibre.final_project_bootcamp_esp_2.model.util.ProductType;
import com.mercadolibre.final_project_bootcamp_esp_2.repository.BatchRepository;
import com.mercadolibre.final_project_bootcamp_esp_2.repository.IProductRepository;
import com.mercadolibre.final_project_bootcamp_esp_2.repository.ISectorRepository;
import com.mercadolibre.final_project_bootcamp_esp_2.repository.IWarehouseRepository;
import com.mercadolibre.final_project_bootcamp_esp_2.service.auth.AuthenticationService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BatchServiceImpl implements IBatchService{

    private final IWarehouseRepository warehouseRepository;
    private final ISectorRepository sectionRepository;
    private final IProductRepository productRepository;
    private final BatchRepository batchRepository;
    private final AuthenticationService authenticationService;

    public BatchServiceImpl(IWarehouseRepository warehouseRepository, ISectorRepository sectionRepository, IProductRepository productRepository, BatchRepository batchRepository, AuthenticationService authenticationService) {
        this.warehouseRepository = warehouseRepository;
        this.sectionRepository = sectionRepository;
        this.productRepository = productRepository;
        this.batchRepository = batchRepository;
        this.authenticationService = authenticationService;
    }

    @Override
    public BatchStockResponseDTO createInboundOrder(BatchRequestDto batchRequestDto) {
        SectorDTO section = batchRequestDto.getInboundOrder().getSection();

        Warehouse warehouse = warehouseRepository
                .findById(section.getWarehouseCode().longValue())
                .orElseThrow(() -> new NotFoundException("Warehouse not found"));

        User user = authenticationService.findLoggedInUser();
        if(!(user.getId().equals(warehouse.getSupervisor().getId()))) {
            throw new BadRequestException("The representative does not belong to the warehouse");
        }

        Sector sectionEntity = sectionRepository
                .findById(section.getSectionCode().longValue())
                .orElseThrow(() -> new NotFoundException("Section not found"));

        List<BatchStockDTO> batchStockList = batchRequestDto.getInboundOrder().getBatchStock();
        batchStockList.forEach(batchStockDto -> {
            batchRepository.findByBatchNumber(batchStockDto.getBatchNumber())
                    .ifPresent(batch -> {
                        throw new ConflictException("Batch already exists");
                    });

            Product product = productRepository
                    .findById(batchStockDto.getProductId().longValue())
                    .orElseThrow(() -> new NotFoundException("Product not found"));

            if(product.getType() != sectionEntity.getProductType()){
                throw new BadRequestException("The product is going to be stored in an incorrect sector");
            }
        });

        ModelMapper mapper = new ModelMapper();
        List<Batch> batchList = batchStockList.stream().map(batchStockDTO -> {
            Batch batch = mapper.map(batchStockDTO, Batch.class);
            batch.setId(null);
            batch.setSector(sectionEntity);
            return batch;
        }).toList();

        List<Batch> batches = batchRepository.saveAll(batchList);

        List<BatchStockDTO> list = batches
                .stream()
                .map(batchResponse -> mapper.map(batchResponse, BatchStockDTO.class))
                .toList();

        return new BatchStockResponseDTO(list);
    }

    @Override
    public BatchStockResponseDTO updateInboundOrder(BatchRequestDto batchRequestDto) {
        SectorDTO section = batchRequestDto.getInboundOrder().getSection();

        Warehouse warehouse = warehouseRepository
                .findById(section.getWarehouseCode().longValue())
                .orElseThrow(() -> new NotFoundException("Warehouse not found"));

        User user = authenticationService.findLoggedInUser();
        if (!user.getId().equals(warehouse.getSupervisor().getId())) {
            throw new BadRequestException("The representative does not belong to the warehouse");
        }

        Sector sectionEntity = sectionRepository
                .findById(section.getSectionCode().longValue())
                .orElseThrow(() -> new NotFoundException("Section not found"));

        List<BatchStockDTO> batchStockList = batchRequestDto.getInboundOrder().getBatchStock();
        ModelMapper mapper = new ModelMapper();

        List<Batch> updatedBatches = batchStockList.stream().map(batchStockDto -> {
            Product product = productRepository
                    .findById(batchStockDto.getProductId().longValue())
                    .orElseThrow(() -> new NotFoundException("Product not found"));

            if (product.getType() != sectionEntity.getProductType()) {
                throw new BadRequestException("Product type does not match section type");
            }

            Batch batch = batchRepository.findByBatchNumber(batchStockDto.getBatchNumber())
                    .orElseThrow(() -> new NotFoundException("Batch not found"));

            return mapDtoToBatch(batch.getId(), batch.getBatchNumber(), batchStockDto, sectionEntity, product);
        }).toList();

        List<Batch> savedBatches = batchRepository.saveAll(updatedBatches);

        List<BatchStockDTO> responseList = savedBatches.stream()
                .map(batch -> mapper.map(batch, BatchStockDTO.class))
                .toList();

        return new BatchStockResponseDTO(responseList);
    }

    private Batch mapDtoToBatch(Long id, Integer batchNumber, BatchStockDTO batchStockDto, Sector sectionEntity, Product product) {
        Batch updatedBatch = new Batch();
        updatedBatch.setId(id);
        updatedBatch.setBatchNumber(batchNumber);
        updatedBatch.setProduct(product);
        updatedBatch.setSector(sectionEntity);
        updatedBatch.setCurrentQuantity(batchStockDto.getCurrentQuantity());
        updatedBatch.setMinimumTemperature(batchStockDto.getMinimumTemperature());
        updatedBatch.setInitialQuantity(batchStockDto.getInitialQuantity());
        updatedBatch.setCurrentTemperature(batchStockDto.getCurrentTemperature());
        updatedBatch.setManufacturingDate(batchStockDto.getManufacturingDate());
        updatedBatch.setManufacturingTime(batchStockDto.getManufacturingTime());
        updatedBatch.setDueDate(batchStockDto.getDueDate());
        return updatedBatch;
    }
    @Override
    public BatchStockListDTO searchBatchStockByDueDate(Integer cantDays, String categoryStr, String dateOrderStr) {
        User supervisor = authenticationService.findLoggedInUser();
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = LocalDate.now().plusDays(cantDays);
        List<Batch> warehouseBatches;


        if (categoryStr == null || dateOrderStr == null) {
            warehouseBatches = batchRepository.findBySupervisorAndDueDateRange(supervisor.getId(), startDate, endDate);
        } else {
            DateOrder dateOrder = getDateOrderFromString(dateOrderStr);
            ProductType productType = getProductTypeFromString(categoryStr);

            warehouseBatches = batchRepository.findBySupervisorAndDueDateRangeAndProductTypeAndSortedByDate(
                    supervisor.getId(),
                    startDate,
                    endDate,
                    productType,
                    dateOrder.toString()
            );
        }

        if (warehouseBatches.isEmpty()) {
            throw new ResourceNotFoundException("No batches were found");
        }

        List<BatchDTO> batchDtoList = warehouseBatches.stream().map(this::mapBatchToDTO).toList();
        return mapBatchStockToDTO(batchDtoList);
    }

    private BatchStockListDTO mapBatchStockToDTO(List<BatchDTO> batchDtoList) {
        return new BatchStockListDTO(batchDtoList);
    }

    private BatchDTO mapBatchToDTO(Batch batch) {
        return new BatchDTO(
                batch.getBatchNumber(),
                batch.getProduct() != null && batch.getProduct().getId() != null ? batch.getProduct().getId().intValue() : null,
                batch.getProduct() != null && batch.getProduct().getType() != null ? batch.getProduct().getType().ordinal() : null,
                batch.getDueDate(),
                batch.getCurrentQuantity()
        );
    }

    /**
     * Provides the corresponding date order.
     *
     * @param dateOrderStr a date order string. It must be one of the following values: "date_asc" or "date_desc".
     * @return a DateOrder.
     * @throws BadRequestException if the provided date order string has an invalid value.
     */
    private DateOrder getDateOrderFromString(String dateOrderStr) {
        return switch (dateOrderStr.toLowerCase()) {
            case "date_asc" -> DateOrder.DATE_ASC;
            case "date_desc" -> DateOrder.DATE_DESC;
            default -> throw new BadRequestException("Invalid date order: " + dateOrderStr);
        };
    }

    /**
     * Provides the corresponding product type.
     *
     * @param productTypeStr a product type string. It must be one of the following values: "FS", "RF", or "FF".
     * @return a ProductType.
     * @throws BadRequestException if the provided product type string has an invalid value.
     */
    private ProductType getProductTypeFromString(String productTypeStr) {
        return switch (productTypeStr.toLowerCase()) {
            case "fs" -> ProductType.FRESH;
            case "rf" -> ProductType.REFRIGERATED;
            case "ff" -> ProductType.FROZEN;
            default -> throw new BadRequestException("Invalid product type: " + productTypeStr);
        };
    }
}
