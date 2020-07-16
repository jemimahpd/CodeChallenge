package com.demo.tempcalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class TemperatorCalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(TemperatorCalculatorApplication.class, args);
	}

}
