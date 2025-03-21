package com.mercadolibre.final_project_bootcamp_esp_32.repository;

import com.mercadolibre.final_project_bootcamp_esp_32.entities.ProductBatch;
import com.mercadolibre.final_project_bootcamp_esp_32.enums.ProductType;
import com.mercadolibre.final_project_bootcamp_esp_32.projection.WarehouseStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public interface IBatchRepository extends JpaRepository<ProductBatch, Integer> {

    List<ProductBatch> findByDueDateBetweenAndProduct_ProductTypeInAndSection_Warehouse_WarehouseCodeOrderByDueDateAsc(
            LocalDate lowerBound, LocalDate upperBound, Collection<ProductType> categories, Integer warehouseCode);

    List<ProductBatch> findByProduct_Id(Integer productId);

    List<ProductBatch> findByProduct_IdAndSection_Warehouse_InternalUser_IdAndDueDateGreaterThanEqual(Integer productId, Integer internalUser, LocalDate dueDate);
    List<ProductBatch> findByProduct_IdAndSection_Warehouse_InternalUser_IdAndDueDateGreaterThanEqualOrderByDueDate(Integer productId, Integer internalUser, LocalDate dueDate);
    List<ProductBatch> findByProduct_IdAndSection_Warehouse_InternalUser_IdAndDueDateGreaterThanEqualOrderByBatchNumber(Integer productId, Integer internalUser, LocalDate dueDate);
    List<ProductBatch> findByProduct_IdAndSection_Warehouse_InternalUser_IdAndDueDateGreaterThanEqualOrderByCurrentQuantity(Integer productId, Integer internalUser, LocalDate dueDate);

    @Query("SELECT SUM(pb.currentQuantity) FROM ProductBatch pb WHERE pb.product.id = :productId AND pb.dueDate > :dueDate")
    Integer sumCurrentQuantity(@Param("productId") Integer productId, @Param("dueDate") LocalDate dueDate);

    @Query("SELECT w.warehouseCode AS warehouseCode, SUM(pb.currentQuantity) AS totalQuantity " +
            "FROM ProductBatch pb " +
            "JOIN pb.section.warehouse w " +
            "WHERE pb.product.id = :productId " +
            "GROUP BY w.warehouseCode")
    List<WarehouseStock> findProductBatchSumGroupedByWarehouse(@Param("productId") Integer productId);
}
