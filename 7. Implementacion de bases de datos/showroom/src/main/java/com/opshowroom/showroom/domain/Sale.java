package com.opshowroom.showroom.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


@Setter
@Getter
@Entity
@Table(name = "sales")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long number;
    private LocalDate date;
    private BigDecimal total;
    private String paymentMethod;

    @ManyToMany
    @JoinTable(
            name = "clothe_sale",
            joinColumns = @JoinColumn(name = "clothe_id"),
            inverseJoinColumns= @JoinColumn(name = "sale_id")
    )
    private List<Clothe> products;


}
