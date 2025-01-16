import java.util.ArrayList;
import java.util.List;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1st part
        ClientCrud clientCrud = new ClientCrud();
        InvoiceCrud invoicesCrud = new InvoiceCrud(clientCrud);
        int invoiceId = 0;

        Client fstClient = new Client("12345678", "Homer", "Simpson");
        Client sndClient = new Client("23456789", "Lisa", "Simpson");
        Client trdClient = new Client("34567890", "Bart", "Simpson");

        clientCrud.saveEntity(fstClient);
        clientCrud.saveEntity(sndClient);
        clientCrud.saveEntity(trdClient);

        clientCrud.printEntities();

        clientCrud.deleteEntity(sndClient);
        clientCrud.printEntities();

        try (Scanner userInput = new Scanner(System.in)) {
            System.out.print("Enter Client DNI: ");
            String clientDNI = userInput.nextLine();
            clientCrud.printEntity(clientDNI);
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid DNI.");
        }

        // 2nd part
        Item duffBeers = new Item("beer-1", "Duff beer", 6, 2.00 );
        Item donuts = new Item("donut-1", "Sprinkled Donut", 6, 1.00 );
        Invoice fstInvoice = new Invoice(String.valueOf(++invoiceId), fstClient, List.of(duffBeers, donuts));
        invoicesCrud.addInvoice(fstInvoice);
        System.out.println("Invoice's total amount is: " + invoicesCrud.getTotal(fstInvoice));
    }
}