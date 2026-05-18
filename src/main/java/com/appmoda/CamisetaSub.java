package com.appmoda;

import javax.persistence.*;

/* subclasse que representa uma camiseta */
@Entity
@Table(name = "camisetas")
public class CamisetaSub extends AbstrataGuardaRoupa {

    /* manga: curta, longa, sem manga */
    private String manga;

    /* descreve a camiseta (polimorfismo: cada roupa descreve a si mesma) */
    @Override
    public String descricao() {
        return "Camiseta de manga " + getManga() + " na cor " + getCor();
    }

    public String getManga() { return manga; }
    public void setManga(String manga) { this.manga = manga; }
}