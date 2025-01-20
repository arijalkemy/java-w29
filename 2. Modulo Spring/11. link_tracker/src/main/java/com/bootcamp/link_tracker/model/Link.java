package com.bootcamp.link_tracker.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Link {
    private Integer linkId;
    private String link;
    private Integer timesUsed;
    private String password;
}
