package com.LP2.Aventura_Solo.controller;

import com.LP2.Aventura_Solo.model.Aventureiro;
import com.LP2.Aventura_Solo.service.AventureiroService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aventureiro")
@RequiredArgsConstructor
public class AventureiroController {

    private final AventureiroService aventureiroService;

    @GetMapping
    public Aventureiro buscarAventureiro() {
        return aventureiroService.buscarAventureiro();
    }

    @PostMapping("/dano/{dano}")
    public Aventureiro sofrerDano(@PathVariable int dano) {
        return aventureiroService.sofrerDano(dano);
    }

    @PostMapping("/descansar/{quantidade}")
    public Aventureiro descansar(@PathVariable int quantidade) {
        return aventureiroService.descansar(quantidade);
    }
}