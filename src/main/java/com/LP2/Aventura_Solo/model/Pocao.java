package com.LP2.Aventura_Solo.model;

public final class Pocao extends Item implements Usavel {
    private final int energiaRecuperada;

    public Pocao(String nome, Raridade raridade, int valor, int energiaRecuperada) {
        super(nome, raridade, valor);
        if (energiaRecuperada <= 0) {
            throw new IllegalArgumentException("A energia recuperada deve ser maior que zero.");
        }
        this.energiaRecuperada = energiaRecuperada;
    }

    @Override
    public void usar(Aventureiro aventureiro) {
        aventureiro.recuperarEnergia(energiaRecuperada);
        System.out.println(aventureiro.getNome() + " usou " + getNome() + " e recuperou " + energiaRecuperada + " de energia.");
    }

    @Override
    public String descricaoDetalhada() {
        return getNome() + " (Poção, +" + energiaRecuperada + " energia)";
    }
}