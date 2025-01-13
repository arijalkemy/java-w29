package org.example.controller.interfaces;

import org.example.model.Beeper;

import java.util.List;

public interface IBeeperRepository {
    List<Beeper> getAll();
    void add(Beeper beeper);
    List<Beeper> getBeepersByClient(String dni);
    Long getId();
}
