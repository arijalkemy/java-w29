import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientCrud implements Crud<Client> {
    private List<Client> clients = new ArrayList<>();

    @Override
    public Optional<Client> getEntity(String id) {
        return clients.stream().filter(c -> c.getDni().equals(id)).findFirst();
    }

    @Override
    public List<Client> getEntities() {
        return clients;
    }

    @Override
    public void deleteEntity(Client entity) {
        clients.remove(entity);
    }

    @Override
    public void saveEntity(Client entity) {
        if(!clients.contains(entity)) clients.add(entity);
    }

    @Override
    public void printEntity(String id) {
        Optional<Client> clientToPrint = getEntity(id);
        clientToPrint.ifPresentOrElse(
                System.out::println,
                () -> System.out.println("Invalid Client DNI")
        );
    }

    @Override
    public void printEntities() {
        clients.forEach(System.out::println);
    }
}
