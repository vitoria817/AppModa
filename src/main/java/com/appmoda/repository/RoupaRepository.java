package com.appmoda.repository;

import com.appmoda.AbstrataGuardaRoupa;
import com.appmoda.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/* repositório que faz operações no banco para roupas */
public interface RoupaRepository extends JpaRepository<AbstrataGuardaRoupa, Long> {

    /* busca todas as roupas de um usuário */
    List<AbstrataGuardaRoupa> findByUsuario(UsuarioModel usuario);

    /* busca roupas adequadas para a temperatura informada */
    List<AbstrataGuardaRoupa> findByUsuarioAndTempMinLessThanEqualAndTempMaxGreaterThanEqual(
            UsuarioModel usuario,
            Integer temperatura,
            Integer temperatura2
    );
}