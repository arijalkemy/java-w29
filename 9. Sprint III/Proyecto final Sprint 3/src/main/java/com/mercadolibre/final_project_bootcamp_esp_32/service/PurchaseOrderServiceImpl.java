package com.mercadolibre.final_project_bootcamp_esp_32.service;

import com.mercadolibre.final_project_bootcamp_esp_32.dtos.request.ProductPurchaseOrderDTO;
import com.mercadolibre.final_project_bootcamp_esp_32.dtos.request.PurchaseOrderRequestDto;
import com.mercadolibre.final_project_bootcamp_esp_32.dtos.response.*;
import com.mercadolibre.final_project_bootcamp_esp_32.entities.Buyer;
import com.mercadolibre.final_project_bootcamp_esp_32.entities.Product;
import com.mercadolibre.final_project_bootcamp_esp_32.entities.ProductPurchaseOrder;
import com.mercadolibre.final_project_bootcamp_esp_32.entities.PurchaseOrder;
import com.mercadolibre.final_project_bootcamp_esp_32.enums.StatusOrder;
import com.mercadolibre.final_project_bootcamp_esp_32.exceptions.ApiException;
import com.mercadolibre.final_project_bootcamp_esp_32.repository.*;
import com.mercadolibre.final_project_bootcamp_esp_32.util.MappingUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PurchaseOrderServiceImpl implements IPurchaseOrderService {
    private final IPurchaseOrderRepository purchaseOrderRepository;
    private final IBuyerRepository buyerRepository;
    private final IProductRepository productRepository;
    private final IBatchRepository batchRepository;
    private final IProductPurchaseOrderRepository productPurchaseOrderRepository;
    private final AuthService authService;

    @Override
    public PurchaseOrderResponseDto createPurchaseOrder(PurchaseOrderRequestDto order) {
        Optional<Buyer> currentUser = buyerRepository.findById(order.getBuyerId());
        if (currentUser.isEmpty()) {
            throw new ApiException("404","El comprador no existe",404);
        }

        StockVerificationResult stockVerificationResult = validateStockAndExpiration(order.getProducts());

        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrder.setBuyer(currentUser.get());
        purchaseOrder.setDate(LocalDate.now());
        purchaseOrder.setStatus(StatusOrder.valueOf("CART"));
        double totalPrice = 0.0;
        List<ProductErrorDto> productErrors = new ArrayList<>();

        PurchaseOrder savedOrder = null;

        if (!stockVerificationResult.getProductosConStock().isEmpty()) {
            savedOrder = purchaseOrderRepository.save(purchaseOrder);

            List<ProductPurchaseOrder> productOrders = new ArrayList<>();
            for (ProductPurchaseOrderDTO productDTO : stockVerificationResult.getProductosConStock()) {
                Product product = productRepository.findById(productDTO.getProductId())
                        .orElseThrow(() -> new ApiException("404", "El producto no fue encontrado", 404));

                ProductPurchaseOrder productPurchaseOrder = new ProductPurchaseOrder();
                productPurchaseOrder.setPurchaseOrder(savedOrder);
                productPurchaseOrder.setProduct(product);
                productPurchaseOrder.setQuantity(productDTO.getQuantity());
                productOrders.add(productPurchaseOrder);

                totalPrice += product.getPrice() * productDTO.getQuantity();
            }

            productPurchaseOrderRepository.saveAll(productOrders);
        }

        for (ProductPurchaseOrderDTO productDTO : stockVerificationResult.getProductosSinStock()) {
            Product product = productRepository.findById(productDTO.getProductId())
                    .orElseThrow(() -> new ApiException("404", "El producto no fue encontrado", 404));

            ProductErrorDto error = new ProductErrorDto();
            error.setProductId(productDTO.getProductId());
            error.setProductName(product.getName());
            error.setErrorMessage("No hay suficiente stock disponible");
            productErrors.add(error);
        }
        PurchaseOrderResponseDto response = new PurchaseOrderResponseDto();
        if (!stockVerificationResult.getProductosConStock().isEmpty()) {
            response.setTotalPrice(totalPrice);
        }

        if (savedOrder != null) {
            response.setOrderId(savedOrder.getId());
        }

        response.setProductErrors(productErrors);

        return response;
    }

    @Override
    public ProductsPurchaseOrderDto listProductsByPurchaseOrder(Integer idOrder) {
        Optional<PurchaseOrder> order = purchaseOrderRepository.findById(idOrder);
        if (order.isEmpty()) {
            throw new ApiException("404","La orden no existe",404);
        }
        List<ProductPurchaseOrder> productsList = productPurchaseOrderRepository.findByPurchaseOrder_Id(idOrder);
        return MappingUtil.productPurchaseOrderToProductsPurchaseOrderDto(productsList);
    }

    @Override
    public PurchasedProductsByDateRangeDto searchPurchasedProductsByDateRange(HttpServletRequest httpServletRequest) {
        authService.validateInternalUser(httpServletRequest);
        LocalDate thirtyDaysAgo = LocalDate.now().minus(30, ChronoUnit.DAYS);
        Long totalProducts = purchaseOrderRepository.getTotalOrderedProductsInLast30Days(thirtyDaysAgo);
        List<ProductMostOrdererDto> topFiveProducts = purchaseOrderRepository.findTop5MostSoldProductsInLast30Days(thirtyDaysAgo).stream()
                .map(MappingUtil::top5MostSoldProductProjectionToProductMostOrdererDto)
                .toList();
        return new PurchasedProductsByDateRangeDto(totalProducts,topFiveProducts);
    }

    private StockVerificationResult validateStockAndExpiration(List<ProductPurchaseOrderDTO> products) {
        LocalDate threeMonthsFromNow = LocalDate.now().plusMonths(3);
        Map<Boolean, List<ProductPurchaseOrderDTO>> stockMap = products.stream()
                .collect(Collectors.partitioningBy(product -> {
                    Integer availableStock = batchRepository.sumCurrentQuantity(
                            product.getProductId(), threeMonthsFromNow);

                    return availableStock != null && availableStock >= product.getQuantity();
                }));

        List<ProductPurchaseOrderDTO> productosConStock = stockMap.get(true);
        List<ProductPurchaseOrderDTO> productosSinStock = stockMap.get(false);

        return new StockVerificationResult(productosConStock, productosSinStock);
    }

    public static class StockVerificationResult {
        private final List<ProductPurchaseOrderDTO> productosConStock;
        private final List<ProductPurchaseOrderDTO> productosSinStock;

        public StockVerificationResult(List<ProductPurchaseOrderDTO> productosConStock, List<ProductPurchaseOrderDTO> productosSinStock) {
            this.productosConStock = productosConStock;
            this.productosSinStock = productosSinStock;
        }

        public List<ProductPurchaseOrderDTO> getProductosConStock() {
            return productosConStock;
        }

        public List<ProductPurchaseOrderDTO> getProductosSinStock() {
            return productosSinStock;
        }
    }

    @Override
    @Transactional
    public PurchaseOrderResponseDto updatePurchaseOrder(Integer idOrder, PurchaseOrderRequestDto updatedOrder) {
        PurchaseOrder purchaseOrder = purchaseOrderRepository.findById(idOrder)
                .orElseThrow(() -> new ApiException("404", "La orden no existe", 404));

        if (purchaseOrder.getStatus() == null || !purchaseOrder.getStatus().equals(StatusOrder.CART)) {
            throw new ApiException("400", "Solo se pueden modificar órdenes en estado CART", 400);
        }

        for (ProductPurchaseOrderDTO productDTO : updatedOrder.getProducts()) {
            if (productDTO.getQuantity() <= 0) {
                throw new ApiException("400", "La cantidad del producto debe ser mayor a 0", 400);
            }
            productRepository.findById(productDTO.getProductId())
                    .orElseThrow(() -> new ApiException("404", "Producto no encontrado", 404));
        }

        Buyer buyer = buyerRepository.findById(updatedOrder.getBuyerId())
                .orElseThrow(() -> new ApiException("404", "Buyer not found", 404));

        if (!purchaseOrder.getBuyer().getId().equals(buyer.getId())) {
            throw new ApiException("403", "No puedes modificar una orden de otro usuario", 403);
        }

        StockVerificationResult stockVerificationResult = validateStockAndExpiration(updatedOrder.getProducts());

        double totalPrice = 0.0;
        List<ProductErrorDto> productErrors = new ArrayList<>();

        productPurchaseOrderRepository.deleteByOrderId(idOrder);

        List<ProductPurchaseOrder> newProductOrders = new ArrayList<>();

        if (!stockVerificationResult.getProductosConStock().isEmpty()) {
            for (ProductPurchaseOrderDTO productDTO : stockVerificationResult.getProductosConStock()) {
                Product product = productRepository.findById(productDTO.getProductId()).orElseThrow(() -> new ApiException("404", "Producto no encontrado", 404));

                ProductPurchaseOrder productPurchaseOrder = new ProductPurchaseOrder();
                productPurchaseOrder.setPurchaseOrder(purchaseOrder);
                productPurchaseOrder.setProduct(product);
                productPurchaseOrder.setQuantity(productDTO.getQuantity());
                newProductOrders.add(productPurchaseOrder);

                totalPrice += product.getPrice() * productDTO.getQuantity();
            }

            productPurchaseOrderRepository.saveAll(newProductOrders);
        }

        for (ProductPurchaseOrderDTO productDTO : stockVerificationResult.getProductosSinStock()) {
            Product product = productRepository.findById(productDTO.getProductId()).orElseThrow(() -> new ApiException("404", "Producto no encontrado", 404));

            ProductErrorDto error = new ProductErrorDto();
            error.setProductId(productDTO.getProductId());
            error.setProductName(product.getName());
            error.setErrorMessage("No hay suficiente stock disponible");
            productErrors.add(error);
        }
        PurchaseOrderResponseDto response = new PurchaseOrderResponseDto();
        response.setTotalPrice(totalPrice);
        response.setProductErrors(productErrors);

        return response;
    }
}