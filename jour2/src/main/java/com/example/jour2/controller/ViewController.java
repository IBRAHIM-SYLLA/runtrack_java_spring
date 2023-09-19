package com.example.jour2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class ViewController {
    @GetMapping("/view")
    public String view(Model model){
        List<Map<String, Object>> animes = new ArrayList<>();
        animes.add(createAnime("Naruto", 700));
        animes.add(createAnime("One Piece", 1080));
        animes.add(createAnime("Hunter X Hunter", 100));

        model.addAttribute("animes", animes);
        return "view";
    }

    private Map<String, Object> createAnime(String nom, Integer nombreEpisode) {
        Map<String, Object> anime = new HashMap<>();
        anime.put("nom", nom);
        anime.put("nombreEpisode", nombreEpisode);

        return anime;
    }

    @PostMapping("/bienvenue")
    public String form(@RequestParam("nom") String nom, @RequestParam("prenom") String prenom, Model model){
        String message = "Bienvenue " + nom + " " + prenom;
        model.addAttribute("message", message);
        return "bienvenue";
    }
}
