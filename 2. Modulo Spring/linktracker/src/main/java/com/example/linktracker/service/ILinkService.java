package com.example.linktracker.service;


import com.example.linktracker.dto.response.LinkDto;
import com.example.linktracker.dto.response.LinkMetricsDto;

public interface ILinkService {
    LinkDto crearLink(com.example.linktracker.dto.request.LinkDto link, String password);
    String redireccionar(Integer linkId);
    LinkMetricsDto obtenerMetricas(Integer linkId);
    void invalidar(Integer linkId);
}
