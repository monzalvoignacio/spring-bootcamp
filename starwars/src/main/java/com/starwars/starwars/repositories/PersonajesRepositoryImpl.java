package com.starwars.starwars.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.starwars.starwars.dto.PersonajeDTO;
import com.starwars.starwars.dto.PersonajesDTO;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Repository
public class PersonajesRepositoryImpl implements PersonajesRepository{
    @Override
    public PersonajesDTO findByKeyword(String keyword) {
        List<PersonajeDTO> personajeDTOS = null;
        personajeDTOS = loadDataBase();
        List<PersonajeDTO> result = new ArrayList<PersonajeDTO>();
        if (personajeDTOS != null){
            Stream<PersonajeDTO> item = personajeDTOS.stream()
                    .filter(priceDTO -> priceDTO.getName().contains(keyword));

            item.forEach(per -> {
                result.add(per);
            });

        }

        return new PersonajesDTO(result);
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
