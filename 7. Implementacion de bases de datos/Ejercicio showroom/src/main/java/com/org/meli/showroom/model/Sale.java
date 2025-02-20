package com.org.meli.showroom.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long number;

    private Date date;
    private double total;
    private String paymentMethod;

    @ManyToMany
    @JoinTable(
            name = "sale_garment",
            joinColumns = @JoinColumn(name = "sale_number"),
            inverseJoinColumns = @JoinColumn(name = "garment_id")
    )
    private List<Garment> garments;
}


