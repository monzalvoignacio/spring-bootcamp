package com.links.links.controllers;

import com.links.links.dto.LinkDTO;
import com.links.links.dto.ResponseLinkDTO;
import com.links.links.services.LinkServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.net.URL;

@RestController
public class LinksController {
    @Autowired
    LinkServices linkServices;

    @PostMapping("/links")
    public ResponseEntity createLink(@RequestBody LinkDTO newLinkDTO){
        ResponseLinkDTO res = linkServices.createLink(newLinkDTO);
        isValid(newLinkDTO.getUrl());
        return new ResponseEntity(res, HttpStatus.OK);
    };

    @GetMapping("/links")
    public ResponseEntity redirect(@PathParam("linkId") int linkId, @PathParam("pass") String pass) {
        LinkDTO link = linkServices.findLink(linkId);
        if(link != null) {
            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.set("Location",
                    link.getUrl());
            if(link.getPass().equals(pass)) {
                return ResponseEntity.status(302).headers(responseHeaders).body(null);
            }
            return new ResponseEntity(null, HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity statisticsLink(@PathVariable int linkId) {
        LinkDTO link = linkServices.getLinkInfo(linkId);
        return new ResponseEntity(link, HttpStatus.OK);
    }

    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity invalidateLink(@PathVariable int linkId){
        boolean invalidated = linkServices.invalidateLink(linkId);
        if(invalidated) {
            return new ResponseEntity(null, HttpStatus.OK);
        }
        return new ResponseEntity(null, HttpStatus.NOT_FOUND);

    };

    /* Returns true if url is valid */
    public static boolean isValid(String url)
    {
        /* Try creating a valid URL */
        try {
            new URL(url).toURI();
            return true;
        }

        // If there was an Exception
        // while creating URL object
        catch (Exception e) {
            return false;
        }
    }
}


