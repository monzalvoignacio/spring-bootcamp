package com.starwars.starwars.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.starwars.starwars.dto.PersonajeDTO;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.List;
import java.util.Optional;

@Repository
public class PersonajesRepositoryImpl implements PersonajesRepository{
    @Override
    public PersonajeDTO findByKeyword(String keyword) {
        List<PersonajeDTO> personajeDTOS = null;
        personajeDTOS = loadDataBase();
        PersonajeDTO result = null;
        if (personajeDTOS != null){
            Optional<PersonajeDTO> item = personajeDTOS.stream()
                    .filter(priceDTO -> priceDTO.getName().contains(keyword))
                    .findFirst();
            if (item.isPresent())
                result = item.get();
        }

        return result;
    }

    private List<PersonajeDTO> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
        }catch (Exception e){
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<PersonajeDTO>> typeRef = new TypeReference<List<PersonajeDTO>>() {};
        List<PersonajeDTO> personajeDTOS = null;

        try {
            personajeDTOS = objectMapper.readValue(file, typeRef);

        }catch (Exception e){
            e.printStackTrace();
        }

        return personajeDTOS;

    }
}
