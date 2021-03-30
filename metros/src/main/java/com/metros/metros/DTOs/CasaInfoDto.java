package com.metros.metros.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class CasaInfoDto {
    private int tamano;
    private int precio;
    private HabitacionDto maxHab;
    private List<Integer> tamanos = new ArrayList<Integer>();
}
