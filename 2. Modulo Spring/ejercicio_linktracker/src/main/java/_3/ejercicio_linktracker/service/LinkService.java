package _3.ejercicio_linktracker.service;

import _3.ejercicio_linktracker.dto.LinkDTO;
import _3.ejercicio_linktracker.exceptions.LinkNotFound;
import _3.ejercicio_linktracker.model.Link;
import _3.ejercicio_linktracker.repository.LinkRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LinkService implements ILinkService{
    private LinkRepository linkRepo;

    public LinkService(LinkRepository linkRepo) {
        this.linkRepo = linkRepo;
    }

    //Crear un link: Endpoint POST para crear link a partir de una URL válida y tiene que devolver un JSON
    // con el linkId para utilizar en la redirección.

    @Override
    public Long saveLink(LinkDTO l) {
        ObjectMapper mapper = new ObjectMapper();
        Link l1 = mapper.convertValue(l, Link.class);
        Link linkSave = linkRepo.save(l1);
        return linkSave.getId();
    }

    //Redirección:  Dado un link (ej: http://localhost:8080/link/{linkId} ) tiene que realizar un redirect
    // a la URL enmascarada. Siempre y cuando el link sea válido. En el caso de que el link sea invalido
    // devolver 404(INVESTIGAR REDIRECT).

    @Override
    public Optional<LinkDTO> redireccion(Long id) {
        Optional<Link> linkFind= linkRepo.findById(id);
        if (linkFind.isPresent()){
            ObjectMapper mapper= new ObjectMapper();
            LinkDTO linkFindDTO = mapper.convertValue(linkFind.get(), LinkDTO.class);
            //cada vez que se encuentra un link para redirreccionar se suma una visita al sitio
            addVisitas(id);
            return Optional.ofNullable(linkFindDTO);
        }else{
            throw new LinkNotFound("No se encontro el link solicitado");
        }
    }


    //sumar una visita al sitio cada vez que se redirecciona al mismo.
    public void addVisitas(Long id){
        Optional<Link> linkFind= linkRepo.findById(id);
        if (linkFind.isPresent()){
            int count1 =linkFind.get().getCount();
            count1 += 1;
            linkFind.get().setCount(count1);
        }

    }

    //Estadísticas por link: Endpoint GET que dado un link (ej: http://localhost:8080/metrics/{linkID} )
    // tiene que devolver la estadística de cantidad de veces que se redireccionó.

    @Override
    public Integer estadistica(Long id) {
        Optional<Link> linkFind= linkRepo.findById(id);
        if (linkFind.isPresent()){
            return linkFind.get().getCount();
        }else{
            throw new LinkNotFound("No se encontro el link solicitado");
        }

    }

    //Invalidate link: Endpoint POST para invalidar un link (ej: http://localhost:8080/invalidate/{linkID}).
    @Override
    public void invalidar(Long id) {
        Optional<Link> linkFind= linkRepo.findById(id);
        if (linkFind.isPresent()){
            linkRepo.delete(Optional.of(linkFind.get()));
        }else{
            throw new LinkNotFound("No se encontro el link solicitado");
        }

    }

    //Al crear los links se tiene que poder agregar un password que va a ser un query param al llamar a la
    // redirección.

    @Override
    public Optional<LinkDTO> redireccion(Long id, String pass) {
        Optional<Link> linkFind= linkRepo.findById(id);
        if (linkFind.isPresent() && linkFind.get().getPassword().equals(pass)){
            ObjectMapper mapper= new ObjectMapper();
            LinkDTO linkFindDTO = mapper.convertValue(linkFind.get(), LinkDTO.class);
            //cada vez que se encuentra un link para redirreccionar se suma una visita al sitio
            addVisitas(id);
            return Optional.ofNullable(linkFindDTO);
        }else{
            throw new LinkNotFound("No se encontro el link solicitado");
        }

    }
}
