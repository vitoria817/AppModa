package com.appmoda.repository;

// Acessa o banco de dados
// Salvar, buscar, deletar — tudo automático pelo JpaRepository
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.appmoda.model.UsuarioModel;

// Interface que faz o CRUD do usuário automaticamente
@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

    // Busca usuário pelo email no banco
    UsuarioModel findByEmail(String email);
}