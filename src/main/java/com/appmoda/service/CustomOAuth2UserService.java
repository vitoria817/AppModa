package com.appmoda.service;

import com.appmoda.model.UsuarioModel;
import com.appmoda.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Optional;

/* serviço que roda quando o usuário faz login com o Google */
@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    /* injeta o repositório de usuários */
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) {

        /* carrega os dados do Google */
        OAuth2User oAuth2User = super.loadUser(userRequest);

        /* pega os dados vindos do Google */
        String nome = oAuth2User.getAttribute("name");
        String email = oAuth2User.getAttribute("email");
        String foto = oAuth2User.getAttribute("picture");

        /* verifica se o usuário já existe no banco pelo email */
        Optional<UsuarioModel> usuarioExistente = usuarioRepository.findByEmail(email);

        if (usuarioExistente.isPresent()) {
            /* usuário já existe: atualiza os dados */
            UsuarioModel usuario = usuarioExistente.get();
            usuario.setNome(nome);
            usuario.setFoto(foto);
            usuarioRepository.save(usuario);
        } else {
            /* usuário novo: salva no banco pela primeira vez */
            UsuarioModel novoUsuario = new UsuarioModel();
            novoUsuario.setNome(nome);
            novoUsuario.setEmail(email);
            novoUsuario.setFoto(foto);
            novoUsuario.setProvider("google");
            usuarioRepository.save(novoUsuario);
        }

        return oAuth2User;
    }
}