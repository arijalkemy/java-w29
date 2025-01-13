package Servicios;

import Modelos.Item;

import java.util.Optional;

public interface IItemService {
    Optional<Item> obtenerItemPorId(String id);
}
