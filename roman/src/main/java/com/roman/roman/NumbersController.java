package com.roman.roman;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class NumbersController {
    @GetMapping(path = "transform")
    public String transform(@PathParam("number") Integer number) {
        return transformToRoman(number);
    }

    private String transformToRoman(Integer num) {
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romanLiterals = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder roman = new StringBuilder();

        for(int i=0;i<values.length;i++) {
            while(num >= values[i]) {
                num -= values[i];
                roman.append(romanLiterals[i]);
            }
        }
        return roman.toString();
    }
}
