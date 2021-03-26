package com.morse.morse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class CodesController {
    @GetMapping(path = "morse")
    public String decodeMorse(@PathParam("code") String code) {
        Decoder decoder = new Decoder(code);
        return decoder.decode();
    }
}
