package _3.ejercicio_linktracker.repository;

import _3.ejercicio_linktracker.model.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class LinkRepository implements ILinkRepository{
    private List<Link> linkList = new ArrayList<>();


    @Override
    public Link save(Link l) {
        linkList.add(l);
        return l;
    }

    @Override
    public Optional<Link> findById(Long id) {
        return linkList.stream().filter(l-> l.getId().equals(id)).findFirst();
    }

    @Override
    public void delete(Optional<Link> l) {

        linkList.remove(l);

    }
}
