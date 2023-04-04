package com.psl.MoneyControlAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication
@EnableWebMvc
public class StockFilterAPIApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockFilterAPIApplication.class, args);
	}

}
