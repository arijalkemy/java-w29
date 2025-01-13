package Servicios;

import Modelos.Item;

import java.util.List;
import java.util.Optional;

public class ItemService implements IItemService {

    List<Item> items;

    public ItemService(List<Item> items) {
        this.items = items;
    }

    @Override
    public Optional<Item> obtenerItemPorId(String id) {
        return items
                .stream()
                .filter(it -> it.getCodigo().equals(id))
                .findFirst();
    }
}
