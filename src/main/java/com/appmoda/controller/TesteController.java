package com.appmoda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TesteController {

    @GetMapping("/")
    public String mensagem() {
        return "index"; // chama index.html
    }
}