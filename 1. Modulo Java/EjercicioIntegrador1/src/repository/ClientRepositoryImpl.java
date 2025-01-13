package repository;

import model.Client;
import java.util.List;
import java.util.ArrayList;

public class ClientRepositoryImpl implements IRepository<Client> {
    private static final List<Client> clients = new ArrayList<>();

    @Override
    public void save(Client client) {
        clients.add(client);
    }

    @Override
    public List<Client> getAll() {
        return clients;
    }
}
