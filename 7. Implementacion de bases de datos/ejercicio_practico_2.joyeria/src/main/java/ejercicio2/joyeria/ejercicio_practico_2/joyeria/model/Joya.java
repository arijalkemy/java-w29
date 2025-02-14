package ejercicio2.joyeria.ejercicio_practico_2.joyeria.model;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter
@Entity
@Table(name = "joyas")
public class Joya {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long nroIdentificatorio;
    private String nombre;
    private String material;
    private Double peso;
    private String particularidad;
    @Column(name = "posee_piedra")
    private Boolean poseePiedra;
    @Column(name = "venta")
    private Boolean ventaONo;

    public Joya() {
    }

    public Joya(Long nroIdentificatorio, String nombre, String material, Double peso, String particularidad, Boolean poseePieda, Boolean ventaONo) {
        this.nroIdentificatorio = nroIdentificatorio;
        this.nombre = nombre;
        this.material = material;
        this.peso = peso;
        this.particularidad = particularidad;
        this.poseePiedra = poseePieda;
        this.ventaONo = ventaONo;
    }
}