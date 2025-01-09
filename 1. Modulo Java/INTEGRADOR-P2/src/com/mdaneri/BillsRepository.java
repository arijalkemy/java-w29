package com.mdaneri;

import com.mdaneri.interfaces.Repository;
import com.mdaneri.models.Bill;
import com.mdaneri.models.Client;

import java.util.*;

public class BillsRepository implements Repository<Long, Bill> {

    private Repository<String, Client> clientRepository;
    private Set<Bill> bills;

    public BillsRepository(Repository<String, Client> clientsRepository) {
        this.clientRepository = clientsRepository;
        this.bills = new HashSet<>();
    }

    @Override
    public List<Bill> findAll() {
        return new ArrayList<>(bills);
    }

    @Override
    public Optional<Bill> findById(Long id) {
        return bills.stream().filter(b -> b.getId().equals(id)).findFirst();
    }

    @Override
    public void save(Bill bill) {
        if (clientRepository.findById(bill.getClient().getDni()).isEmpty())
            clientRepository.save(bill.getClient());
        bills.add(bill);
    }

    @Override
    public void delete(Bill bill) {
        bills.remove(bill);
    }

    @Override
    public void update(Bill bill) {
        bills
                .stream()
                .filter(b -> b.getId().equals(bill.getId()))
                .findFirst()
                .ifPresent(b -> {
                    b.setItems(bill.getItems());
                    b.setTotalCost(bill.getTotalCost());
                });
    }
}
