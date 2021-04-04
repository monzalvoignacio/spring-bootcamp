package com.example.calorias.repositories;

import com.example.calorias.dto.PriceDTO;

public interface PriceRepository {

    PriceDTO findPriceByLocation(String location);
}
