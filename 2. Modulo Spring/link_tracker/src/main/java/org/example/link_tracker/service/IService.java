package org.example.link_tracker.service;

import org.example.link_tracker.dto.RequestLinkDTO;
import org.example.link_tracker.dto.ResponseLinkDTO;
import org.example.link_tracker.entity.Link;

public interface IService {
    ResponseLinkDTO addLink(RequestLinkDTO link);
    ResponseLinkDTO redirect(int linkId, int password);
    String getMetrics(int linkId);
    void invalidateLink(int linkID);
    void validatePassword(Link link, int password);
}
