package com.mercadolibre.final_project_bootcamp_esp_32.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class InternalUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String password;

    @OneToOne(mappedBy = "internalUser")
    private Warehouse warehouse;
}
