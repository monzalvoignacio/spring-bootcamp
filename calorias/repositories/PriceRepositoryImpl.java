package com.example.calorias.repositories;

import com.example.calorias.dto.PriceDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import com.fasterxml.jackson.core.type.*;

import java.io.File;
import java.util.List;
import java.util.Optional;

@Repository
public class PriceRepositoryImpl implements PriceRepository{

    @Override
    public PriceDTO findPriceByLocation(String location) {
        List<PriceDTO> priceDTOS = null;
        priceDTOS = loadDataBase();
        PriceDTO result = null;
        if (priceDTOS != null){
            Optional<PriceDTO> item = priceDTOS.stream()
                    .filter(priceDTO -> priceDTO.getLocation().equals(location))
                    .findFirst();
            if (item.isPresent())
                result = item.get();
        }

        return result;
    }

    private List<PriceDTO> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:prices.json");
        }catch (Exception e){
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<PriceDTO>> typeRef = new TypeReference<List<PriceDTO>>() {};
        List<PriceDTO> priceDTOS = null;

        try {
            priceDTOS = objectMapper.readValue(file, typeRef);

        }catch (Exception e){
            e.printStackTrace();
        }

        return priceDTOS;

    }
}
