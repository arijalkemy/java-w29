package ejerciciopractico6.productos.ejercicio_practico_6.productos.service;

import ejerciciopractico6.productos.ejercicio_practico_6.productos.dto.MessageDto;
import ejerciciopractico6.productos.ejercicio_practico_6.productos.dto.ProductosDto;

import java.util.List;

public interface IProductosService {
    MessageDto saveproducto(ProductosDto productoDto);
    MessageDto updateproducto(String id ,ProductosDto productoDto);
    List<ProductosDto> findAllproductos();
}
