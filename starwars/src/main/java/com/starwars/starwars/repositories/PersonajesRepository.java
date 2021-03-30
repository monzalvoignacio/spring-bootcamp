package com.starwars.starwars.repositories;

import com.starwars.starwars.dto.PersonajeDTO;
import com.starwars.starwars.dto.PersonajesDTO;

public interface PersonajesRepository {
    public PersonajesDTO findByKeyword(String keyword);
}
