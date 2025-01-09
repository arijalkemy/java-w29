import com.mdaneri.models.Client;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Client c1 = new Client("1234", "Matías", "Zapiola");
        Client c2 = new Client("5678", "Lucas", "Tronador");
        Client c3 = new Client("9101", "Osvaldo", "Heraldo");

        System.out.println("---- Todos los clientes ----");
        List<Client> clients = new java.util.ArrayList<>(List.of(c1, c2, c3));
        clients.forEach(System.out::println);

        System.out.println("---- Removido c3 ----");
        clients.remove(c3);
        clients.forEach(System.out::println);

        System.out.println("---- Ingresar DNI ----");
        String searchedDNI = new Scanner(System.in).nextLine();

        clients
                .stream()
                .filter(client -> client.getDni().equals(searchedDNI))
                .findFirst()
                .ifPresentOrElse(System.out::println,
                        () -> System.out.println("No encontrado"));



    }

}