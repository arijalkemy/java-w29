package Repository;

import Models.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemRepository implements CRUD<Item> {
    private List<Item> items;

    public ItemRepository() {
        items = new ArrayList<>();
    }

    @Override
    public void create(Item item) {
        if (!items.contains(item)) {
            item.setId(items.size() + 1);
            items.add(item);
            System.out.println("Cliente adicionado com sucesso");
        }else{
            System.out.println("El cliente ya se encuentra registrado");
        }
    }

    @Override
    public void delete(Integer id) {
        this.items.removeIf(e -> e.getId() == id);
    }

    @Override
    public Item get(Integer id) {
        return this.items.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Item> getAll() {
        return this.items;
    }
}
