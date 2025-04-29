package com.mercadolibre.final_project_bootcamp_esp_32.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer warehouseCode;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "internal_user_id")
    private InternalUser internalUser;
}
