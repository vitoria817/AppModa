package com.appmoda.repository;

import com.appmoda.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/* repositório que faz as operações no banco para usuários */
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

    /* busca usuário pelo email */
    Optional<UsuarioModel> findByEmail(String email);
}