import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InvoiceCrud implements Crud<Invoice> {
    private List<Invoice> invoices = new ArrayList<>();
    private final ClientCrud clientCrud;

    public InvoiceCrud(ClientCrud clientCrud) {
        this.clientCrud = clientCrud;
    }

    public void addInvoice(Invoice invoice) {
        Client invoiceClient = invoice.getClient();
        if(!clientCrud.getEntities().contains(invoiceClient)) clientCrud.saveEntity(invoiceClient);
        saveEntity(invoice);
    }

    @Override
    public Optional<Invoice> getEntity(String id) {
        return invoices.stream().filter(i -> i.getId().equals(id)).findFirst();
    }

    @Override
    public List<Invoice> getEntities() {
        return invoices;
    }

    @Override
    public void saveEntity(Invoice entity) {
        if(!invoices.contains(entity)) invoices.add(entity);
    }

    @Override
    public void deleteEntity(Invoice entity) {
        invoices.remove(entity);
    }

    @Override
    public void printEntity(String id) {
        Optional<Invoice> invoiceToPrint = getEntity(id);
        invoiceToPrint.ifPresentOrElse(
                System.out::println,
                () -> System.out.println("Invoice with this id: " + id + " does not exist.")
        );
    }

    @Override
    public void printEntities() {
        invoices.forEach(System.out::println);
    }

    public Double getTotal(Invoice invoice) {
        return invoice.getItems().stream()
                .mapToDouble(i ->
                        i.getStock() * i.getUnitaryPrice()
                )
                .sum();
    }
}
