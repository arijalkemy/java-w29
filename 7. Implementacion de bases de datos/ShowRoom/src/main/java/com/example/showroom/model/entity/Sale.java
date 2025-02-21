package com.example.showroom.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sales")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long number;
    private Date date;
    private Double total;
    @Column(name = "payment_method")
    private String paymentMethod;
    @ManyToMany
    @JoinTable(
            name = "sales_clothes",
            joinColumns = @JoinColumn(name = "sale_number"),
            inverseJoinColumns = @JoinColumn(name = "clothe_code")
    )
    private List<Clothe> clothes;
}
