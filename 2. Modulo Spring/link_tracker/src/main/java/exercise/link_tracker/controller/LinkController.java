package exercise.link_tracker.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
public class LinkController {

    @GetMapping("/link")
    public ResponseEntity<Void> createLink(){
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create("https://www.google.com"));

        return new ResponseEntity<>(headers, HttpStatus.FOUND);
    }
}
