package _3.ejercicio_linktracker.controller;

import _3.ejercicio_linktracker.dto.LinkDTO;
import _3.ejercicio_linktracker.repository.LinkRepository;
import _3.ejercicio_linktracker.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class LinkController {

    @Autowired
    private LinkService service;
    @Autowired
    private LinkRepository linkRepository;

    //Crear un link: Endpoint POST para crear link a partir de una URL válida y tiene que devolver un JSON
    // con el linkId para utilizar en la redirección.
    @PostMapping("link/")
    public ResponseEntity<?> createlink(@RequestBody LinkDTO link){

        return ResponseEntity.ok("el link creado fue con id : " +service.saveLink(link));
    }

    //Redirección:  Dado un link (ej: http://localhost:8080/link/{linkId} ) tiene que realizar un redirect
    // a la URL enmascarada. Siempre y cuando el link sea válido. En el caso de que el link sea invalido
    // devolver 404(INVESTIGAR REDIRECT).
    @GetMapping("/link/{idLink}")
    public ResponseEntity<?> redireccionarLink(@PathVariable Long idLink){
        Optional<LinkDTO> link = service.redireccion(idLink);

        //redireccionar url
        String url = link.get().getLink(); // Obtén la URL del DTO

        // Verifica que la URL sea válida antes de redirigir
        if (url != null && !url.isEmpty()) {
            // Realiza la redirección utilizando un ResponseEntity
            return ResponseEntity.status(302) // Código 302 (Found)
                    .header("Location", url) // Especifica la URL destino
                    .build();
        }


        // En caso de que el link no exista o no sea válido
        return ResponseEntity.status(404).body("El enlace no existe");

    }

    //Estadísticas por link: Endpoint GET que dado un link (ej: http://localhost:8080/metrics/{linkID} )
    // tiene que devolver la estadística de cantidad de veces que se redireccionó.

    @GetMapping("metrics/{idLink}")
    public ResponseEntity<?> metricasLink(@PathVariable Long idLink){
        return ResponseEntity.ok("La cantidad de veces que se consulto el link id: " +idLink + " es : " +service.estadistica(idLink) );
    }

    //Invalidate link: Endpoint POST para invalidar un link (ej: http://localhost:8080/invalidate/{linkID} ).
    @PostMapping("invalidate/{idLink}")
    public ResponseEntity<?> invalidarLink(@PathVariable Long idLink){
        service.invalidar(idLink);
        return ResponseEntity.ok("Se invalidó el link con id : " +idLink );
    }

    //Al crear los links se tiene que poder agregar un password que va a ser un query param al llamar a
    // la redirección.
    @GetMapping(value = "link/{linkId}", params = {"password"})
    public ResponseEntity<?> redireccionarlink(@PathVariable Long linkId ,@RequestParam ("password") String password){
        Optional<LinkDTO> link = service.redireccion(linkId,password);

        //redireccionar url
        String url = link.get().getLink(); // Obtén la URL del DTO

        // Verifica que la URL sea válida antes de redirigir
        if (url != null && !url.isEmpty()) {
            // Realiza la redirección utilizando un ResponseEntity
            return ResponseEntity.status(302) // Código 302 (Found)
                    .header("Location", url) // Especifica la URL destino
                    .build();
        }


        // En caso de que el link no exista o no sea válido
        return ResponseEntity.status(404).body("El enlace no existe");

    }

}
