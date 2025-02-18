package ejerciciopractico6.productos.ejercicio_practico_6.productos.service;

import ejerciciopractico6.productos.ejercicio_practico_6.productos.dto.MessageDto;
import ejerciciopractico6.productos.ejercicio_practico_6.productos.dto.ProductosDto;
import ejerciciopractico6.productos.ejercicio_practico_6.productos.model.Productos;
import ejerciciopractico6.productos.ejercicio_practico_6.productos.repository.IProductosRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductosService implements IProductosService{
    private final IProductosRepository repository;
    private ModelMapper modelMapper;
    public ProductosService(IProductosRepository repository) {
        this.repository = repository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public MessageDto saveproducto(ProductosDto productoDto) {
        Productos producto = modelMapper.map(productoDto, Productos.class);
        producto.setId(null);
        repository.save(producto);
        return new MessageDto("Producto guardado exitosamente");
    }

    @Override
    public MessageDto updateproducto(String id,ProductosDto productoDto) {
        Productos producto = repository.findById(productoDto.getId()).orElse(null);
        modelMapper.map(productoDto, producto);
        repository.save(producto);
        return new MessageDto("Producto actualizado exitosamente");
    }

    @Override
    public List<ProductosDto> findAllproductos() {
        Page<Productos> productosPage = repository.findAll(Pageable.unpaged()); // Obtener todas las obras sin paginación
        List<Productos> productos = productosPage.getContent();
        return productos.stream().map(producto -> modelMapper.map(producto, ProductosDto.class)).collect(Collectors.toList());
    }
}
