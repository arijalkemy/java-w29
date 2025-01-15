package com.example.blog.repository;

import com.example.blog.entity.EntradaBlog;
import com.example.blog.service.BlogServiceImpl;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BlogRepositoryImpl implements IBlogRepository{

    List<EntradaBlog> entradaBlogList;

    public BlogRepositoryImpl(){
        this.entradaBlogList = new ArrayList<>();
    }

    @Override
    public EntradaBlog getById(Long id) {
        return this.entradaBlogList.stream().filter(v -> v.getId() == id).findFirst().orElse(null);
    }

    @Override
    public Long addEntradaBlog(EntradaBlog entradaBlog) {
        this.entradaBlogList.add(entradaBlog);
        return entradaBlog.getId();
    }

    @Override
    public List<EntradaBlog> findAll() {
        return this.entradaBlogList;
    }


    /*@Override
    public Long nextId() {
        return (long) this.entradaBlogList.size();
    }

    @Override
    public Long addEntradaBlog(EntradaBlog entradaBlog) {
        this.entradaBlogList.add(entradaBlog);
        return entradaBlog.getId();
    }*/


}
