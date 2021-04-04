package com.example.calorias.services;


import com.example.calorias.dto.HouseDTO;
import com.example.calorias.dto.HouseResponseDTO;
import com.example.calorias.dto.PriceDTO;
import com.example.calorias.dto.RoomDTO;
import com.example.calorias.repositories.PriceRepository;
import org.springframework.stereotype.Service;

@Service
public class CalculateServiceImpl implements CalculateService {

   private PriceRepository priceRepository;

  public CalculateServiceImpl(PriceRepository priceRepository) {
    this.priceRepository = priceRepository;
  }

  private int calculatePrice(Integer result, String location){
    PriceDTO priceByLocation = priceRepository.findPriceByLocation(location);
    Integer price = priceByLocation != null? priceByLocation.getPrice() : 800;
    return result * price;
  }

  private void calculateRoomSquareFeet(HouseDTO house, HouseResponseDTO response) {
    Integer totalSquareFeet = 0;
    RoomDTO biggest = null;
    Integer maxRoom = 0;
    for (RoomDTO room : house.getRooms()) {
      Integer squareFeet = room.getSquareFeet();
      totalSquareFeet += squareFeet;
      if (biggest == null || squareFeet > maxRoom){
        biggest = room;
        maxRoom = squareFeet;
      }
    }
    response.setSquareFeet(totalSquareFeet);
    response.setBiggest(biggest);
  }

  @Override
  public HouseResponseDTO calculate(HouseDTO house) {
    HouseResponseDTO response = new HouseResponseDTO(house);
    calculateRoomSquareFeet(house, response);
    response.setPrice(calculatePrice(response.getSquareFeet(), house.getLocation()));
    return response;
  }
}
