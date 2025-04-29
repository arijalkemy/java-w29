package com.mercadolibre.final_project_bootcamp_esp_32.entities;


import com.mercadolibre.final_project_bootcamp_esp_32.enums.StatusOrder;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private Buyer buyer;
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private StatusOrder status;
}
