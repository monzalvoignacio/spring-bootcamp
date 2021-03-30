package com.metros.metros.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HabitacionDto {
    private String nombre;
    private int largo;
    private int ancho;
}
