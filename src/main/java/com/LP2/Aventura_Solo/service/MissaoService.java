package com.LP2.Aventura_Solo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.LP2.Aventura_Solo.model.Item;
import com.LP2.Aventura_Solo.model.Missao;
import com.LP2.Aventura_Solo.model.MissaoIndisponivelException;
import com.LP2.Aventura_Solo.model.MissaoRepositorio;
import com.LP2.Aventura_Solo.model.Pocao;
import com.LP2.Aventura_Solo.model.Recompensa;

@Service
public class MissaoService {

    private final MissaoRepositorio repositorio = new MissaoRepositorio();

    public Missao criarComPocao(
            String titulo,
            String descricaoRecompensa,
            int energiaRecompensa,
            String nomeItem,
            Item.Raridade raridade,
            int valorItem,
            int energiaRecuperada
    ) {
        Pocao pocao = new Pocao(nomeItem, raridade, valorItem, energiaRecuperada);
        Recompensa recompensa = new Recompensa(descricaoRecompensa, energiaRecompensa, pocao);
        Missao missao = new Missao(titulo, recompensa);
        repositorio.salvar(missao);
        return missao;
    }

    public Missao buscar(String titulo) throws MissaoIndisponivelException {
        return repositorio.buscar(titulo);
    }

    public List<Missao> listar() {
        return repositorio.listar();
    }
}