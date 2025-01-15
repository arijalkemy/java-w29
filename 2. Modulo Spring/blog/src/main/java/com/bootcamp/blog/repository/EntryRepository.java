package com.bootcamp.blog.repository;

import com.bootcamp.blog.entity.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class EntryRepository implements IEntryRepository{
    List<EntradaBlog> entries = new ArrayList<>();
    public EntryRepository(){
        entries.add(new EntradaBlog(1,"SomeTitle","SomeAuthor", "12/31/2024"));
        entries.add(new EntradaBlog(2,"AnotherTitle", "Another author", "01/06/2024"));
    }

    @Override
    public EntradaBlog save(EntradaBlog entradaBlog) {
        entries.add(entradaBlog);
        return entradaBlog;
    }

    @Override
    public List<EntradaBlog> findAll() {
        return this.entries;
    }

    @Override
    public Optional<EntradaBlog> findByID(Integer id) {
        return this.entries.stream().filter(e->e.getId().equals(id)).findFirst();
    }
}
