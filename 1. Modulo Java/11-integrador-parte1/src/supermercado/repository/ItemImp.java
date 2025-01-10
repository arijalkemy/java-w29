package supermercado.repository;

import supermercado.model.Cliente;
import supermercado.model.Factura;
import supermercado.model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ItemImp implements CRUDRepository<Item> {
    List<Item> items = new ArrayList<>();
    @Override
    public void guardar(Item obj) {
        items.add(obj);
    }

    @Override
    public void mostrarPorPantalla() {
        items.forEach(System.out::println);
    }

    @Override
    public Optional<Item> buscar(Long id) {
        Item i = (Item) items.stream()
                .filter(it -> it.getCodigo().equals(id))
                .findFirst()
                .orElse(null);
        return Optional.ofNullable(i);
    }

    @Override
    public void eliminar(Long id) {
        Optional<Item> i = this.buscar(id);

        if(i.isEmpty()){
            System.out.println("No existe factura");

        } else {
            items.remove(i.get());
            System.out.println("Se ha eliminado factura");
        }
    }

    @Override
    public List<Item> traerTodos() {
        return items;
    }
}
