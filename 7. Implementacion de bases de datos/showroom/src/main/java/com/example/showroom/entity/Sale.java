package com.example.showroom.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sales")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer number;
    private Double total;
    @Column(name = "means_of_payment")
    private String meansOfPayment;
    private String date;

    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL)
    private List<SaleDetail> saleDetails;
}
