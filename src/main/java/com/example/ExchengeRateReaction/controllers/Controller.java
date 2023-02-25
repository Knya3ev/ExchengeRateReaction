package com.example.ExchengeRateReaction.controllers;


import com.example.ExchengeRateReaction.model.TypeGif;
import com.example.ExchengeRateReaction.service.GifService;
import com.example.ExchengeRateReaction.service.RateService;
import com.example.ExchengeRateReaction.util.RequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/")
public class Controller {

    @Autowired
    private RateService rateService;

    @Autowired
    private GifService gifService;


    @GetMapping("rates")
    public ResponseEntity getGif(@RequestParam(name = "currency") String currency) {
        TypeGif typeGif = rateService.getTypeGif(currency);
        String response = gifService.getGifLink(typeGif);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(response));

        return new ResponseEntity(headers, HttpStatus.SEE_OTHER);

    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException(Exception e) {
        return RequestHandler.getBadRequest(e);
    }

}
