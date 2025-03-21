package com.mercadolibre.final_project_bootcamp_esp_32.repository;

import com.mercadolibre.final_project_bootcamp_esp_32.entities.InboundOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInboundOrderRepository extends JpaRepository<InboundOrder,Long> {
    InboundOrder findByOrderNumber(Integer orderNumber);
}
