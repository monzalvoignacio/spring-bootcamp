package com.starwars.starwars.controllers;

import com.starwars.starwars.dto.PersonajeDTO;
import com.starwars.starwars.services.PersonajesServices;
import com.starwars.starwars.services.PersonajesServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonajesController {
    @Autowired
    private PersonajesServicesImpl personajesServices;

    @GetMapping("/personajes")
    public PersonajeDTO buscarPersonaje(@RequestParam String keyword) {
        PersonajeDTO byKeyword = personajesServices.findByKeyword(keyword);
        return byKeyword;
    }
}
