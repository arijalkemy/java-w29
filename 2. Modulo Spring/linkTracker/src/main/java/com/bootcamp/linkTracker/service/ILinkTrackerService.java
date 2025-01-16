package com.bootcamp.linkTracker.service;

import com.bootcamp.linkTracker.dto.IdDTO;
import com.bootcamp.linkTracker.dto.LinkDTO;
import com.bootcamp.linkTracker.dto.MetricDTO;

public interface ILinkTrackerService {

    IdDTO createLink(LinkDTO request);
    LinkDTO getLinkToRedirectById(Integer id, String password);
    MetricDTO getMetricsById(Integer id);
    void invalidateLinkById(Integer id);
}
