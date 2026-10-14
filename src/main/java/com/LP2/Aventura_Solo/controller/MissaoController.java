package com.LP2.Aventura_Solo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.LP2.Aventura_Solo.model.Aventureiro;
import com.LP2.Aventura_Solo.model.Item;
import com.LP2.Aventura_Solo.model.Missao;
import com.LP2.Aventura_Solo.service.AventureiroService;
import com.LP2.Aventura_Solo.service.MissaoService;

import lombok.RequiredArgsConstructor;



@RestController 
@RequestMapping("/missao")
@RequiredArgsConstructor

public class MissaoController{
    private final MissaoService missaoService;
    private final AventureiroService aventureiroService;
    
    @PostMapping("/pocao")
    public Missao criarComPocao(
            @RequestParam String titulo,
            @RequestParam String descricaoRecompensa,
            @RequestParam int energiaRecompensa,
            @RequestParam String nomeItem,
            @RequestParam Item.Raridade raridade,
            @RequestParam int valorItem,
            @RequestParam int energiaRecuperada
    ) {
        return missaoService.criarComPocao(
                titulo, descricaoRecompensa, energiaRecompensa,
                nomeItem, raridade, valorItem, energiaRecuperada
        );
    }

    @PostMapping("/aceitar/{titulo}")
    public Aventureiro aceitar(@PathVariable String titulo) throws Exception {
        Missao missao = missaoService.buscar(titulo);
        return aventureiroService.aceitarMissao(missao);
    }

    @GetMapping
    public List<Missao> listar() {
        return missaoService.listar();
    }
}
