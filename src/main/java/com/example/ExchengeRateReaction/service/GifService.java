package com.example.ExchengeRateReaction.service;


import com.example.ExchengeRateReaction.client.GifClient;
import com.example.ExchengeRateReaction.model.TypeGif;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GifService {
    @Autowired
    private GifClient gifClient;

    @Value("${service.gif.api_key}")
    private String api_key;

    public String getGifLink(TypeGif typeGif){
        String json =  gifClient.findGif(api_key,typeGif.toString(),null);

        JSONObject request = new JSONObject(json);

        String result = request.getJSONObject("data").getString("embed_url");

        return result;
    }

}
