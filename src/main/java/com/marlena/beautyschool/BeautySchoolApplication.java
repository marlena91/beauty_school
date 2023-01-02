package com.marlena.beautyschool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@SpringBootApplication
@EnableJpaRepositories("com.marlena.beautyschool.repository")
@EntityScan("com.marlena.beautyschool.model")
public class BeautySchoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeautySchoolApplication.class, args);
    }



}
