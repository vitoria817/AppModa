package com.appmoda;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller // controla pagina
public class segundaPagina {
    @GetMapping("/guarda-roupa")
    // quando alguém acessar /temperatura
    public String guardaRoupa() {
        // função que roda quando acessa a rota
        return "guarda-roupa";
        // abre o arquivo: guarda roupa.html
    }
}








