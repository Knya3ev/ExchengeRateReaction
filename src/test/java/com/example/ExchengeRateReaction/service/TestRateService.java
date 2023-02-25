package com.example.ExchengeRateReaction.service;


import com.example.ExchengeRateReaction.client.RateClient;
import com.example.ExchengeRateReaction.model.TypeGif;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;

import static org.mockito.BDDMockito.given;

@SpringBootTest
public class TestRateService {

    @MockBean
    private RateService rateService;

    @MockBean
    private RateClient rateClient;

    @Value("${service.rate.app_id}")
    private String app_id;

    @Value("${service.rate.base_currency}")
    private String base_currency;

    private final String request_rate = "EUR";
    private final Double more = 10.0;
    private final Double less = 1.0;

    @Test
    void getRate() {

        given(rateClient.findRate(app_id, request_rate)).willReturn(
                "{\"rates\": {\n" + "\"EUR\": 0.94585,\n" + "\"RUB\": 76.016735\n" + "}}"
        );

        String json = rateClient.findRate(app_id, request_rate);
        JSONObject request = new JSONObject(json);

        Double rate1 = request.getJSONObject("rates").getDouble(base_currency);
        Double rate2 = request.getJSONObject("rates").getDouble(request_rate);

        Assertions.assertNotNull(rate1);
        Assertions.assertNotNull(rate2);
    }

    @Test
    void getTypeGifRich() {
        LocalDate date = LocalDate.now().minusDays(1);

        given(rateService.getRate(request_rate)).willReturn(more);
        given(rateService.getRate(request_rate, date)).willReturn(less);

        TypeGif typeGif = TypeGif.getType(rateService.getRate(request_rate).compareTo(rateService.getRate(request_rate, date)));

        Assertions.assertEquals(TypeGif.rich, typeGif);
    }

    @Test
    void getTypeGifBroke() {
        LocalDate date = LocalDate.now().minusDays(1);

        given(rateService.getRate(request_rate)).willReturn(less);
        given(rateService.getRate(request_rate, date)).willReturn(more);

        TypeGif typeGif = TypeGif.getType(rateService.getRate(request_rate).compareTo(rateService.getRate(request_rate, date)));

        Assertions.assertEquals(TypeGif.broke, typeGif);
    }


}
