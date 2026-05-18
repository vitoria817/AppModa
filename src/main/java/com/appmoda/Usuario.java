package com.appmoda;

import javax.persistence.*;

/* entidade que representa o usuário no banco de dados */
@Entity
@Table(name = "usuarios")
public class Usuario {

    /* id gerado automaticamente */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /* nome vindo do Google */
    private String nome;

    /* email vindo do Google (único por usuário) */
    @Column(unique = true)
    private String email;

    /* foto de perfil vinda do Google */
    private String fotoPerfil;

    /* id do Google (sub) */
    private String googleId;

    /* construtores */
    public Usuario() {}

    public Usuario(String nome, String email, String fotoPerfil, String googleId) {
        this.nome = nome;
        this.email = email;
        this.fotoPerfil = fotoPerfil;
        this.googleId = googleId;
    }

    /* getters e setters */
    public Long getId() { return id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getFotoPerfil() { return fotoPerfil; }
    public void setFotoPerfil(String fotoPerfil) { this.fotoPerfil = fotoPerfil; }

    public String getGoogleId() { return googleId; }
    public void setGoogleId(String googleId) { this.googleId = googleId; }
}