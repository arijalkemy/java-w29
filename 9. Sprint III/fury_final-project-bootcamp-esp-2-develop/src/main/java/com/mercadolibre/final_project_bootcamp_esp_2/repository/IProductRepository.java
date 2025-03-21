package com.mercadolibre.final_project_bootcamp_esp_2.repository;

import com.mercadolibre.final_project_bootcamp_esp_2.model.Batch;
import com.mercadolibre.final_project_bootcamp_esp_2.model.Product;
import com.mercadolibre.final_project_bootcamp_esp_2.model.util.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByType(ProductType type);

        @Query("SELECT p FROM Product p " +
                "JOIN Batch b ON b.product = p " +
                "JOIN Sector s ON b.sector = s " +
                "JOIN Warehouse w ON s.warehouse = w " +
                "WHERE p.id = :productId AND w.id = :warehouseId")
        List<Product> findProductsInWarehouse(@Param("warehouseId") Long warehouseId, @Param("productId") Long productId);

    @Query(value = "SELECT p.id, p.name, p.unitary_price, SUM(b.current_quantity) AS quantity, p.type " +
            "FROM product p " +
            "JOIN batch b ON b.product_id = p.id " +
            "JOIN sector s ON b.sector_id = s.id " +
            "JOIN warehouse w ON s.warehouse_id = w.id " +
            "WHERE p.id = :productId AND w.id = :warehouseId " +
            "AND b.due_date > CURRENT_DATE + INTERVAL '21' DAY " +
            "GROUP BY p.id, p.name, p.unitary_price, p.type",
            nativeQuery = true)
    List<Object[]> findProductStockByWarehouse(@Param("warehouseId") Long warehouseId,
                                               @Param("productId") Long productId);

    @Query("SELECT b FROM Batch b " +
            "JOIN b.product p " +
            "WHERE p.id = :productId " +
            "AND b.currentQuantity > 0 " + //Cantidad disponible
            "AND b.dueDate > :currentDate " + //Fecha vto
            "ORDER BY b.dueDate ASC") //Ordeno por fecha
    List<Batch> findBatchesByProductAndDueDateGreaterThan(@Param("productId") Long productId,
                                                          @Param("currentDate") LocalDate currentDate);
    @Query(value = """
    SELECT s.id AS sectorId, SUM(b.current_quantity) AS quantity
    FROM sector s
    JOIN batch b ON s.id = b.sector_id
    WHERE b.product_id = :productId AND s.warehouse_id = :warehouseId
    GROUP BY s.id
    """, nativeQuery = true)
    List<Object[]> findSectionsWithProductStock(@Param("productId") Long productId, @Param("warehouseId") Long warehouseId);

    @Query("SELECT w.id, p.id, SUM(b.currentQuantity) " +
            "FROM Warehouse w " +
            "JOIN w.sectors s " +
            "JOIN s.batches b " +
            "JOIN b.product p " +
            "WHERE p.id = :productId " +
            "GROUP BY w.id, p.id")
    List<Object[]> findProductStockInWarehouses(Long productId);
}


