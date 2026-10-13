package com.LP2.Aventura_Solo.service;

import org.springframework.stereotype.Service;

import com.LP2.Aventura_Solo.model.Aventureiro;
import com.LP2.Aventura_Solo.model.ItemNaoEncontradoException;
import com.LP2.Aventura_Solo.model.Missao;
import com.LP2.Aventura_Solo.model.MissaoIndisponivelException;

@Service
public class AventureiroService {

    private Aventureiro aventureiro = new Aventureiro("Kael", Aventureiro.ENERGIA_MAXIMA);

    public Aventureiro buscarAventureiro() {
        return aventureiro;
    }

    public Aventureiro criar(String nome) {
        this.aventureiro = new Aventureiro(nome, Aventureiro.ENERGIA_MAXIMA);
        return aventureiro;
    }

    public Aventureiro sofrerDano(int dano) {
        aventureiro.sofrerDano(dano);
        return aventureiro;
    }

    public Aventureiro descansar(int quantidade) {
        aventureiro.recuperarEnergia(quantidade);
        return aventureiro;
    }

    public Aventureiro aceitarMissao(Missao missao) throws MissaoIndisponivelException {
        aventureiro.aceitarMissao(missao);
        return aventureiro;
    }

    public Aventureiro concluirMissaoAtiva() throws MissaoIndisponivelException {
        aventureiro.concluirMissaoAtiva();
        return aventureiro;
    }

    public Aventureiro usarItem(String nomeItem) throws ItemNaoEncontradoException {
        aventureiro.usarItem(nomeItem);
        return aventureiro;
    }
}