package com.starwars.starwars.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class PersonajesDTO {
    private List<PersonajeDTO> personajes = new ArrayList<PersonajeDTO>();
}
