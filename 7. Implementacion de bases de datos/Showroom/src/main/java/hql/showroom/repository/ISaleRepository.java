package hql.showroom.repository;

import hql.showroom.model.Clothing;
import hql.showroom.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ISaleRepository extends JpaRepository<Sale, Long> {

    @Query("SELECT s FROM Sale s JOIN FETCH s.clothingList")
    List<Sale> getAllSalesWithClothing();

    @Query("SELECT s FROM Sale s WHERE s.date = :date")
    List<Sale> getSalesByDate(@Param("date") LocalDate date);

    @Query("SELECT s FROM Sale s WHERE s.paymentMethod = :paymentMethod")
    List<Sale> getSalesByPaymentMethod(@Param("paymentMethod") String paymentMethod);

    @Query("SELECT DISTINCT c FROM Sale s JOIN s.clothingList c WHERE s.date BETWEEN :startDate AND :endDate")
    List<Clothing> getClothingSoldBetweenDates(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
