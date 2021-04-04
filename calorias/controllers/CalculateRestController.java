package com.example.calorias.controllers;

import com.example.calorias.dto.HouseDTO;
import com.example.calorias.dto.HouseResponseDTO;
import com.example.calorias.services.CalculateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculateRestController {

  @Autowired
  private CalculateServiceImpl calculateService;

  @PostMapping("/calculate")
  public HouseResponseDTO calculate(@RequestBody HouseDTO house){
    return calculateService.calculate(house);
  }
}