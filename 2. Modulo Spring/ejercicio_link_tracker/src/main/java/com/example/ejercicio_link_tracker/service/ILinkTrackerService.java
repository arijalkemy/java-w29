package com.example.ejercicio_link_tracker.service;

import com.example.ejercicio_link_tracker.dto.*;

public interface ILinkTrackerService {
    ResponseLinkDTO createLink(RequestLinkDTO newUrl);
    String getById(Integer id);
}
