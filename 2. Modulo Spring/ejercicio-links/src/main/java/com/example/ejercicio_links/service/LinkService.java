package com.example.ejercicio_links.service;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Optional;

import com.example.ejercicio_links.entity.Link;
import com.example.ejercicio_links.repository.LinkRepository;
import org.springframework.stereotype.Service;

@Service
public class LinkService {
    private final LinkRepository linkRepository;

    public LinkService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public int ingresarLink(Link link){
        if(isValidUrl(link.getUrl())){
            return linkRepository.addLink(link);
        }else{
            throw new RuntimeException();
        }

    }

    public String redireccion(int id){
        Optional<Link> linkOptional = linkRepository.findByID(id);
        Link link = linkOptional.get(); // Extrae el link del
        if(isValidUrl(link.getUrl())){
            return link.getUrl();
        }else {
            throw new RuntimeException();

            //En el caso de que el link sea invalido devolver 404(INVESTIGAR REDIRECT).
        }
        /*if(linkOptional.isEmpty()){
            return "";
        }*/
    }

    public static boolean isValidUrl(String url) {
        try {
            // Intentamos crear un objeto URL
            URL u = new URL(url);
            // Verificamos que la URL se pueda convertir a URI
            URI uri = u.toURI();
            return true;
        } catch (MalformedURLException | URISyntaxException e) {
            // Si ocurre una excepción, la URL no es válida
            return false;
        }
    }

}
