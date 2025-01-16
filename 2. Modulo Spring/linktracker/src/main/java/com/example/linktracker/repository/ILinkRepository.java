package com.example.linktracker.repository;

import com.example.linktracker.entity.Link;

import javax.swing.*;
import javax.swing.text.StyledEditorKit;
import java.util.List;
import java.util.Optional;

public interface ILinkRepository {
    List<Link> findAll();
    Link saveLink(Link link);
    Optional<Link> findLinkById(Integer id);
    void invalidateLink(Link linkToInvalidate);
}
