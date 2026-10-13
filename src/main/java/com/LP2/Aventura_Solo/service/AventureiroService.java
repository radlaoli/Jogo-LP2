package com.LP2.Aventura_Solo.service;

import org.springframework.stereotype.Service;

import com.LP2.Aventura_Solo.model.Aventureiro;
import com.LP2.Aventura_Solo.model.Item;
import com.LP2.Aventura_Solo.model.ItemNaoEncontradoException;
import com.LP2.Aventura_Solo.model.Missao;
import com.LP2.Aventura_Solo.model.MissaoIndisponivelException;
/*import com.LP2.Aventura_Solo.model.Pocao;*/
import com.LP2.Aventura_Solo.model.Recompensa;
import com.LP2.Aventura_Solo.model.Usavel;

@Service
public class AventureiroService {

    public static final int ENERGIA_MAXIMA = Aventureiro.ENERGIA_MAXIMA;

    private Aventureiro aventureiro = new Aventureiro("Kael", ENERGIA_MAXIMA);

    public Aventureiro buscarAventureiro() {
        return aventureiro;
    }

    public Aventureiro criar(String nome) {
        this.aventureiro = new Aventureiro(nome, ENERGIA_MAXIMA);
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

    public Aventureiro aceitarMissao(Missao missao) throws MissaoIndisponivelException {
        missao.iniciar();
        aventureiro.setMissaoAtiva(missao);
        return aventureiro;
    }

    public Aventureiro concluirMissaoAtiva() throws MissaoIndisponivelException {
        Missao missaoAtiva = aventureiro.getMissaoAtiva();
        if (missaoAtiva == null) {
            throw new IllegalStateException("O aventureiro não possui nenhuma missão ativa.");
        }

        Recompensa recompensa = missaoAtiva.concluir();

        int novaEnergia = aventureiro.getEnergia() + recompensa.getEnergia();
        if (novaEnergia > ENERGIA_MAXIMA) {
            novaEnergia = ENERGIA_MAXIMA;
        }
        aventureiro.setEnergia(novaEnergia);

        Item item = recompensa.getItem();
        if (item != null) {
            aventureiro.getInventario().adicionar(item);
        }

        aventureiro.setMissaoAtiva(null);
        return aventureiro;
    }

    public Aventureiro usarItem(String nomeItem) throws ItemNaoEncontradoException {
        Item item = aventureiro.getInventario().buscarPorNome(nomeItem);

        if (!(item instanceof Usavel)) {
            throw new IllegalStateException("O item \"" + nomeItem + "\" não pode ser usado.");
        }

        Usavel usavel = (Usavel) item;
        usavel.usar(aventureiro);
        /*
        if (item instanceof Pocao) {
            aventureiro.getInventario().remover(item);
        }
        
        */
        return aventureiro;
    }
}