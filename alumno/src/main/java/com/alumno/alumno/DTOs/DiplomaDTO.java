package com.alumno.alumno.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DiplomaDTO {
    private String mensaje;
    private double promedio;
    private AlumnoDTO alumno;
}
