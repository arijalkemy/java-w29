package ejerciciopractico6.productos.ejercicio_practico_6.productos.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter @Setter
public class ProductosDto {
    private String id;
    private String nombre;
    private String tipo;
    private Double precioVenta;
    private Double precioCosto;
    private Integer cantidad;

    public ProductosDto(String id, String nombre, String tipo, Double precioVenta, Double precioCosto, Integer cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.precioVenta = precioVenta;
        this.precioCosto = precioCosto;
        this.cantidad = cantidad;
    }

    public ProductosDto() {
    }
}
