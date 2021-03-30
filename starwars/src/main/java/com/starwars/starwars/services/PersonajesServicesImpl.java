package com.starwars.starwars.services;

import com.starwars.starwars.dto.PersonajeDTO;
import com.starwars.starwars.repositories.PersonajesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonajesServicesImpl implements PersonajesServices {
    @Autowired
    private PersonajesRepository personajesRepository;

    @Override
    public PersonajeDTO findByKeyword(String keyword) {
        return personajesRepository.findByKeyword(keyword);
    }
}
