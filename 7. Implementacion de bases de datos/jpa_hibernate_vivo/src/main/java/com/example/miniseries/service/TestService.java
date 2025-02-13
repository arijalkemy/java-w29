package com.example.miniseries.service;

import com.example.miniseries.model.MiniSerie;
import com.example.miniseries.repository.IMiniSerieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    private final IMiniSerieRepository miniSerieRepository;

    public TestService(IMiniSerieRepository miniSerieRepository) {
        this.miniSerieRepository = miniSerieRepository;
        test();
    }

    public void test() {
        miniSerieRepository.save(MiniSerie.builder().
                name("Breaking Bad")
                .amount_of_awards(10)
                .build()
        );
    }
}
