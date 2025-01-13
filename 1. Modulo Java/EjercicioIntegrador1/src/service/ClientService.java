package service;

import model.Client;
import repository.ClientRepositoryImpl;

public class ClientService {
    private ClientRepositoryImpl clientRepository;

    public ClientService() {
        this.clientRepository = new ClientRepositoryImpl();
    }

    public Client createClient(String name) {
        Client client = new Client(name);
        this.clientRepository.save(
            client
        );
        return client;
    }

    public void listClients() {
        this.clientRepository.getAll().forEach(System.out::println);
    }

}
