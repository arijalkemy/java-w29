package com.thiagoschreck.local.link_tracker.service;

import com.thiagoschreck.local.link_tracker.dto.request.NewLinkRequestDTO;
import com.thiagoschreck.local.link_tracker.dto.response.LinkMetricsResponseDTO;
import com.thiagoschreck.local.link_tracker.dto.response.NewLinkResponseDTO;
import org.springframework.http.HttpHeaders;


public interface ILinkTrackerService {
    NewLinkResponseDTO addLink(NewLinkRequestDTO newLink);

    HttpHeaders redirectTo(int linkId, String password);

    LinkMetricsResponseDTO getMetrics(Integer linkId);

    Void invalidateLink(Integer linkId);
}
