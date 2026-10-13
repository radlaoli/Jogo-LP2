package com.LP2.Aventura_Solo.model;

public final class MissaoIndisponivelException extends Exception {
    public MissaoIndisponivelException(String mensagem) {
        super(mensagem);
    }
}