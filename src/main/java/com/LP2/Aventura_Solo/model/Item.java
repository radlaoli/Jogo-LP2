package com.LP2.Aventura_Solo.model;

import java.util.Objects;

import lombok.Getter;

@Getter 
public abstract class Item {
    private final String nome;
    private final Raridade raridade;
    private final int valor;

    public enum Raridade {
        COMUM, RARO, SUPER_RARO, EPICO, LENDARIO
    }

    protected Item(String nome, Raridade raridade, int valor) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome do item não pode ser vazio.");
        }
        if (raridade == null || valor < 0) {
            throw new IllegalArgumentException("Dados do item inválidos.");
        }
        this.nome = nome;
        this.raridade = raridade;
        this.valor = valor;
    }

    public abstract String descricaoDetalhada();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item outro = (Item) o;
        return this.valor == outro.valor
            && this.nome.equals(outro.nome)
            && this.raridade == outro.raridade;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, raridade, valor);
    }
}