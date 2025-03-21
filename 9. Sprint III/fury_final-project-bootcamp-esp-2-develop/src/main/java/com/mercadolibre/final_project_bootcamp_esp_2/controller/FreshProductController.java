package com.mercadolibre.final_project_bootcamp_esp_2.controller;

import com.mercadolibre.final_project_bootcamp_esp_2.dto.BatchSortType;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.ProductStockDTO;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.request.BatchRequestDto;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.request.PurchaseOrderRequestDTO;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.response.BatchStockListDTO;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.response.ProductDTO;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.response.ProductStockAndSectionDTO;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.response.ProductWarehouseDTO;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.response.*;
import com.mercadolibre.final_project_bootcamp_esp_2.service.IBatchService;
import com.mercadolibre.final_project_bootcamp_esp_2.service.IFreshProductService;
import com.mercadolibre.final_project_bootcamp_esp_2.service.IOrderService;
import com.mercadolibre.final_project_bootcamp_esp_2.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.response.BatchStockListDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fresh-products")
@RequiredArgsConstructor
public class FreshProductController {


    private final IProductService productService;
    private final IFreshProductService freshProductService;
    private final IOrderService orderService;
    private final IBatchService batchService;

    @GetMapping("/list")
    public ResponseEntity<List<ProductDTO>> getProducts(
            @RequestParam(required = false) String category) {
        return ResponseEntity.ok(productService.getProductsByType(category));
    }

    @GetMapping("{idProduct}/batch/list")
    public ResponseEntity<?> getFreshProductBatchList(@PathVariable Long idProduct, @RequestParam(required = false) BatchSortType sortType) {
        return ResponseEntity.ok(freshProductService.findProductBatchList(idProduct, sortType));
    }
    @PutMapping("/orders/{orderId}")
    public ResponseEntity<PurchaseOrderRequestDTO> updateOrder (@PathVariable Long orderId,
                                                                @RequestBody PurchaseOrderRequestDTO dto){
        return new ResponseEntity<>(orderService.updateOrderById(orderId, dto), HttpStatus.OK);
    }

    @GetMapping("/{idProduct}/warehouse/list")
    public ResponseEntity<ProductWarehouseDTO> getProductStockInWarehouses(@PathVariable Long idProduct){
        return new ResponseEntity<>(productService.searchProductStockInWarehouses(idProduct), HttpStatus.OK);
    }

    @PostMapping("/inboundorder")
    public ResponseEntity<?> postInboundOrder(@RequestBody BatchRequestDto batchRequestDto) {
        return new ResponseEntity<>(batchService.createInboundOrder(batchRequestDto), HttpStatus.CREATED);
    }

    @PutMapping("/inboundorder")
    public ResponseEntity<?> putInboundOrder(@RequestBody BatchRequestDto batchRequestDto) {
        return new ResponseEntity<>(batchService.updateInboundOrder(batchRequestDto), HttpStatus.CREATED);
    }
    @GetMapping("/{warehouseId}/products/{productId}/stock")
    public ResponseEntity<ProductStockAndSectionDTO> getProductStockByWarehouse(
            @PathVariable Long warehouseId,
            @PathVariable Long productId) {
        return ResponseEntity.ok(productService.getProductStockAndEachSectionByWarehouse(warehouseId, productId));
    }

    @GetMapping("/batch/list/due-date/{cantDays}")
    public ResponseEntity<BatchStockListDTO> getBatchStockByDueDate(
            @PathVariable Integer cantDays,
            @RequestParam(value = "category", required = false) String category,
            @RequestParam(value = "order", required = false) String dateOrder
    ) {
        return ResponseEntity.ok(batchService.searchBatchStockByDueDate(cantDays, category, dateOrder));
    }

    @GetMapping("/stock")
    public ResponseEntity<List<ProductStockDTO>> getProductStock(
            @RequestParam Long warehouseId,
            @RequestParam Long productId) {

        List<ProductStockDTO> stock = orderService.getProductStockByWarehouse(warehouseId, productId);
        return ResponseEntity.ok(stock);
    }

    @GetMapping("/orders/{idOrder}")
    public ResponseEntity<List<ProductDTO>> getProductsInOrder(@PathVariable Long idOrder){
        return new ResponseEntity<>(orderService.searchProductsInOrder(idOrder), HttpStatus.OK);
    }

    @PostMapping("/orders")
    public ResponseEntity<AddToCartResponseDTO> postOrder(@RequestBody PurchaseOrderRequestDTO purchaseOrder){
        return new ResponseEntity<>(orderService.saveOrder(purchaseOrder), HttpStatus.CREATED);
    }
}
