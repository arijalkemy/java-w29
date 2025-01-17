package meli.linktacker.repository;

import meli.linktacker.entity.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class LinkRepositoryImpl implements ILinkRepository{

    List<Link> repository = new ArrayList<>();

    @Override
    public Integer addLink(Link link) {
        repository.add(link);
        return link.getId();
    }

    @Override
    public Optional<Link> getLink(Integer linkId) {
        return repository.stream().filter(link -> link.getId().equals(linkId)).findFirst();
    }

    @Override
    public void updateViews(Link link, Integer views) {
        link.setViews(views);
    }

    @Override
    public void removeLink(Link link) {
        repository.remove(link);
    }
}
