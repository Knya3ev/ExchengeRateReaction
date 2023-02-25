package com.example.ExchengeRateReaction.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "client-rate",url = "${service.rate.url}")
public interface RateClient {

    @GetMapping("/latest.json")
    String findRate(@RequestParam("app_id") String api_key,
                    @RequestParam("symbols") String symbols);

    @GetMapping("/historical/{data}.json")
    String findRateData(@RequestParam("data") String data,
                        @RequestParam("app_id") String app_id,
                        @RequestParam("symbols") String symbols);

    @GetMapping("/currencies.json")
    String findAllRateCod(@RequestParam("app_id") String app_id);
}

//   https://openexchangerates.org/api/latest.json?app_id=d20d6bf4cd274f78a6168702fdd368eb&symbols=RUB,EUR
//   https://openexchangerates.org/api/currencies.json?app_id=d20d6bf4cd274f78a6168702fdd368eb