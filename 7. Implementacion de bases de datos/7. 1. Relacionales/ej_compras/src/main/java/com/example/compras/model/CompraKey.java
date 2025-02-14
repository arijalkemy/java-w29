package com.example.compras.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@AllArgsConstructor
@Getter @Setter
@NoArgsConstructor
public class CompraKey implements Serializable {
    private Cliente cliente;

    private LocalDate fecha;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompraKey that)) return false;
        return cliente.equals(that.cliente) && fecha.equals(that.fecha);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(cliente, fecha);
    }
}
