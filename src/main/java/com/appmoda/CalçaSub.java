package com.appmoda;

import javax.persistence.*;

/* subclasse que representa uma calça */
@Entity
@Table(name = "calcas")
public class CalçaSub extends AbstrataGuardaRoupa {

    /* tipo de calça: jeans, moletom, social, etc */
    private String tipo;

    /* descreve a calça (polimorfismo: cada roupa descreve a si mesma) */
    @Override
    public String descricao() {
        return "Calça " + getTipo() + " na cor " + getCor();
    }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
}