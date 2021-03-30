package com.metros.metros.controllers;

import com.metros.metros.DTOs.CasaDto;
import com.metros.metros.services.CasaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CasasController {
    @PostMapping("/casa")
    public ResponseEntity casaInfo(@RequestBody CasaDto casaDto) {
        return new ResponseEntity(CasaService.getCasaInfo(casaDto), HttpStatus.OK);
    }
}
