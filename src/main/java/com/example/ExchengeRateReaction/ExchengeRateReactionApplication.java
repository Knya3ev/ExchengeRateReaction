package com.example.ExchengeRateReaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ExchengeRateReactionApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExchengeRateReactionApplication.class, args);
	}

}
