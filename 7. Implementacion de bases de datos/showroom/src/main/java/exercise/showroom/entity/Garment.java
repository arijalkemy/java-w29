package exercise.showroom.entity;

import jakarta.persistence.*;

@Entity
public class Garment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String code;

    private String name;
    private String type;
    private String brand;
    private String color;
    private String size;
    private Integer quantity;

    @Column(name = "sale_price")
    private Double salePrice;
}
