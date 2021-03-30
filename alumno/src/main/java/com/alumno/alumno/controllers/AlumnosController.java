package com.alumno.alumno.controllers;

import com.alumno.alumno.DTOs.AlumnoDTO;
import com.alumno.alumno.services.alumnosServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlumnosController {
    @PostMapping("/alumno")
    public ResponseEntity newAlumno(@RequestBody AlumnoDTO alumnoDTO) {
        return new ResponseEntity(alumnosServices.newDiploma(alumnoDTO), HttpStatus.OK);
    }
}
