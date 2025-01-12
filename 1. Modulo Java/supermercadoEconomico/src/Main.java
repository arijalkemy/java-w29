import Models.Cliente;
import Models.Factura;
import Models.Item;
import Repository.ClienteRepository;
import Repository.FacturaRepository;
import Repository.ItemRepository;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        ClienteRepository clienteRepository = new ClienteRepository();
        FacturaRepository facturaRepository = new FacturaRepository();
        ItemRepository itemRepository = new ItemRepository();

        Item celular = new Item("A1","Celular",2,4000);
        Item carro = new Item("A2","Carro",2,4000);
        List<Item> items = new ArrayList<>();

        items.add(celular);
        items.add(carro);

        Cliente c1 = new Cliente("1007","Jose","Cruz");
        Factura f1 = new Factura(c1,items);
        Factura f2 = new Factura(c1,items);
        Factura f3 = new Factura(c1,items);

        Cliente c2 = new Cliente("1008","David","Hernandez");
        Factura f4 = new Factura(c2,items);
        Factura f5 = new Factura(c2,items);
        Factura f6 = new Factura(c2,items);

        Cliente c3 = new Cliente("1009","Daniela","Rodriguez");
        Factura f7 = new Factura(c3,items);
        Factura f8 = new Factura(c3,items);
        Factura f9 = new Factura(c3,items);

        clienteRepository.create(c1);
        clienteRepository.create(c2);
        facturaRepository.create(f1);
        facturaRepository.create(f2);
        facturaRepository.create(f3);

        System.out.println(clienteRepository.get(1));
        System.out.println(facturaRepository.get(3));



    }

}