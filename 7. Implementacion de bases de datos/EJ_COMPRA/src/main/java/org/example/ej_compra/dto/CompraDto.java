package org.example.ej_compra.dto;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.ej_compra.model.Cliente;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompraDto {


    private LocalDate fecha;

    private Double montoTotal;
}
