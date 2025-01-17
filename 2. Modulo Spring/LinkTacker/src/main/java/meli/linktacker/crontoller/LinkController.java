package meli.linktacker.crontoller;

import meli.linktacker.dto.LinkDto;
import meli.linktacker.entity.Link;
import meli.linktacker.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/link")
public class LinkController {

    @Autowired
    private ILinkService service;

    @PostMapping()
    public ResponseEntity<?> addLink(@RequestBody LinkDto linkDto){
        return new ResponseEntity<>("Link creado correctamente con id: " + service.addLink(linkDto), HttpStatus.CREATED);
    }

    @GetMapping("{linkId}")
    public RedirectView getLink(@PathVariable Integer linkId){
        String link = service.getLink(linkId);
        return new RedirectView(link);
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<Integer> getViews(@PathVariable Integer linkId){
        Integer views = service.getViews(linkId);
        return new ResponseEntity<>(0, HttpStatus.OK);
    }
    @DeleteMapping("{linkId}")
    public ResponseEntity<String> invalidateLink(@PathVariable Integer linkId){
        service.invalidateLink(linkId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
