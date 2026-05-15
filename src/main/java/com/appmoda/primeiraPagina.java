package com.appmoda;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class primeiraPagina {

    @GetMapping("/temperatura")
    public String temperatura() {
        return "temperatura";
    }
}