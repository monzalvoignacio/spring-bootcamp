package com.example.calorias.services;

import com.example.calorias.dto.HouseDTO;
import com.example.calorias.dto.HouseResponseDTO;

public interface CalculateService {

    HouseResponseDTO calculate(HouseDTO house);

}
