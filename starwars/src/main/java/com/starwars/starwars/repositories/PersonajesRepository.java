package com.starwars.starwars.repositories;

import com.starwars.starwars.dto.PersonajeDTO;

public interface PersonajesRepository {
    public PersonajeDTO findByKeyword(String keyword);
}
