package com.mercadolibre.final_project_bootcamp_esp_2.repository;

import com.mercadolibre.final_project_bootcamp_esp_2.model.Batch;
import com.mercadolibre.final_project_bootcamp_esp_2.model.Product;
import com.mercadolibre.final_project_bootcamp_esp_2.model.util.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface BatchRepository extends JpaRepository<Batch, Long> {

    @Query("SELECT p FROM Batch b " +
            "JOIN b.product p " +
            "JOIN b.sector s " +
            "JOIN s.warehouse w " +
            "WHERE p.id = :productId AND w.id = :warehouseId")
    Optional<Product> fetchProduct(@Param("productId") Long productId, @Param("warehouseId") Long warehouseId);

    @Query("SELECT b FROM Batch b " +
            "JOIN b.product p " +
            "JOIN b.sector s " +
            "WHERE s.id = :sectorId AND p.id = :productId")
    List<Batch> findBatchBySectorIdAndProductId(@Param("sectorId") Long sectorId, @Param("productId") Long productId);

    @Query("SELECT b FROM Batch b " +
            "JOIN b.product p " +
            "JOIN b.sector s " +
            "WHERE s.id = :sectorId AND p.id = :productId " +
            "ORDER BY b.batchNumber")
    List<Batch> findBatchBySectorIdSortedByBatchNumber(@Param("sectorId") Long sectorId, @Param("productId") Long productId);

    @Query("SELECT b FROM Batch b " +
            "JOIN b.product p " +
            "JOIN b.sector s " +
            "WHERE s.id = :sectorId AND p.id = :productId " +
            "ORDER BY b.currentQuantity")
    List<Batch> findBatchBySectorIdSortedByCurrentQuantity(@Param("sectorId") Long sectorId, @Param("productId") Long productId);

    @Query("SELECT b FROM Batch b " +
            "JOIN b.product p " +
            "JOIN b.sector s " +
            "WHERE s.id = :sectorId AND p.id = :productId " +
            "ORDER BY b.dueDate")
    List<Batch> findBatchBySectorIdSortedByDueDate(@Param("sectorId") Long sectorId, @Param("productId") Long productId);

    /**
     * Provides the supervisor's warehouse batches that are about to expire between the received start and end dates.
     *
     * @param supervisorId the supervisor's id.
     * @param startDate the start due date.
     * @param endDate the end due date.
     * @return a Batch list.
     */
    @Query(
            "SELECT b FROM Batch b " +
                    "JOIN b.sector s " +
                    "JOIN s.warehouse w " +
                    "JOIN w.supervisor u " +
                    "WHERE u.id = :supervisorId " +
                    "AND b.dueDate BETWEEN :startDate AND :endDate "
    )
    List<Batch> findBySupervisorAndDueDateRange(
            @Param("supervisorId") Long supervisorId,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );

    Optional<Batch> findByBatchNumber(Integer batchNumber);
    /**
     * Provides the supervisor's warehouse batches that are about to expire between the received start and end dates,
     * ordered by due date, belonging to a specific product category.
     *
     * @param supervisorId the supervisor's id.
     * @param startDate the start due date.
     * @param endDate the end due date.
     * @param productType the type of product of every batch.
     * @param dateOrder date ordering.
     * @return a Batch list.
     */
    @Query(
            "SELECT b FROM Batch b " +
                    "JOIN b.product p " +
                    "JOIN b.sector s " +
                    "JOIN s.warehouse w " +
                    "JOIN w.supervisor u " +
                    "WHERE u.id = :supervisorId " +
                    "AND b.dueDate BETWEEN :startDate AND :endDate " +
                    "AND p.type = :productType " +
                    "ORDER BY " +
                    "CASE WHEN :dateOrder = 'DATE_ASC' THEN b.dueDate END ASC, " +
                    "CASE WHEN :dateOrder = 'DATE_DESC' THEN b.dueDate END DESC"
    )
    List<Batch> findBySupervisorAndDueDateRangeAndProductTypeAndSortedByDate(
            @Param("supervisorId") Long supervisorId,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate,
            @Param("productType") ProductType productType,
            @Param("dateOrder") String dateOrder
    );
}
