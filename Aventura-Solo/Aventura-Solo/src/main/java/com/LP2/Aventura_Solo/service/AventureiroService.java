package com.LP2.Aventura_Solo.service;

import org.springframework.stereotype.Service;
import com.LP2.Aventura_Solo.model.Aventureiro;

@Service
public class AventureiroService {

    public static final int ENERGIA_MAXIMA = 100;

    private final Aventureiro aventureiro = new Aventureiro("Kael", ENERGIA_MAXIMA);

    public Aventureiro buscarAventureiro() {
        return aventureiro;
    }

    public Aventureiro sofrerDano(int dano) {
        int novaEnergia = aventureiro.getEnergia() - dano;
        if (novaEnergia < 0) {
            novaEnergia = 0;
        }
        aventureiro.setEnergia(novaEnergia);
        return aventureiro;
    }

    public Aventureiro descansar(int quantidade) {
        int novaEnergia = aventureiro.getEnergia() + quantidade;
        if (novaEnergia > ENERGIA_MAXIMA) {
            novaEnergia = ENERGIA_MAXIMA;
        }
        aventureiro.setEnergia(novaEnergia);
        return aventureiro;
    }
}