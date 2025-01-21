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
    public Integer metricsForLink(Integer linkId) {
        return repository.stream().filter(link -> link.getId().equals(linkId)).map(Link::getViews).findFirst().orElse(0);
    }

    @Override
    public void invalidateLink(Integer linkId) {
        repository.stream().filter(link -> link.getId().equals(linkId)).findFirst().get().setInvalid(true);
    }


}
