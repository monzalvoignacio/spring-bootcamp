package com.starwars.starwars.services;

import com.starwars.starwars.dto.PersonajeDTO;

public interface PersonajesServices {
    public PersonajeDTO findByKeyword(String keyword);

}
