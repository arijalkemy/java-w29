package com.example.linktracker.service;

import com.example.linktracker.dto.request.LinkDtoIn;
import com.example.linktracker.dto.response.LinkAllDtoOut;
import com.example.linktracker.dto.response.LinkDtoOut;
import com.example.linktracker.dto.response.LinkMetricsDto;
import com.example.linktracker.entity.Link;
import com.example.linktracker.exception.ConflictException;
import com.example.linktracker.exception.InvalidLinkException;
import com.example.linktracker.exception.NotFoundException;
import com.example.linktracker.repository.ILinkRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LinkServiceImpl implements ILinkService{

    private final ILinkRepository iLinkRepository;

    @Override
    public String redirectLinkById(Integer linkId, String password) {
        Optional<Link> link = this.iLinkRepository.findById(linkId);
        if (link.isEmpty()) {
            throw new NotFoundException("No se ha encontrado el link con el ID proporcionado.");
        }
        if(!link.get().getPassword().equals(password)){
            throw new ConflictException("La contraseña es incorrecta");
        }

        String url = link.get().getUrl();

        // Validar la URL
        if (!isValidUrl(url)) {
            this.updateValidUrl(linkId, false);
            throw new NotFoundException("La URL no es válida o no es accesible.");
        }

        return url;
    }

    private boolean isValidUrl(String url) {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("HEAD");
            connection.setConnectTimeout(3000); // Tiempo de espera para conexión
            connection.setReadTimeout(3000);   // Tiempo de espera para lectura
            int responseCode = connection.getResponseCode();
            return responseCode >= 200 && responseCode < 400; // Respuestas válidas (2xx o 3xx)
        } catch (IOException e) {
            return false; // URL no válida o inaccesible
        }
    }


    @Override
    public LinkDtoOut addLink(LinkDtoIn linkDtoIn) {
        if(this.iLinkRepository.findByUrl(linkDtoIn.getUrl()).isPresent()){
            throw new ConflictException("Esa url ya se encuentra registrada.");
        }
        try {
            new URL(linkDtoIn.getUrl());
        } catch (MalformedURLException e){
            throw new InvalidLinkException("Esa url no es válida.");
        }
        Integer id = this.iLinkRepository.findAll().get().size() + 1;
        Link link = new Link(id, linkDtoIn.getUrl(), linkDtoIn.getPassword());

        return new LinkDtoOut(this.iLinkRepository.saveUrl(link).get());
    }

    @Override
    public Boolean updateVisitCounter(Integer linkId) {
        Optional<Link> link = this.iLinkRepository.findById(linkId);
        if (link.isEmpty()){
            throw new NotFoundException("No existe registro");
        }
        Link linkupdate = link.get();
        Integer visit = linkupdate.getVisitCounter();
        linkupdate.setVisitCounter(++visit);
        return this.iLinkRepository.updateVisitCounter(linkupdate);
    }

    @Override
    public Boolean updateValidUrl(Integer linkId, boolean b) {
        Optional<Link> link = this.iLinkRepository.findById(linkId);
        if (link.isEmpty()){
            throw new NotFoundException("No existe registro");
        }
        Link linkupdate = link.get();
        linkupdate.setValid(b);
        return this.iLinkRepository.updateValid(linkupdate);
    }

    @Override
    public List<LinkAllDtoOut> searchAll() {
        ObjectMapper mapper = new ObjectMapper();
        return this.iLinkRepository.findAll().get().stream()
                .map(v -> mapper.convertValue(v, LinkAllDtoOut.class))
                .toList();
    }

    @Override
    public LinkMetricsDto getMetrics(Integer linkId) {
        Integer redirectionsTotal = this.iLinkRepository.findAll().get().stream().mapToInt(Link::getVisitCounter).sum();
        Optional<Link> link = this.iLinkRepository.findById(linkId);
        if (link.isEmpty()){
            throw new NotFoundException("No existe registro");
        }
        Integer redirections = link.get().getVisitCounter();
        Double porcentaje = 0.0;
        if(redirections != 0){
            porcentaje =  ((double)redirections / redirectionsTotal) * 100;
        }
        return new LinkMetricsDto(link.get().getUrl(), link.get().getVisitCounter(), redirectionsTotal, porcentaje);
    }

    @Override
    public Boolean invalidateById(Integer linkId) {
        Optional<Link> link = this.iLinkRepository.findById(linkId);
        if (link.isPresent()){
            link.get().setValid(false);
            return this.iLinkRepository.updateValid(link.get());
        }
        throw new NotFoundException("No existe registro");
    }


}
