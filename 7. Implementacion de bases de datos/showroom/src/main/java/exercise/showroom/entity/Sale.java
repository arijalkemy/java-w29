package exercise.showroom.entity;

import exercise.showroom.enums.PaymentType;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private LocalDateTime date;
    private Double total;

    @Column(name = "payment_type")
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;
}
