package com.mdaneri.springp2vivomorse.controller;

import com.mdaneri.springp2vivomorse.utils.MorseUtil;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MorseController {

    @GetMapping("/parse")
    public String parse(@RequestParam(value = "code") String code) {
        return MorseUtil.parse(code);
    }

}
