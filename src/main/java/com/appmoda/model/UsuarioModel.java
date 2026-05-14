package com.appmoda.model;

import javax.persistence.*;

// Representa a tabela "usuarios" no banco de dados
@Entity
@Table(name = "usuarios")
public class UsuarioModel {

    // Coluna ID — gerada automaticamente pelo banco
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Coluna email — armazena o email do usuário
    private String email;

    // Retorna o ID do usuário
    public Long getId() { return id; }

    // Define o ID do usuário
    public void setId(Long id) { this.id = id; }

    // Retorna o email do usuário
    public String getEmail() { return email; }

    // Define o email do usuário
    public void setEmail(String email) { this.email = email; }
}