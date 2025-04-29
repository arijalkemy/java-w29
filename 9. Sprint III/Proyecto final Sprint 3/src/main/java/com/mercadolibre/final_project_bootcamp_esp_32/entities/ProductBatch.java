package com.mercadolibre.final_project_bootcamp_esp_32.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductBatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer batchNumber;
    private Double currentTemperature;
    private Double minimumTemperature;
    private Integer initialQuantity;
    private Integer currentQuantity;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate manufacturingDate;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dueDate;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime manufacturingTime;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "section_code")
    private Section section;

    @ManyToOne
    @JoinColumn(name = "inbound_order_id")
    private InboundOrder inboundOrder;
}
