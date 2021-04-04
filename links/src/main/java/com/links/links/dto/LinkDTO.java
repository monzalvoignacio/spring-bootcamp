package com.links.links.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;

@Data
public class LinkDTO {
    private String url;
    private int count;
    private String pass;

    public LinkDTO(String url, String pass) {
        this.url = url;
        this.count = 0;
        this.pass = pass;
    }

    public void incrementCount() {
        count++;
    }
}
