package org.example.repository;

import org.example.model.Locator;

import java.util.ArrayList;
import java.util.List;

public class LocatorRepository {
    List<Locator> locators;

    public LocatorRepository() {
        this.locators = new ArrayList<>();
    }

    public List<Locator> findAll() {
        return locators;
    }

    public List<Locator> findByClientId(Long id) {
        return List.of();
    }

    public Boolean save(Locator entity) {
        return locators.add(entity);
    }

    public Boolean delete(Locator entity) {
        return null;
    }
}
