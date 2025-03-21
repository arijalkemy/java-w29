package com.mercadolibre.final_project_bootcamp_esp_2.service;

import com.mercadolibre.final_project_bootcamp_esp_2.dto.ProductStockDTO;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.request.OrderRequestDTO;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.request.ProductRequestDTO;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.request.PurchaseOrderRequestDTO;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.response.AddToCartResponseDTO;
import com.mercadolibre.final_project_bootcamp_esp_2.dto.response.ProductDTO;
import com.mercadolibre.final_project_bootcamp_esp_2.exceptions.BadRequestException;
import com.mercadolibre.final_project_bootcamp_esp_2.exceptions.NotFoundException;
import com.mercadolibre.final_project_bootcamp_esp_2.model.*;
import com.mercadolibre.final_project_bootcamp_esp_2.model.util.ProductType;
import com.mercadolibre.final_project_bootcamp_esp_2.repository.IOrderRepository;
import com.mercadolibre.final_project_bootcamp_esp_2.repository.IProductRepository;
import com.mercadolibre.final_project_bootcamp_esp_2.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements IOrderService {

    private final IOrderRepository orderRepository;
    private final IProductRepository productRepository;
    private final IUserRepository userRepository;

    @Autowired
    public OrderServiceImpl(IOrderRepository orderRepository, IProductRepository productRepository,
                            IUserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Product> getProductsByWarehouse(Long warehouseId, Long productId) {
        return productRepository.findProductsInWarehouse(warehouseId, productId);
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
    public List<ProductDTO> searchProductsInOrder(Long idOrder) {
        Order order = orderRepository.findById(idOrder)
                .orElseThrow(() -> new NotFoundException("Order " + idOrder + " not found"));

        List<OrderProduct> orderProducts = order.getOrderProducts();

        return orderProducts.stream()
                .map(orderProduct -> new ProductDTO(
                        orderProduct.getProduct().getId(),
                        orderProduct.getOrderQuantity()
                )).toList();
    }

    @Override
    public AddToCartResponseDTO saveOrder(PurchaseOrderRequestDTO purchaseOrderRequestDTO) {

        OrderRequestDTO orderReq = purchaseOrderRequestDTO.getOrderRequestDTO();

        Optional<Order> existingOrder = orderRepository.findByBuyerId(Long.valueOf(orderReq.getBuyerId()));
        if (existingOrder.isPresent()) {
            throw new BadRequestException("Duplicate order for buyer: " + orderReq.getBuyerId());
        }

        User buyer = userRepository.findById(Long.valueOf(orderReq.getBuyerId())).orElseThrow(
                () -> new NotFoundException("Buyer not found with id: " + orderReq.getBuyerId()));

        LocalDate date = orderReq.getDate().toInstant().atZone(ZoneId.of("UTC")).toLocalDate();

        if (date.isAfter(LocalDate.now())) {
            throw new BadRequestException("The order date cannot be in the future.");
        }

        Order purchaseOrder = new Order();
        purchaseOrder.setDate(date);
        purchaseOrder.setBuyer(buyer);

        List<OrderProduct> orderProducts = addProductsToOrder(orderReq, purchaseOrder, date);

        purchaseOrder.setOrderProducts(orderProducts);

        double totalPrice = orderProducts.stream()
                .mapToDouble(op -> op.getProduct().getUnitaryPrice() * op.getOrderQuantity())
                .sum();

        orderRepository.save(purchaseOrder);

        AddToCartResponseDTO responseDTO = new AddToCartResponseDTO();
        responseDTO.setTotalPrice(totalPrice);

        return responseDTO;
    }

    private List<OrderProduct> addProductsToOrder(OrderRequestDTO orderReq, Order purchaseOrder, LocalDate date){
        List<OrderProduct> orderProducts = new ArrayList<>();

        for (ProductRequestDTO productRequestDTO : orderReq.getProducts()) {
            Product product = productRepository.findById((long) productRequestDTO.getProductId())
                    .orElseThrow(() -> new BadRequestException("Product " + productRequestDTO.getProductId() + " not found"));

            List<Batch> batches = productRepository.findBatchesByProductAndDueDateGreaterThan(product.getId(), date);

            int totalAvailableStock = batches.stream().mapToInt(Batch::getCurrentQuantity).sum();

            if (totalAvailableStock < productRequestDTO.getQuantity()) {
                throw new BadRequestException("Insufficient stock of the product: " + product.getName());
            }

            int remainingQuantity = productRequestDTO.getQuantity();

            for (Batch batch : batches) {
                if (remainingQuantity == 0) {
                    break;
                }

                int availableInBatch = batch.getCurrentQuantity();
                if (availableInBatch > 0) {
                    int quantityToTake = Math.min(remainingQuantity, availableInBatch);

                    batch.setCurrentQuantity(availableInBatch - quantityToTake);
                    remainingQuantity -= quantityToTake;
                }
            }

            if (remainingQuantity > 0) {
                throw new BadRequestException("Insufficient stock of the product: " + product.getName());
            }

            OrderProduct orderProduct = new OrderProduct();
            orderProduct.setProduct(product);
            orderProduct.setOrderQuantity(productRequestDTO.getQuantity());
            orderProduct.setOrder(purchaseOrder);
            orderProducts.add(orderProduct);
        }

        return orderProducts;
    }

    @Override
    public PurchaseOrderRequestDTO updateOrderById(Long orderId, PurchaseOrderRequestDTO purchaseOrderRequestDTO) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new NotFoundException("Order not found with id: " + orderId));

        //order.setDate(purchaseOrderRequestDTO.getDate());

        if (order.getOrderProducts() == null) {
            order.setOrderProducts(new ArrayList<>());
        }

        if (purchaseOrderRequestDTO.getOrderRequestDTO().getProducts() != null) {
            for (ProductRequestDTO productDTO : purchaseOrderRequestDTO.getOrderRequestDTO().getProducts()) {
                OrderProduct existingOrderProduct = order.getOrderProducts().stream()
                        .filter(op -> op.getProduct().getId().equals(Long.valueOf(productDTO.getProductId()))) //This filters by a certain product id
                        .findFirst()
                        .orElse(null);

                Product product = productRepository.findById(Long.valueOf(productDTO.getProductId()))
                        .orElseThrow(() -> new NotFoundException("Product not found with id: " + productDTO.getProductId()));
                if(existingOrderProduct != null) {
                    existingOrderProduct.setOrderQuantity(productDTO.getQuantity());
                } else {
                    OrderProduct newOrderProduct = new OrderProduct();
                    newOrderProduct.setOrder(order);
                    newOrderProduct.setProduct(product);
                    newOrderProduct.setOrderQuantity(productDTO.getQuantity());
                    order.getOrderProducts().add(newOrderProduct);
                }
            }
        }
        orderRepository.save(order);
        return purchaseOrderRequestDTO;
    }

}
