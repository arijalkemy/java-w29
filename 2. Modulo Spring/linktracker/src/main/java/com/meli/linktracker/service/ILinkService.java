package com.meli.linktracker.service;

import com.meli.linktracker.dto.response.LinkDto;
import com.meli.linktracker.dto.response.LinkMetricsDto;

public interface ILinkService {
    LinkDto crearLink(com.meli.linktracker.dto.request.LinkDto link, String password);
    String redireccionar(Integer linkId);
    LinkMetricsDto obtenerMetricas(Integer linkId);
    void invalidar(Integer linkId);
}
