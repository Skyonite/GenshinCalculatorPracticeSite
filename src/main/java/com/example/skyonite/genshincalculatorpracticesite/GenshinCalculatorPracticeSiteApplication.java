package com.example.skyonite.genshincalculatorpracticesite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class GenshinCalculatorPracticeSiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(GenshinCalculatorPracticeSiteApplication.class, args);
    }
    
    @Bean
    public PasswordEncoder bcryptEncoder(){
        return new BCryptPasswordEncoder();
    }

}
