package com.marlena.beautyschool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@SpringBootApplication
public class BeautySchoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeautySchoolApplication.class, args);
	}

}
