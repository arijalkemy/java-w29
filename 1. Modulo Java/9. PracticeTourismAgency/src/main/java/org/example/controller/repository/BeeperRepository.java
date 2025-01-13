package org.example.controller.repository;

import org.example.controller.interfaces.IBeeperRepository;
import org.example.model.Beeper;

import java.util.ArrayList;
import java.util.List;

public class BeeperRepository implements IBeeperRepository {
    List<Beeper> beepers = new ArrayList<>();

    @Override
    public List<Beeper> getAll() {
        return beepers;
    }

    @Override
    public void add(Beeper beeper) {
        beepers.add(beeper);
    }

    @Override
    public List<Beeper> getBeepersByClient(String dni) {
        return beepers.stream()
                .filter(beeper -> beeper.getClient().getDni().equals(dni))
                .toList();
    }

    @Override
    public Long getId() {
        return beepers.isEmpty() ? 1L : beepers.getLast().getId() + 1L;
    }
}
