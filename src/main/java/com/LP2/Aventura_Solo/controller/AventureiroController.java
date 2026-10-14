package com.LP2.Aventura_Solo.controller;

import java.util.List;

import com.LP2.Aventura_Solo.model.Aventureiro;
import com.LP2.Aventura_Solo.service.AventureiroService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.LP2.Aventura_Solo.model.Item;

@RestController
@RequestMapping("/aventureiro")
@RequiredArgsConstructor
public class AventureiroController {

    private final AventureiroService aventureiroService;

    @GetMapping
    public Aventureiro buscarAventureiro() {
        return aventureiroService.buscarAventureiro();
    }

    @PostMapping("/{nome}")
    public Aventureiro criar(@PathVariable String nome) {
        return aventureiroService.criar(nome);
    }

    @PostMapping("/dano/{dano}")
    public Aventureiro sofrerDano(@PathVariable int dano) {
        return aventureiroService.sofrerDano(dano);
    }

    @PostMapping("/descansar/{quantidade}")
    public Aventureiro descansar(@PathVariable int quantidade) {
        return aventureiroService.descansar(quantidade);
    }

    @PostMapping("/usar-item/{nomeItem}")
    public Aventureiro usarItem(@PathVariable String nomeItem) throws Exception {
        return aventureiroService.usarItem(nomeItem);
    }

    @PostMapping("/concluir-missao")
    public Aventureiro concluirMissaoAtiva() throws Exception {
        return aventureiroService.concluirMissaoAtiva();
    }

    @GetMapping("/inventario")
        public List<Item> listarItensInventario() {
    return aventureiroService.listarItensInventario();
}
}