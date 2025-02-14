package com.example.showroom.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "sales")
@Data
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "id_payment_method", referencedColumnName = "id")
    private PaymentMethod paymentMethod;

    private Double total;

    @OneToMany(mappedBy = "sale")
    private List<SaleDetail> saleDetails;
}
