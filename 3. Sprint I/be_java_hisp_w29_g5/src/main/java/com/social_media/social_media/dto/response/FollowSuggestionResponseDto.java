package com.social_media.social_media.dto.response;

import com.fasterxml.jackson.annotation.JsonGetter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FollowSuggestionResponseDto {
    private Long user_id;
    private String user_name;
    private List<String> brandsSold;

    @JsonGetter("brandsSold")
    public String getFormattedBrandsSold() {
        return String.join(", ", brandsSold);
    }
}
