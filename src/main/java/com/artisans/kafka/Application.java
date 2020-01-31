package com.artisans.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Supplier;

@SpringBootApplication
public class Application {

    public static void main(String[] arg) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public Supplier<String> produc() {
        return () ->
        {
            System.out.println("Sending message");
            return "Help!!!";
        };
    }
}
