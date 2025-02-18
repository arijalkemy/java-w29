package ejerciciopractico6.productos.ejercicio_practico_6.productos.controller;

import ejerciciopractico6.productos.ejercicio_practico_6.productos.dto.MessageDto;
import ejerciciopractico6.productos.ejercicio_practico_6.productos.dto.ProductosDto;
import ejerciciopractico6.productos.ejercicio_practico_6.productos.service.IProductosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductosController {
    private final IProductosService service;

    public ProductosController(IProductosService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductosDto>> getAllProductos() {
        return ResponseEntity.ok(service.findAllproductos());
    }

    @PostMapping("/new")
    public ResponseEntity<MessageDto> postProducto(@RequestBody ProductosDto dto) {
        return ResponseEntity.ok(service.saveproducto(dto));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<MessageDto> putProducto(@RequestBody ProductosDto dto, @PathVariable String id) {
        return ResponseEntity.ok(service.updateproducto(id,dto));
    }
}
