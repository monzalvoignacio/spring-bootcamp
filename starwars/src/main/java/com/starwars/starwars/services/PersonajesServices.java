package com.starwars.starwars.services;

import com.starwars.starwars.dto.PersonajeDTO;
import com.starwars.starwars.dto.PersonajesDTO;

public interface PersonajesServices {
    public PersonajesDTO findByKeyword(String keyword);

}
