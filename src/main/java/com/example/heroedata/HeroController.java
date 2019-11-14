package com.example.heroedata;

/*
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for
 * license information.
 */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

import java.util.Optional;


@RestController
public class HeroController {
    @Autowired
    private HeroRepository heroRepository;

    @PostMapping (path="/heroes")
    public @ResponseBody String createHeroes(@RequestBody Hero hero) {
        // Save the User class to Azure CosmosDB database.
        final Mono<Hero> saveHeroMono = heroRepository.save(hero);
        return String.format("Added %s.", hero);
    }

    @GetMapping (path="/heroes")
    public @ResponseBody Flux<Hero> getAllHeroes() {
        return heroRepository.findAll();
    }

    @GetMapping("/heroes/{id}")
    public @ResponseBody Mono<Hero> getHero(@PathVariable String id) {
        return heroRepository.findById(id);
    }

    @DeleteMapping("/heroes/{id}")
    public @ResponseBody String deleteHero(@PathVariable String id) {
        heroRepository.deleteById(id);
        return "Deleted " + id;
    }
}

