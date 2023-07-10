package com.pay.mode.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PayModeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PayModeServiceApplication.class, args);
	}

}
