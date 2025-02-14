package com.example.showroom.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "sale_details")
@Data
@IdClass(value = SaleDetailKey.class)
public class SaleDetail {
    @Id
    @ManyToOne
    @JoinColumn(name = "id_sale", referencedColumnName = "id")
    private Sale sale;

    @Id
    @ManyToOne
    @JoinColumn(name = "code_clothe", referencedColumnName = "code")
    private Clothe clothe;

    private Integer quantity;

    private Double subtotal;
}
