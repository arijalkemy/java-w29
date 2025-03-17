package com.example.movies.service;

import com.example.movies.dto.response.SerieDto;

import java.util.List;

public interface ISerieService {
    List<SerieDto> searchSerieByNumberOfSeasons(Integer num);
}
