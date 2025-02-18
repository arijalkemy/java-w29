package hql.showroom.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "sales")
@Getter
@Setter
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String number;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private Double total;

    @Column(nullable = false)
    private String paymentMethod;

    @ManyToMany
    @JoinTable(
            name = "sale_clothing",
            joinColumns = @JoinColumn(name = "sale_id"),
            inverseJoinColumns = @JoinColumn(name = "clothing_id")
    )
    private List<Clothing> clothingList;
}
