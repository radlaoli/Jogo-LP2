package com.LP2.Aventura_Solo.model;

public final class Missao {

    public enum EstadoMissao {
        DISPONIVEL, EM_ANDAMENTO, CONCLUIDA
    }

    private final String titulo;
    private final Recompensa recompensa;
    private EstadoMissao estado;

    public Missao(String titulo, Recompensa recompensa) {
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("Título da missão não pode ser vazio.");
        }
        if (recompensa == null) {
            throw new IllegalArgumentException("A missão exige uma recompensa válida.");
        }
        this.titulo = titulo;
        this.recompensa = recompensa;
        this.estado = EstadoMissao.DISPONIVEL;
    }

    public String getTitulo() { return titulo; }
    public EstadoMissao getEstado() { return estado; }

    public void iniciar() throws MissaoIndisponivelException {
        if (this.estado != EstadoMissao.DISPONIVEL) {
            throw new MissaoIndisponivelException("A missão \"" + titulo + "\" não está disponível.");
        }
        this.estado = EstadoMissao.EM_ANDAMENTO;
    }

    public Recompensa concluir() throws MissaoIndisponivelException {
        if (this.estado != EstadoMissao.EM_ANDAMENTO) {
            throw new MissaoIndisponivelException("A missão \"" + titulo + "\" não está em andamento.");
        }
        this.estado = EstadoMissao.CONCLUIDA;
        return this.recompensa;
    }
}