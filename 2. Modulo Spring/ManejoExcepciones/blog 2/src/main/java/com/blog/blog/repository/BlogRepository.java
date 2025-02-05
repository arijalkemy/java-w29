package com.blog.blog.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.blog.blog.model.EntradaBlog;

@Repository
public class BlogRepository {
    
    private Map<Integer,EntradaBlog> blogs;

    public BlogRepository() {
        blogs = new HashMap<Integer, EntradaBlog>();
    }

    public void addEntrada(EntradaBlog entradaBlog) {
        blogs.put(entradaBlog.getId(), entradaBlog);
    }

    public EntradaBlog getEntradaById(int id) {
        return blogs.get(id);
    }

    public Map<Integer, EntradaBlog> getAllEntradas(){
        return blogs;
    }

    public boolean existsId(int id) {
        return blogs.containsKey(id);
    }

}
