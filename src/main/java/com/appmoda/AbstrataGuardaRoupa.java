package com.appmoda;

import com.appmoda.model.UsuarioModel;

import javax.persistence.*;

/* classe abstrata que representa qualquer peça de roupa */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "roupas")
public abstract class AbstrataGuardaRoupa {

    /* id gerado automaticamente */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /* nome da peça ex: "Camiseta branca" */
    private String nome;

    /* cor da peça */
    private String cor;

    /* temperatura mínima que essa roupa é adequada */
    private Integer tempMin;

    /* temperatura máxima que essa roupa é adequada */
    private Integer tempMax;

    /* usuário dono desta roupa */
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UsuarioModel usuario;

    /* método abstrato: cada subclasse descreve a si mesma de forma diferente (polimorfismo) */
    public abstract String descricao();

    /* getters e setters */
    public Long getId() { return id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCor() { return cor; }
    public void setCor(String cor) { this.cor = cor; }

    public Integer getTempMin() { return tempMin; }
    public void setTempMin(Integer tempMin) { this.tempMin = tempMin; }

    public Integer getTempMax() { return tempMax; }
    public void setTempMax(Integer tempMax) { this.tempMax = tempMax; }

    public UsuarioModel getUsuario() { return usuario; }
    public void setUsuario(UsuarioModel usuario) { this.usuario = usuario; }
}