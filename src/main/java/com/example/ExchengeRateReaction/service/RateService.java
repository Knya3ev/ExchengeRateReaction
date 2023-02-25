package com.example.ExchengeRateReaction.service;

import com.example.ExchengeRateReaction.client.RateClient;
import com.example.ExchengeRateReaction.model.TypeGif;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.time.LocalDate;


@Service
public class RateService {

    @Autowired
    private RateClient rateClient;

    @Value("${service.rate.app_id}")
    private String app_id;

    @Value("${service.rate.base_currency}")
    private String base_currency;


    public TypeGif getTypeGif(String currencyCod) {
        LocalDate date = LocalDate.now().minusDays(1);

        return TypeGif.getType(this.getRate(currencyCod)
                .compareTo(this.getRate(currencyCod, date)));
    }

    public Double getCrossRate(Double x, Double y) {
        return x * y;
    }

    public Double getRate(String comparisonCurrency) {
        String json = rateClient.findRate(app_id, base_currency + "," + comparisonCurrency);


    JSONObject request = new JSONObject(json);

    Double base = request.getJSONObject("rates").getDouble(base_currency);
    Double currency = request.getJSONObject("rates").getDouble(comparisonCurrency);

        return

    getCrossRate(base, currency);

    }

    public Double getRate(String comparisonCurrency, LocalDate date) {
        String json = rateClient.findRateData(date.toString(), app_id, base_currency + "," + comparisonCurrency);

        JSONObject request = new JSONObject(json);

        Double base = request.getJSONObject("rates").getDouble(base_currency);
        Double currency = request.getJSONObject("rates").getDouble(comparisonCurrency);

        return getCrossRate(base, currency);
    }

}
