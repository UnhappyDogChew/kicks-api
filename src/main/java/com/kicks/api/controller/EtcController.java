package com.kicks.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/etc")
@RequiredArgsConstructor
public class EtcController {

    @GetMapping("/alive")
    public String alive() {
        return "I'm alive 😎";
    }
}
