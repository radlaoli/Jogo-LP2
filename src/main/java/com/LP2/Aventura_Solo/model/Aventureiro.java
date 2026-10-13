package com.LP2.Aventura_Solo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Aventureiro {
    private String nome;
    private int energia;

    public Aventureiro(String nome, int energia) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome do aventureiro não pode ser vazio.");
        }
        if (energia < 0 || energia > 100) {
            throw new IllegalArgumentException("Energia deve estar entre 0 e 100.");
        }
        this.nome = nome;
        this.energia = energia;
    }
}