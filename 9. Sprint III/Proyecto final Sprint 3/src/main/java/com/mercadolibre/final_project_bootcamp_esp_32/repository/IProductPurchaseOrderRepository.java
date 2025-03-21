package com.mercadolibre.final_project_bootcamp_esp_32.repository;

import com.mercadolibre.final_project_bootcamp_esp_32.entities.ProductPurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProductPurchaseOrderRepository extends JpaRepository<ProductPurchaseOrder, Integer> {
    List<ProductPurchaseOrder> findByPurchaseOrder_Id(Integer purchaseOrderId);

    @Modifying
    @Query("DELETE FROM ProductPurchaseOrder p WHERE p.purchaseOrder.id = :orderId")
    void deleteByOrderId(@Param("orderId") Integer orderId);
}
