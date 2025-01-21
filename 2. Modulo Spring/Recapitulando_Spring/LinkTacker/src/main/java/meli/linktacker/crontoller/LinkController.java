package meli.linktacker.crontoller;

import meli.linktacker.dto.LinkDto;
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

    @GetMapping("/{linkId}")
    public RedirectView getLink(@PathVariable Integer linkId, @RequestParam String password){
        String link = service.getLink(linkId, password);
        return new RedirectView(link);
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<?> metricsForLink(@PathVariable Integer linkId){
        return new ResponseEntity<>(service.metricsForLink(linkId),HttpStatus.OK);
    }

    @GetMapping("invalidate/{linkId}")
    public ResponseEntity<?> invalidateLink(@PathVariable Integer linkId){
        return new ResponseEntity<>(service.invalidateLink(linkId), HttpStatus.OK);
    }


    }
