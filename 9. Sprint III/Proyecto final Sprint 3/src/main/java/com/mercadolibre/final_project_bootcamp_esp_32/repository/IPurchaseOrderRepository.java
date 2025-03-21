package com.mercadolibre.final_project_bootcamp_esp_32.repository;

import com.mercadolibre.final_project_bootcamp_esp_32.entities.PurchaseOrder;
import com.mercadolibre.final_project_bootcamp_esp_32.projection.Top5MostSoldProductProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface IPurchaseOrderRepository extends JpaRepository<PurchaseOrder, Integer> {
    @Query("SELECT SUM(pqo.Quantity) FROM ProductPurchaseOrder pqo " +
            "JOIN pqo.purchaseOrder po " +
            "WHERE po.date >= :date")
    Long getTotalOrderedProductsInLast30Days(LocalDate date);

    @Query(value = "SELECT pqo.product.id AS productId, pqo.product.name AS productName, SUM(pqo.Quantity) AS totalSold " +
            "FROM ProductPurchaseOrder pqo " +
            "JOIN pqo.product " +
            "JOIN pqo.purchaseOrder po " +
            "WHERE po.date >= :startDate " +
            "GROUP BY pqo.product.id, pqo.product.name " +
            "ORDER BY totalSold DESC " +
            "LIMIT 5",
            nativeQuery = false)
    List<Top5MostSoldProductProjection> findTop5MostSoldProductsInLast30Days(LocalDate startDate);
}
