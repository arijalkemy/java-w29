package _3.ejercicio_linktracker.service;

import _3.ejercicio_linktracker.dto.LinkDTO;

import java.util.Optional;

public interface ILinkService {
    //Crear un link
    public Long saveLink(LinkDTO l);

    //Redirección
    public Optional<LinkDTO> redireccion(Long id);

    //Redirección con password
    public Optional<LinkDTO> redireccion(Long id,String pass);

    //Estadísticas por link -> la cantidad de veces que se se entro a ese link
    public Integer estadistica(Long id);

    //Invalidate link
    public void invalidar (Long id);

}
