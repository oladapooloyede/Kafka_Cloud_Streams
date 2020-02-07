package com.artisans.kafka;

import com.users.CustomerRegistrationRequest;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;
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

    @Bean
    public Function<KStream<String, CustomerRegistrationRequest>, KStream<String, CustomerRegistrationRequest>>  operat() {

        return s -> s
                .mapValues( v -> {
                    return CustomerRegistrationRequest
                            .newBuilder()
                            .setFullName(v.getFullName() + "stream")
                            .setEmail(v.getEmail())
                            .setPassword(v.getPassword())
                            .setPhoneNumber(v.getPhoneNumber())
                            .build();
                });
    }
}
