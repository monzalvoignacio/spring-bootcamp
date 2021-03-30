package com.alumno.alumno.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class AlumnoDTO {
    private String nombre;
    private List<Materia> materias = new ArrayList<Materia>();
}
