package repository;

import model.Beeper;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class BeeperRepositoryImpl implements IRepository<Beeper> {
    private static List<Beeper> beepers = new ArrayList<>();

    @Override
    public void save(Beeper beeper) {
        beepers.add(beeper);
    }

    @Override
    public List<Beeper> getAll() {
        return beepers;
    }

    public List<Beeper> findByClientId(Integer id) {
        return beepers.stream()
            .filter(b -> Objects.equals(b.getClient().getId(), id))
            .toList();
    }
}
