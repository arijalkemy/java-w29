package com.meli.blog.repository;

import com.meli.blog.entity.EntradaBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EntradaBlogRepository {
    public List<EntradaBlog> entradaBlogList;
    public EntradaBlogRepository() {
        entradaBlogList = new ArrayList<>();
        entradaBlogList.add(new EntradaBlog("Edwin", "2025-01-17", 12L, "Primer Blog"));
        entradaBlogList.add(new EntradaBlog("Marta", "2025-01-18", 13L, "Reflexiones sobre la tecnología"));
        entradaBlogList.add(new EntradaBlog("Carlos", "2025-01-19", 14L, "Viajes alrededor del mundo"));
        entradaBlogList.add(new EntradaBlog("Ana", "2025-01-20", 15L, "Recetas de cocina"));
        entradaBlogList.add(new EntradaBlog("Luis", "2025-01-21", 16L, "Fotografía y arte"));
        entradaBlogList.add(new EntradaBlog("Sofia", "2025-01-22", 17L, "Empoderamiento personal"));
    }
}
