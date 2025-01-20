package com.meli.scaffolding.controller;

import com.meli.scaffolding.dto.LinkDTO;
import com.meli.scaffolding.service.ILinkService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class LinkController {
  private final ILinkService linkService;

  @PostMapping("create")
  public LinkDTO create(@RequestBody LinkDTO link) {
    return linkService.create(link);
  }

  @GetMapping("link/{linkId}")
  public void redirect(@PathVariable Integer linkId, HttpServletResponse response) throws IOException {
    LinkDTO link = linkService.redirect(linkId);
    if (link != null){
      response.sendRedirect(link.getLink());
    } else {
      response.sendError(404);
    }
  }

  @GetMapping(value = "link/{linkId}", params = {"password"})
  public void redirect(@PathVariable Integer linkId, @RequestParam("password") String password, HttpServletResponse response) throws IOException {
    LinkDTO link = linkService.redirect(linkId, password);
    if (link != null){
      response.sendRedirect(link.getLink());
    } else {
      response.sendError(404);
    }
  }

  @GetMapping("metrics/{linkId}")
  public LinkDTO metrics(@PathVariable Integer linkId) throws IOException {
    return linkService.metrics(linkId);
  }

  @PostMapping("invalidate/{linkId}")
  public void invalidate(@PathVariable Integer linkId) throws IOException {
    linkService.invalidate(linkId);
  }
}
