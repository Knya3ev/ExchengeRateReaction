package com.example.ExchengeRateReaction.service;


import com.example.ExchengeRateReaction.client.GifClient;
import com.example.ExchengeRateReaction.model.TypeGif;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.BDDMockito.given;

@SpringBootTest
public class TestGifService {
    @MockBean
    private GifClient gifClient;

    @Value("${service.gif.api_key}")
    private String api_key;

    @Test
    void getGifLinkRich() {
        TypeGif typeGif = TypeGif.rich;

        given(gifClient.findGif(api_key, typeGif.toString(), "g")).willReturn(
                "{\"data\":{\"embed_url\":\"ff\"}}"
        );

        String json = gifClient.findGif(api_key, typeGif.toString(),"g");

        JSONObject request = new JSONObject(json);
        String result = request.getJSONObject("data").getString("embed_url");

        Assertions.assertNotNull(result);
    }

    @Test
    void getGifLinkBroke() {
        TypeGif typeGif = TypeGif.broke;

        given(gifClient.findGif(api_key, typeGif.toString(), "g")).willReturn(
                "{\"data\":{\"embed_url\":\"ff\"}}"
        );

        String json = gifClient.findGif(api_key, typeGif.toString(),"g");

        JSONObject request = new JSONObject(json);
        String result = request.getJSONObject("data").getString("embed_url");

        Assertions.assertNotNull(result);
    }


}
