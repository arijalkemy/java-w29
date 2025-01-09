import com.mdaneri.BillsRepository;
import com.mdaneri.ClientsRepository;
import com.mdaneri.interfaces.Repository;
import com.mdaneri.models.Bill;
import com.mdaneri.models.Client;
import com.mdaneri.models.Item;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Client c1 = new Client("1234", "Matías", "Zapiola");
        Client c2 = new Client("5678", "Lucas", "Tronador");
        Client c3 = new Client("9101", "Osvaldo", "Heraldo");

        Repository<String, Client> clientsRepository = new ClientsRepository();
        //clientsRepository.save(c1);
        clientsRepository.save(c2);
        clientsRepository.save(c3);

        Bill b1 = new Bill(1L, c1);
        b1.addItem(new Item(123, "Manzana", 2, 10d));
        b1.addItem(new Item(456, "Pera", 2, 20d));
        b1.addItem(new Item(789, "Durazno", 2, 30d));

        Bill b2 = new Bill(2L, c2);
        b2.addItem(new Item(123, "Mouse", 2, 100d));
        b2.addItem(new Item(456, "PC Gamer", 1, 200d));
        b2.addItem(new Item(789, "Monitor", 3, 300d));

        Repository<Long, Bill> billRepository = new BillsRepository(clientsRepository);
        billRepository.save(b1);
        billRepository.save(b2);

        System.out.println("---- Todas las facturas ----");
        List<Bill> bills = billRepository.findAll();
        bills.forEach(System.out::println);

        System.out.println("---- Removida b2 ----");
        bills.remove(b2);
        bills.forEach(System.out::println);

        System.out.println("---- Ingresar nro de factura ----");
        Long searchedID = new Scanner(System.in).nextLong();

        billRepository.findAll()
                .stream()
                .filter(bill -> bill.getId().equals(searchedID))
                .findFirst()
                .ifPresentOrElse(System.out::println,
                        () -> System.out.println("Factura no encontrada"));



    }

}