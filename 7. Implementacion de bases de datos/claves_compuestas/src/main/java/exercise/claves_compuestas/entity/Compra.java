package exercise.claves_compuestas.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter @Setter
@Entity
@Table(name = "compras")
@IdClass(CompraPK.class)
public class Compra {
    @Id
    private Long clienteId;
    @Id
    private LocalDateTime fecha;

    private String estado;
    private BigDecimal montoTotal;
    private String numeroOrden;


}
