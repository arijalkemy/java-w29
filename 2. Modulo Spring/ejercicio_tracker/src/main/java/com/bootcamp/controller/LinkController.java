package com.bootcamp.controller;

import com.bootcamp.dto.LinkDto;
import com.bootcamp.service.ILinkService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/link")
public class LinkController {

    @Autowired
    private ILinkService linkService;

    @PostMapping("/add")
    public LinkDto add(@RequestBody LinkDto link) {
        return linkService.add(link);
    }

    @GetMapping("/{id}")
    public void redirect(@PathVariable Integer id, HttpServletResponse response) throws IOException {
        LinkDto link = linkService.redirect(id);
        if (link != null)
            response.sendRedirect(link.getLink());
        response.sendError(404);
    }

    @GetMapping(value = "/{id}", params = {"password"})
    public void redirect(@PathVariable Integer id, @RequestParam("password") String password, HttpServletResponse response) throws IOException {
        LinkDto link = linkService.redirect(id, password);
        if (link != null)
            response.sendRedirect(link.getLink());
        response.sendError(404);
    }

    @GetMapping("/metrics/{id}")
    public LinkDto metrics(@PathVariable Integer id) throws IOException {
        return linkService.metrics(id);
    }

    @PostMapping("/invalidate/{id}")
    public void invalidate(@PathVariable Integer id) throws IOException {
        linkService.invalidate(id);
    }

}
