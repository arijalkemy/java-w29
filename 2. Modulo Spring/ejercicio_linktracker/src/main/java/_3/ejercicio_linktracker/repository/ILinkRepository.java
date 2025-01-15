package _3.ejercicio_linktracker.repository;

import _3.ejercicio_linktracker.model.Link;

import java.util.Optional;

public interface ILinkRepository {
    public Link save(Link l);
    public Optional<Link> findById(Long id);
    public void delete(Optional<Link> l);

}
