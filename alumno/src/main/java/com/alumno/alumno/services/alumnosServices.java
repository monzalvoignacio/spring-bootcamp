package com.alumno.alumno.services;

import com.alumno.alumno.DTOs.AlumnoDTO;
import com.alumno.alumno.DTOs.DiplomaDTO;
import com.alumno.alumno.DTOs.Materia;

public class alumnosServices {
    public static DiplomaDTO newDiploma(AlumnoDTO alumnoDTO) {
        String mensaje = "Ha culminado sus estudios";
        int tot = 0;
        for (Materia m:alumnoDTO.getMaterias()) {
            tot += m.getNota();
        }
        double prom = tot / alumnoDTO.getMaterias().toArray().length;
        if (prom > 9) {
            mensaje = "Felicitaciones!" + mensaje;
        }
        return new DiplomaDTO(mensaje, prom, alumnoDTO);
    }
}
