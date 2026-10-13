package com.LP2.Aventura_Solo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
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

    public void recuperarEnergia(int quantidade) {
        this.energia = Math.min(ENERGIA_MAXIMA, this.energia + quantidade);
    }

    public void sofrerDano(int dano) {
        this.energia = Math.max(0, this.energia - dano);
    }

    public void aceitarMissao(Missao missao) throws MissaoIndisponivelException {
        missao.iniciar();
        this.missaoAtiva = missao;
    }

    public Recompensa concluirMissaoAtiva() throws MissaoIndisponivelException {
        if (this.missaoAtiva == null) {
            throw new IllegalStateException("O aventureiro não possui nenhuma missão ativa.");
        }
        Recompensa recompensa = this.missaoAtiva.concluir();
        recuperarEnergia(recompensa.getEnergia());
        if (recompensa.getItem() != null) {
            this.inventario.adicionar(recompensa.getItem());
        }
        this.missaoAtiva = null;
        return recompensa;
    }

    public void usarItem(String nomeItem) throws ItemNaoEncontradoException {
        Item item = this.inventario.buscarPorNome(nomeItem);
        if (!(item instanceof Usavel)) {
            throw new IllegalStateException("O item \"" + nomeItem + "\" não pode ser usado.");
        }
        Usavel usavel = (Usavel) item;
        usavel.usar(this);
        if (item instanceof Pocao) {
            this.inventario.remover(item);
        }
    }
}