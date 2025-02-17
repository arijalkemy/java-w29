package exercise.claves_compuestas.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class CompraPK implements Serializable {
    private Long clienteId;
    private LocalDateTime fecha;

    public CompraPK(){}

    public CompraPK(Long clienteId, LocalDateTime fecha) {
        this.clienteId = clienteId;
        this.fecha = fecha;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CompraPK compraPK = (CompraPK) o;
        return Objects.equals(clienteId, compraPK.clienteId) && Objects.equals(fecha, compraPK.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clienteId, fecha);
    }
}
