package com.cristiano.verificadorvenda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class VerificadorVendaApplication {
    public static void main(String[] args) {
        SpringApplication.run(VerificadorVendaApplication.class, args);
    }
}
