package com.appmoda;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class primeiraPagina {

    /* abre a tela principal (index) */
    @GetMapping("/")
    public String index(
            @AuthenticationPrincipal OAuth2User principal,
            Model model
    ) {
        /* se o usuário já está logado, passa o nome pra página */
        if (principal != null) {
            model.addAttribute("nomeUsuario", principal.getAttribute("name"));
            model.addAttribute("fotoUsuario", principal.getAttribute("picture"));
        }
        return "index";
    }

    /* abre a tela de temperatura */
    @GetMapping("/temperatura")
    public String temperatura() {
        return "temperatura";
    }
}