package com.LP2.Aventura_Solo.model;

import lombok.Getter;

@Getter 
public final class Equipamento extends Item {
    private final int defesa;

    public Equipamento(String nome, Raridade raridade, int valor, int defesa) {
        super(nome, raridade, valor);
        if (defesa <= 0) {
            throw new IllegalArgumentException("A defesa do equipamento deve ser maior que zero.");
        }
        this.defesa = defesa;
    }

    @Override
    public String descricaoDetalhada() {
        return getNome() + " (Equipamento, defesa " + defesa + ")";
    }
}