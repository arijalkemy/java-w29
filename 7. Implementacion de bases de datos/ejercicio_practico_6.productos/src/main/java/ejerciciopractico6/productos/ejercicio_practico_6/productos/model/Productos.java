package ejerciciopractico6.productos.ejercicio_practico_6.productos.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter @Setter
@Document(indexName = "products")
public class Productos {
    @Id
    private String id;
    private String nombre;
    private String tipo;
    private Double precioVenta;
    private Double precioCosto;
    private Integer cantidad;

    public Productos(String id, String nombre, String tipo, Double precioVenta, Double precioCosto, Integer cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.precioVenta = precioVenta;
        this.precioCosto = precioCosto;
        this.cantidad = cantidad;
    }

    public Productos() {
    }
}
