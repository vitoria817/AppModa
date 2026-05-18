package com.appmoda;

import com.appmoda.model.UsuarioModel;
import com.appmoda.repository.RoupaRepository;
import com.appmoda.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller /* controla as páginas */
public class segundaPagina {

    /* injeta repositório de roupas */
    @Autowired
    private RoupaRepository rouRepository;

    /* injeta repositório de usuários */
    @Autowired
    private UsuarioRepository usuarioRepository;

    /* abre o guarda-roupa do usuário logado */
    @GetMapping("/guarda-roupa")
    public String guardaRoupa(
            @AuthenticationPrincipal OAuth2User principal,
            Model model
    ) {
        if (principal != null) {
            /* pega o email do usuário logado */
            String email = principal.getAttribute("email");

            /* busca o usuário no banco */
            Optional<UsuarioModel> usuario = usuarioRepository.findByEmail(email);

            if (usuario.isPresent()) {
                /* passa as roupas do usuário para o HTML */
                List<AbstrataGuardaRoupa> roupas = rouRepository.findByUsuario(usuario.get());
                model.addAttribute("roupas", roupas);
                model.addAttribute("nomeUsuario", usuario.get().getNome());
                model.addAttribute("fotoUsuario", usuario.get().getFoto());
            }
        }
        /* abre o arquivo: guarda-roupa.html */
        return "guarda-roupa";
    }

    /* recebe a temperatura e sugere roupas */
    @GetMapping("/sugestao")
    public String sugestao(
            @RequestParam Integer temperatura,
            @AuthenticationPrincipal OAuth2User principal,
            Model model
    ) {
        model.addAttribute("temperatura", temperatura);

        if (principal != null) {
            String email = principal.getAttribute("email");
            Optional<UsuarioModel> usuario = usuarioRepository.findByEmail(email);

            if (usuario.isPresent()) {
                /* busca roupas adequadas para a temperatura */
                List<AbstrataGuardaRoupa> roupasSugeridas = rouRepository
                        .findByUsuarioAndTempMinLessThanEqualAndTempMaxGreaterThanEqual(
                                usuario.get(), temperatura, temperatura
                        );
                model.addAttribute("roupasSugeridas", roupasSugeridas);
                model.addAttribute("nomeUsuario", usuario.get().getNome());
            }
        }
        /* abre a tela de sugestão */
        return "sugestao";
    }

    /* salva uma roupa nova no guarda-roupa */
    @PostMapping("/guarda-roupa/adicionar")
    public String adicionarRoupa(
            @RequestParam String tipo,
            @RequestParam String nome,
            @RequestParam String cor,
            @RequestParam Integer tempMin,
            @RequestParam Integer tempMax,
            @RequestParam(required = false) String manga,
            @RequestParam(required = false) String tipocalca,
            @AuthenticationPrincipal OAuth2User principal
    ) {
        if (principal != null) {
            String email = principal.getAttribute("email");
            Optional<UsuarioModel> usuario = usuarioRepository.findByEmail(email);

            if (usuario.isPresent()) {
                if ("camiseta".equals(tipo)) {
                    /* cria e salva uma camiseta */
                    CamisetaSub camiseta = new CamisetaSub();
                    camiseta.setNome(nome);
                    camiseta.setCor(cor);
                    camiseta.setTempMin(tempMin);
                    camiseta.setTempMax(tempMax);
                    camiseta.setManga(manga);
                    camiseta.setUsuario(usuario.get());
                    rouRepository.save(camiseta);

                } else if ("calca".equals(tipo)) {
                    /* cria e salva uma calça */
                    CalçaSub calca = new CalçaSub();
                    calca.setNome(nome);
                    calca.setCor(cor);
                    calca.setTempMin(tempMin);
                    calca.setTempMax(tempMax);
                    calca.setTipo(tipocalca);
                    calca.setUsuario(usuario.get());
                    rouRepository.save(calca);
                }
            }
        }
        /* volta pro guarda-roupa após salvar */
        return "redirect:/guarda-roupa";
    }
}