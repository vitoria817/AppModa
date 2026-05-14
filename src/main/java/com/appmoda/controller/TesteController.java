package com.appmoda.controller;

import com.appmoda.model.UsuarioModel;
import com.appmoda.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class TesteController {

    // Injeta o repository para acessar o banco
    @Autowired
    private UsuarioRepository usuarioRepository;

    // Abre a página inicial
    @GetMapping("/")
    public String mensagem() {
        return "index"; // chama index.html
    }

    // Salva um email no banco
    @PostMapping("/salvar")
    public String salvar(@RequestParam String email) {
        UsuarioModel usuario = new UsuarioModel();
        usuario.setEmail(email);
        usuarioRepository.save(usuario);
        return "redirect:/"; // volta pra home
    }

    // Deleta um usuario pelo ID
    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        usuarioRepository.deleteById(id);
        return "redirect:/"; // volta pra home
    }
}