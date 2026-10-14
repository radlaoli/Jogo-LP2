package com.LP2.Aventura_Solo.model;

import lombok.Getter;
@Getter 
public final class Arma extends Item {
    private final int dano;

    public Arma(String nome, Raridade raridade, int valor, int dano) {
        super(nome, raridade, valor);
        if (dano <= 0) {
            throw new IllegalArgumentException("O dano da arma deve ser maior que zero.");
        }
        this.dano = dano;
    }

    @Override
    public String descricaoDetalhada() {
        return getNome() + " (Arma, dano " + dano + ")";
    }
}