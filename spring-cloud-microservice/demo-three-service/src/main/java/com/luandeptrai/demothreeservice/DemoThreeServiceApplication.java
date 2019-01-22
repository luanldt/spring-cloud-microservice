package com.luandeptrai.demothreeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class DemoThreeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoThreeServiceApplication.class, args);
    }

}

