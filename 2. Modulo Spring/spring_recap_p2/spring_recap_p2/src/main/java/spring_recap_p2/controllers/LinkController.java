package spring_recap_p2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import spring_recap_p2.dtos.createLinkDTO.RequestDTOCreateLink;
import spring_recap_p2.services.ILinkService;

@RestController
public class LinkController {
  @Autowired
  private ILinkService link_service;
  
  @PostMapping("/link")
  ResponseEntity<?> createLink(@RequestBody RequestDTOCreateLink request_dto){
    return new ResponseEntity<>(link_service.createLink(request_dto), HttpStatus.OK);
  }

  @GetMapping("/link/{link_id}")
  ResponseEntity<?> redirect(
    @PathVariable String link_id,
    @RequestParam(required = false) String password
  ){
    return ResponseEntity.status(HttpStatus.PERMANENT_REDIRECT)
      .location(link_service.redirect(link_id, password))
      .build();
  }

  @GetMapping("/metrics/{link_id}")
  ResponseEntity<?> linkMetrics(@PathVariable String link_id){
    return ResponseEntity.ok(link_service.linkMetrics(link_id));
  }

  @PostMapping("/invalidate/{link_id}")
  ResponseEntity<?> invalidateLink(@PathVariable String link_id){
    return ResponseEntity.ok(link_service.deleteLink(link_id));
  }
}
