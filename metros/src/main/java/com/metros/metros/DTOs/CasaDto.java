package com.metros.metros.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class CasaDto {
    private String nombre;
    private String direccion;
    private List<HabitacionDto> habitaciones = new ArrayList<HabitacionDto>();
}
