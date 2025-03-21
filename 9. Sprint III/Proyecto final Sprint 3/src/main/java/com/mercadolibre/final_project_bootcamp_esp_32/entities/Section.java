package com.mercadolibre.final_project_bootcamp_esp_32.entities;

import com.mercadolibre.final_project_bootcamp_esp_32.enums.ProductType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sectionCode;

    @ManyToOne
    @JoinColumn(name = "warehouse_code")
    private Warehouse warehouse;

    @Enumerated(EnumType.STRING)
    private ProductType sectionType;
}
