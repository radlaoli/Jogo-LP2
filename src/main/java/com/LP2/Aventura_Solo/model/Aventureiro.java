package com.LP2.Aventura_Solo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Aventureiro {

    public static final int ENERGIA_MAXIMA = 100;

    private String nome;
    private int energia;
    private Inventario inventario;
    private Missao missaoAtiva;

    public Aventureiro(String nome, int energia, int capacidadeInventario) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome do aventureiro não pode ser vazio.");
        }
        if (energia < 0 || energia > ENERGIA_MAXIMA) {
            throw new IllegalArgumentException("Energia deve estar entre 0 e " + ENERGIA_MAXIMA + ".");
        }
        this.nome = nome;
        this.energia = energia;
        this.inventario = new Inventario(capacidadeInventario);
    }

    public Aventureiro(String nome, int energia) {
        this(nome, energia, 5);
    }
}