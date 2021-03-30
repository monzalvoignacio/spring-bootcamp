package com.metros.metros.services;

import com.metros.metros.DTOs.CasaDto;
import com.metros.metros.DTOs.CasaInfoDto;
import com.metros.metros.DTOs.HabitacionDto;

import java.util.ArrayList;
import java.util.List;

public class CasaService {
    public static CasaInfoDto getCasaInfo(CasaDto casa) {
        int max = 0;
        HabitacionDto maxHab = casa.getHabitaciones().get(0);
        int tot = 0;
        List<Integer> tamanos = new ArrayList<Integer>();
        for (HabitacionDto h:casa.getHabitaciones()) {
            int tamano = h.getAncho()*h.getLargo();
            tot += tamano;
            tamanos.add(tamano);
            if (tamano > max) {
                max = tamano;
                maxHab = h;
            }
        }
        return new CasaInfoDto(tot, tot*800, maxHab, tamanos);
    }
}
